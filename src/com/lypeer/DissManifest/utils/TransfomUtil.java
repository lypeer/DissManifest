package com.lypeer.DissManifest.utils;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import static com.lypeer.DissManifest.utils.Constant.HEX_ARRAY;

public class TransfomUtil {

    public static String bytesToHex(byte[] bytes) {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }


        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }

        return new String(hexChars);
    }

    public static int bytesToInt(byte[] bytes) {
        if (bytes == null || bytes.length <= 0) {
            System.out.println("transform bytes to int wrong");
            return 0;
        }

        byte[] result = bytes;
        while (result.length < 4) {
            final byte[] tempBytes = new byte[result.length + 1];
            tempBytes[0] = 0;
            for (int i = 1; i < tempBytes.length; i++) {
                tempBytes[i] = result[i - 1];
            }
            result = tempBytes;
        }

        try {
            return ByteBuffer.wrap(result).getInt();
        } catch (Exception e) {
            return 0;
        }
    }

    public static ArrayList<Integer> bytesToIntList(byte[] bytes) {
        //todo
        return new ArrayList<>();
    }

}
