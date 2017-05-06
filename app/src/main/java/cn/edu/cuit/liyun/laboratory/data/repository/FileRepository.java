package cn.edu.cuit.liyun.laboratory.data.repository;

import com.avos.avoscloud.AVFile;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by jianglei on 2017/5/4.
 */

public class FileRepository {
    private static FileRepository instance;

    public static FileRepository getInstance() {
        if (instance == null)
            instance = new FileRepository();
        return instance;
    }

    public String save(File file) {
        try {
            AVFile avFile = AVFile.withFile(file.getName(), file);
            avFile.save();
            return avFile.getUrl();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String save(byte[] data) {
        try {
            String name = String.valueOf(System.currentTimeMillis());
            AVFile avFile = new AVFile(name, data);
            avFile.save();
            return avFile.getUrl();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
