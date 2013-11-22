package com.ecfront.easybi.coveragelog.repositories;

import java.util.List;

public abstract class MongoRepository<T,E> {

      public void save(List<T> newObjects){

      }

    public void save(T newObject){

    }

    public void update(T newObject){

    }

    public void delete(T deleteObject){

    }

    public void get(E id){

    }

    public void find(T queryObject,int pageNumber,int pageSize,){

    }

}
