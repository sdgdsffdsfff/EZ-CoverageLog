package com.ecfront.easybi.coveragelog.repositories;

import com.ecfront.easybi.coveragelog.Entity.ScannedMethod;
import com.ecfront.easybi.utils.MongoHelper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import java.util.ArrayList;
import java.util.List;

public class ScannedMethodRepository {

    public void saveAll(List<ScannedMethod> objects) {
        List<DBObject> dbObjects = new ArrayList<DBObject>();
        for (final ScannedMethod object : objects) {
            dbObjects.add(new BasicDBObject() {{
                put("code", object.getCode());
                put("packageName", object.getPackageName());
                put("className", object.getClassName());
                put("methodName", object.getMethodName());
                put("methodParameterType", object.getMethodParameterTypes());
            }});
        }
        MongoHelper.insertAll(dbObjects, collection);
    }


    private DBCollection collection = MongoHelper.useCollection("ScannedMethod");

    private static volatile ScannedMethodRepository INSTANCE;

    private ScannedMethodRepository() {
    }

    public static ScannedMethodRepository getInstance() {
        if (null == INSTANCE) {
            synchronized (ScannedMethodRepository.class) {
                if (null == INSTANCE) {
                    INSTANCE = new ScannedMethodRepository();
                }
            }
        }
        return INSTANCE;
    }
}
