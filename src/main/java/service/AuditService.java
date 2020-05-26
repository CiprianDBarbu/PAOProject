package service;

import java.io.File;
import java.sql.Timestamp;

public class AuditService {

    private final String file = "AUDITSERVICE";

    public AuditService() {
    }

    public static AuditService getInstance(){
        return AuditService.SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder{
        private static AuditService INSTANCE = new AuditService();
    }

    public void writeLog(String log){
        FileService fileService = FileService.getInstance();
        log += ","+ (new Timestamp(System.currentTimeMillis())) + "," + Thread.currentThread().getName();
        fileService.addToFile(file,log);
    }
}
