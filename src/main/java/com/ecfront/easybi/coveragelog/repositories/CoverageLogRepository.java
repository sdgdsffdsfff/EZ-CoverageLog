package com.ecfront.easybi.coveragelog.repositories;

import com.ecfront.easybi.coveragelog.Entity.CoverageLog;
import com.ecfront.easybi.utils.MongoHelper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

public class CoverageLogRepository {

    public void save(final CoverageLog object) {
        MongoHelper.insert(new BasicDBObject() {{
            put("code", object.getCode());
            put("enterTime", object.getEnterTime());
            put("finishTime", object.getFinishTime());
            put("useTime", object.getUseTime());
        }}, collection);
    }

    private DBCollection collection = MongoHelper.useCollection("CoverageLog");

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
