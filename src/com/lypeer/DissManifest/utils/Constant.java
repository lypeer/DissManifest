package com.lypeer.DissManifest.utils;

public class Constant {

    public static final String MANIFEST_PATH = "C:\\Users\\lypeerluo\\Desktop\\AndroidSafe\\apktool\\decodeManifest\\AndroidManifest.xml";
    public final static char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    public static final String WRAP = "\r\n";

    public interface Offset {
        int
                MAGIC_OFFSET = 0,// 魔数
                FILE_SIZE_OFFSET = 4,// 文件大小
                CHUNK_TYPE_OFFSET = 8,// String chunk 的类型
                CHUNK_SIZE_OFFSET = 12,// String chunk 的大小
                CHUNK_STRING_COUNT_OFFSET = 16,// String 的个数
                CHUNK_STYLE_COUNT_OFFSET = 20,// 样式的个数
                CHUNK_STRING_POOL_OFFSET_OFFSET = 28,// 字符串池的偏移，这是相对于String trunk的开头而言的
                CHUNK_STYLE_POOL_OFFSET_OFFSET = 32, // 样式池的偏移，同上
                CHUNK_STRING_OFFSETS_OFFSET = 36;// 每个String的偏移值，其长度应为String count * 4
    }

    public interface Length {
        int
                FOUR_BYTES = 4,
                TWO_BYTES = 2;
    }

}
