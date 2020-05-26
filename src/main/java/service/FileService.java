package service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileService {

    public FileService() {
    }

    public static FileService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static FileService INSTANCE = new FileService();
    }

    public void addToFile(String file,String content){
        if(!Files.exists(Paths.get(file))) {
            try (PrintStream out = new PrintStream(file)) {
                out.println(content);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try(PrintStream out = new PrintStream(new FileOutputStream(file,true))){
                out.println(content);
                out.flush();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
