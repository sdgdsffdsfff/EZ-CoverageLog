package com.ecfront.easybi.utils;

import com.mongodb.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class MongoHelper {

    private static final Logger logger = LoggerFactory.getLogger(MongoHelper.class);

    private static final String HOST = "mongo.host";
    private static final String PORT = "mongo.port";
    private static final String DB = "mongo.dbname";
    private static final String USER = "mongo.username";
    private static final String PASSWORD = "mongo.password";

    private static volatile MongoClient mongoClient;
    private static volatile DB db;

    static {
        String host = PropertyHelper.get(HOST, "127.0.0.1");
        String port = PropertyHelper.get(PORT, "27017");
        String dbName = PropertyHelper.get(DB);
        String user = PropertyHelper.get(USER);
        String password = PropertyHelper.get(PASSWORD);

        try {
            mongoClient = new MongoClient(host, Integer.valueOf(port));
            db = mongoClient.getDB(dbName);
            if (null != user && null != password && !db.authenticate(user, password.toCharArray())) {
                if (logger.isErrorEnabled()) {
                    logger.error("Auth Error By user:{},password:{}", user, password);
                }
            }
        } catch (UnknownHostException e) {
            if (logger.isErrorEnabled()) {
                logger.error("UnknownHost Error By host:{},port:{}", host, port);
            }
        }
    }

    public void dropDB() {
        db.dropDatabase();
    }

    public static DB useDB() {
        return db;
    }

    public static DBCollection useCollection(String name) {
        return db.getCollection(name);
    }

    public static DBObject get(DBObject queryObject, DBCollection collection) {
        return collection.findOne(queryObject);
    }

    public static void insert(DBObject newObject, DBCollection collection) {
        collection.insert(newObject);
    }

    public static void insertAll(List<DBObject> newObjects, DBCollection collection) {
        collection.insert(newObjects);
    }

    public static void update(DBObject targetObject, DBObject newObject, DBCollection collection) {
        collection.update(targetObject, newObject);
    }

    public static void delete(DBObject deleteObject, DBCollection collection) {
        collection.remove(deleteObject);
    }

    public List<DBObject> pageQuery(DBObject queryObject, int offset, int limit, DBCollection collection) {
        DBCursor cursor = collection.find(queryObject).skip(offset).limit(limit);
        List<DBObject> objects = new ArrayList<DBObject>();
        while (cursor.hasNext()) {
            objects.add(cursor.next());
        }
        cursor.close();
        return objects;
    }

}
