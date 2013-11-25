package com.ecfront.easybi.coveragelog.repositories;

import com.ecfront.easybi.coveragelog.Entity.PK;
import com.ecfront.easybi.utils.MongoHelper;
import com.ecfront.easybi.vo.PageVO;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class MongoRepository<T, E> {

    public void save(List<T> newObjects) {
        List<DBObject> dbObjects = new ArrayList<DBObject>();
        for (final T object : newObjects) {
            dbObjects.add(convertObject(object));
        }
        MongoHelper.insertAll(dbObjects, collection);
    }

    public void save(T newObject) {
        MongoHelper.insert(convertObject(newObject), collection);
    }

    public void update(T newObject) {
        MongoHelper.update(convertObject(get(getPKValue(newObject))), convertObject(newObject), collection);
    }

    public void delete(E id) {
        MongoHelper.delete(convertObject(get(id)), collection);
    }

    public void drop() {
        MongoHelper.drop(collection);
    }

    public T get(E id) {
        T object = null;
        try {
            object = entityClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setPKValue(object, id);
        DBObject dbObject = MongoHelper.get(convertObject(object), collection);
        return convertObject(dbObject);
    }

    public PageVO<T> find(T queryObject, int pageNumber, int pageSize) {
        return find(queryObject, pageNumber, pageSize, null);
    }

    public PageVO<T> find(T queryObject, int pageNumber, int pageSize, Map<String, SortType> sort) {
        DBObject dbObject = convertObject(queryObject);
        long total = MongoHelper.count(dbObject, collection);
        DBObject sortObject = null;
        if (null != sort) {
            sortObject = new BasicDBObject();
            for (Map.Entry<String, SortType> sortEntry : sort.entrySet()) {
                sortObject.put(sortEntry.getKey(), sortEntry.getValue().getCode());
            }
        }
        List<DBObject> dbObjects = MongoHelper.pageQuery(dbObject, pageNumber * pageSize, pageSize, sortObject, collection);
        if (null != dbObjects && dbObjects.size() > 0) {
            List<T> results = new ArrayList<T>();
            for (DBObject object : dbObjects) {
                results.add(convertObject(object));
            }
            return new PageVO<T>(pageNumber, pageSize, total, results);
        }
        return null;
    }

    protected DBObject convertObject(T object) {
        if (null == object) {
            return null;
        }
        return customConvertObject(object);
    }

    protected abstract DBObject customConvertObject(T object);

    protected T convertObject(DBObject object) {
        if (null == object) {
            return null;
        }
        return customConvertObject(object);
    }

    protected abstract T customConvertObject(DBObject object);

    private E getPKValue(T object) {
        Object obj = null;
        try {
            obj = pkGetMethod.invoke(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null != obj) {
            return (E) obj;
        }
        return null;
    }

    private void setPKValue(T object, E pk) {
        try {
            pkSetMethod.invoke(object, pk);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private DBCollection collection;

    private Class<T> entityClass;
    private Class<E> pkClass;
    private List<Field> fields;
    private Method pkGetMethod;
    private Method pkSetMethod;

    private void init() {
        Type[] type = ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments();
        entityClass = (Class<T>) type[0];
        pkClass = (Class<E>) type[1];
        fields = new ArrayList<Field>();
        Field[] allFields = entityClass.getFields();
        for (Field field : allFields) {
            fields.add(field);
            if (field.isAnnotationPresent(PK.class)) {
                String fieldName = field.getName();
                try {
                    pkGetMethod = this.getClass().getMethod("get" + getMethodName(fieldName));
                    pkSetMethod = this.getClass().getMethod("set" + getMethodName(fieldName), pkClass);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String getMethodName(String str) {
        //TODO
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    {
        init();
        collection = MongoHelper.useCollection(entityClass.getSimpleName());
    }


}
