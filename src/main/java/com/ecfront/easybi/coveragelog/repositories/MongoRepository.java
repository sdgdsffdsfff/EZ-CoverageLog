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

    public E get(E id){
          return null;
    }

    public List<E> find(T queryObject,int pageNumber,int pageSize){
          return null;
    }

}
