package com.ecfront.easybi.coveragelog.repositories;

import com.ecfront.easybi.coveragelog.Entity.ScannedMethod;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class ScannedMethodRepository extends MongoRepository<ScannedMethod, Long> {

    @Override
    protected DBObject customConvertObject(final ScannedMethod object) {
        DBObject dbObject = new BasicDBObject();
        if (null != object.getId()) {
            dbObject.put("id", object.getId());
        }
        if (null != object.getCode()) {
            dbObject.put("code", object.getCode());
        }
        if (null != object.getPackageName()) {
            dbObject.put("packageName", object.getPackageName());
        }
        if (null != object.getClassName()) {
            dbObject.put("className", object.getClassName());
        }
        if (null != object.getMethodName()) {
            dbObject.put("methodName", object.getMethodName());
        }
        if (null != object.getMethodParameterTypes()) {
            dbObject.put("methodParameterType", object.getMethodParameterTypes());
        }
        return dbObject;
    }

    @Override
    protected ScannedMethod customConvertObject(DBObject object) {
        ScannedMethod scannedMethod = new ScannedMethod();
        if (object.containsField("id")) {
            scannedMethod.setId((Long) object.get("id"));
        }
        if (object.containsField("code")) {
            scannedMethod.setCode((Long) object.get("code"));
        }
        if (object.containsField("packageName")) {
            scannedMethod.setPackageName(object.get("packageName").toString());
        }
        if (object.containsField("className")) {
            scannedMethod.setClassName(object.get("className").toString());
        }
        if (object.containsField("methodName")) {
            scannedMethod.setMethodName(object.get("methodName").toString());
        }
        if (object.containsField("methodParameterType")) {
            BasicDBList basicDBList= (BasicDBList) object.get("methodParameterType");
            scannedMethod.setMethodParameterTypes(basicDBList.toArray(new String[basicDBList.size()]));
        }
        return scannedMethod;
    }

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
