package com.ecfront.easybi.coveragelog.repositories;

public class ScannedMethodRepository {

      public void save(List<>)




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
