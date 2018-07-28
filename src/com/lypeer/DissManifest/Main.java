package com.lypeer.DissManifest;

import com.lypeer.DissManifest.bean.HeaderBean;
import com.lypeer.DissManifest.bean.ManifestBean;
import com.lypeer.DissManifest.bean.ResourceIdChunkBean;
import com.lypeer.DissManifest.bean.StringChunkBean;
import com.lypeer.DissManifest.utils.ByteUtil;

import java.util.ArrayList;
import java.util.List;

import static com.lypeer.DissManifest.utils.ByteUtil.copyBytesWithFlip;
import static com.lypeer.DissManifest.utils.Constant.Length.*;
import static com.lypeer.DissManifest.utils.Constant.MANIFEST_PATH;
import static com.lypeer.DissManifest.utils.Constant.Offset.*;
import static com.lypeer.DissManifest.utils.FileUtil.readFileToByteArray;
import static com.lypeer.DissManifest.utils.TransfomUtil.bytesToHex;
import static com.lypeer.DissManifest.utils.TransfomUtil.bytesToInt;
import static com.lypeer.DissManifest.utils.TransfomUtil.bytesToIntList;

public class Main {


    public static void main(String[] args) {
        final ManifestBean manifestBean = new ManifestBean();

        final byte[] originBytes = readFileToByteArray(MANIFEST_PATH);
        if (originBytes == null || originBytes.length <= 0) {
            System.out.println("Read fail , or file empty");
            return;
        }

        manifestBean.setHeaderBean(parseHeader(originBytes));
        manifestBean.setStringChunkBean(parseStringChunk(originBytes));
        manifestBean.setResourceIdChunkBean(parseResourceIdChunk(originBytes));

        System.out.println(manifestBean.toString());
    }

    private static ResourceIdChunkBean parseResourceIdChunk(byte[] originBytes) {
        return null;
    }

    private static StringChunkBean parseStringChunk(byte[] bytes) {
        final StringChunkBean stringChunkBean = new StringChunkBean();

        final byte[] typeBytes = ByteUtil.copyBytesWithFlip(bytes, CHUNK_TYPE_OFFSET, FOUR_BYTES);
        final byte[] sizeBytes = ByteUtil.copyBytesWithFlip(bytes, CHUNK_SIZE_OFFSET, FOUR_BYTES);
        final byte[] stringCountBytes = ByteUtil.copyBytesWithFlip(bytes, CHUNK_STRING_COUNT_OFFSET, FOUR_BYTES);
        final byte[] styleCountBytes = ByteUtil.copyBytesWithFlip(bytes, CHUNK_STYLE_COUNT_OFFSET, FOUR_BYTES);
        final byte[] stringPoolOffsetBytes = ByteUtil.copyBytesWithFlip(bytes, CHUNK_STRING_POOL_OFFSET_OFFSET, FOUR_BYTES);
        final byte[] stylePoolOffsetBytes = ByteUtil.copyBytesWithFlip(bytes, CHUNK_STYLE_POOL_OFFSET_OFFSET, FOUR_BYTES);

        final int size = bytesToInt(sizeBytes);
        final int stringPoolOffset = bytesToInt(stringPoolOffsetBytes);
        final int stylePoolOffset = bytesToInt(stylePoolOffsetBytes);
        final int stringCount = bytesToInt(stringCountBytes);
        final int styleCount = bytesToInt(styleCountBytes);

        final byte[] stringOffsetsBytes = ByteUtil.copyBytesWithFlip(bytes, CHUNK_STRING_OFFSETS_OFFSET, stringCount * FOUR_BYTES);
        final byte[] styleOffsetsBytes = ByteUtil.copyBytesWithFlip(bytes, CHUNK_STRING_OFFSETS_OFFSET + stringCount * FOUR_BYTES, styleCount * FOUR_BYTES);

        // String pool开始的位置是String trunk的起始位置加上String pool相对于它的偏移
        final int stringContentOffset = CHUNK_TYPE_OFFSET + stringPoolOffset;
        final byte[] stringPoolBytes = ByteUtil.copyBytesWithoutFlip(bytes, stringContentOffset, size);

        final List<String> stringList = parseStringPoolBytes(stringPoolBytes);

        stringChunkBean.setType(bytesToHex(typeBytes));
        stringChunkBean.setSize(size);
        stringChunkBean.setStringCount(stringCount);
        stringChunkBean.setStyleCount(styleCount);

        stringChunkBean.setStringPoolOffset(stringPoolOffset);
        stringChunkBean.setStylePoolOffset(stylePoolOffset);

        stringChunkBean.setStringOffsetList(bytesToIntList(stringOffsetsBytes));
        stringChunkBean.setStyleOffsetList(bytesToIntList(styleOffsetsBytes));

        stringChunkBean.setStringList(stringList);

        return stringChunkBean;
    }

    private static List<String> parseStringPoolBytes(byte[] stringPoolBytes) {
        final ArrayList<String> stringList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int curStringLength = 0;
        int curIndex = 0;
        for (int i = 0; i < stringPoolBytes.length; ) {
            if (curIndex == 0) {
                curStringLength = bytesToInt(copyBytesWithFlip(stringPoolBytes, i, TWO_BYTES, TWO_BYTES));
                i += TWO_BYTES;
                curIndex++;
                continue;
            }

            final byte[] curStringBytes = ByteUtil.copyBytesWithFlip(stringPoolBytes, i, TWO_BYTES, TWO_BYTES);
            i += TWO_BYTES;
            if (curIndex > curStringLength && bytesToInt(curStringBytes) == 0) {
                stringList.add(sb.toString());
                sb = new StringBuilder();
                curIndex = 0;
                continue;
            }

            final String curString = new String(curStringBytes);
            curIndex++;
            sb.append(curString.trim());
        }

        return stringList;
    }

    private static HeaderBean parseHeader(byte[] bytes) {
        final HeaderBean headerBean = new HeaderBean();
        final byte[] magicBytes = ByteUtil.copyBytesWithFlip(bytes, MAGIC_OFFSET, FOUR_BYTES);
        final byte[] fileSizeBytes = ByteUtil.copyBytesWithFlip(bytes, FILE_SIZE_OFFSET, FOUR_BYTES);

        headerBean.setMagicNum(bytesToHex(magicBytes));
        headerBean.setSize(bytesToInt(fileSizeBytes));
        return headerBean;
    }


}
