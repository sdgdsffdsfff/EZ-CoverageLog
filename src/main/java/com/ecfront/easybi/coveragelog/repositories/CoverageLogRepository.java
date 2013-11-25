package com.ecfront.easybi.coveragelog.repositories;

import com.ecfront.easybi.coveragelog.Entity.CoverageLog;
import com.ecfront.easybi.utils.MongoHelper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class CoverageLogRepository extends MongoRepository<CoverageLog, Long> {

    @Override
    protected DBObject customConvertObject(final CoverageLog object) {
        DBObject dbObject = new BasicDBObject();
        if (null != object.getId()) {
            dbObject.put("id", object.getId());
        }
        if (null != object.getCode()) {
            dbObject.put("code", object.getCode());
        }
        if (null != object.getEnterTime()) {
            dbObject.put("enterTime", object.getEnterTime());
        }
        if (null != object.getFinishTime()) {
            dbObject.put("finishTime", object.getFinishTime());
        }
        if (null != object.getUseTime()) {
            dbObject.put("useTime", object.getUseTime());
        }
        return dbObject;
    }

    @Override
    protected CoverageLog customConvertObject(DBObject object) {
        CoverageLog coverageLog = new CoverageLog();
        if (object.containsField("id")) {
            coverageLog.setId((Long) object.get("id"));
        }
        if (object.containsField("code")) {
            coverageLog.setCode((Long) object.get("code"));
        }
        if (object.containsField("enterTime")) {
            coverageLog.setEnterTime((Long) object.get("enterTime"));
        }
        if (object.containsField("finishTime")) {
            coverageLog.setFinishTime((Long) object.get("finishTime"));
        }
        if (object.containsField("useTime")) {
            coverageLog.setUseTime((Long) object.get("useTime"));
        }
        return coverageLog;
    }


    private static volatile CoverageLogRepository INSTANCE;

    private CoverageLogRepository() {
    }

    public static CoverageLogRepository getInstance() {
        if (null == INSTANCE) {
            synchronized (CoverageLogRepository.class) {
                if (null == INSTANCE) {
                    INSTANCE = new CoverageLogRepository();
                }
            }
        }
        return INSTANCE;
    }
}
