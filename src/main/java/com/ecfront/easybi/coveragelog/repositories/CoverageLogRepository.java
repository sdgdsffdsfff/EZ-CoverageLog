package com.ecfront.easybi.coveragelog.repositories;

import com.ecfront.easybi.coveragelog.document.CoverageLog;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoverageLogRepository extends MongoRepository<CoverageLog, ObjectId> {

    public List<CoverageLog> findByClazzAndMethodAndEnterTimeGreaterThanAndFinishTimeLessThanOrderByUseTimeDesc(String clazz,String method,long enterTime,long finishTime, Pageable page);

}
