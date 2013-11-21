package com.ecfront.easybi.coveragelog.repositories;

import com.ecfront.easybi.coveragelog.document.ScannedMethod;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScannedMethodRepository extends MongoRepository<ScannedMethod, ObjectId> {

}
