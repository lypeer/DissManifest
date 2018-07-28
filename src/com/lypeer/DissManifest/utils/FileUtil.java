package com.lypeer.DissManifest.utils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FileUtil {

    public static byte[] readFileToByteArray(String filePath) {
        byte[] originBytes = null;
        FileInputStream fis = null;
        ByteArrayOutputStream bos = null;
        try {
            fis = new FileInputStream(filePath);
            bos = new ByteArrayOutputStream();
            final byte[] buffer = new byte[1024];

            int len;
            while ((len = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }

            originBytes = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null && bos != null)
                try {
                    fis.close();
                    bos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }

        return originBytes;
    }

}
