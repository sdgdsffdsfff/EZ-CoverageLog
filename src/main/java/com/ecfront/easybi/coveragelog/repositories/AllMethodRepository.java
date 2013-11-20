package com.ecfront.easybi.coveragelog.repositories;

import com.ecfront.easybi.coveragelog.document.AllMethod;
import com.ecfront.easybi.coveragelog.document.CoverageLog;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllMethodRepository extends MongoRepository<AllMethod, ObjectId> {

    public CoverageLog findByClazzAndMethod(String clazz, String method);

}
