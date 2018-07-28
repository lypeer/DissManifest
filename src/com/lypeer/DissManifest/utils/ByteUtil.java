package com.lypeer.DissManifest.utils;

public class ByteUtil {

    public static byte[] copyBytesWithFlip(byte[] bytes, int offset, int length, int byteNum) {
        final byte[] tempBytes = copyBytesWithoutFlip(bytes, offset, length);
        return flipBytes(tempBytes, byteNum);
    }

    public static byte[] copyBytesWithFlip(byte[] bytes, int offset, int length) {
        return copyBytesWithFlip(bytes, offset, length, Constant.Length.FOUR_BYTES);
    }

    public static byte[] copyBytesWithoutFlip(byte[] bytes, int offset, int length) {
        if (bytes == null
                || bytes.length <= 0
                || offset < 0
                || length <= 0
                || (offset + length > bytes.length)) {
            return null;
        }

        final byte[] resultBytes = new byte[length];
        for (int i = 0; i < offset + length; i++) {
            if (i >= offset) {
                resultBytes[i - offset] = bytes[i];
            }
        }
        return resultBytes;
    }

    public static byte[] flipBytes(byte[] bytes, int byteNum) {
        if (bytes == null
                || bytes.length <= 0
                || byteNum <= 0) {
            return null;
        }


        // Manifest里面存的二进制是高低异位的，所以需要进行翻转，比如0300 0800，翻转后就是0008 0003
        final byte[] resultBytes = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i += byteNum) {
            for (int j = 0; j < byteNum; j++) {
                resultBytes[i + j] = bytes[i + byteNum - j - 1];
            }
        }

        return resultBytes;
    }

}
