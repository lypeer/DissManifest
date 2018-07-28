package com.lypeer.DissManifest.bean;

import java.util.List;

import static com.lypeer.DissManifest.utils.Constant.WRAP;

public class StringChunkBean {

    private String mType;
    private int mSize;
    private int mStringCount;
    private int mStyleCount;
    private int mStringPoolOffset;
    private int mStylePoolOffset;
    private List<Integer> mStringOffsetList;
    private List<Integer> mStyleOffsetList;
    private List<String> mStringList;
    private List<String> mStyleList;

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public int getSize() {
        return mSize;
    }

    public void setSize(int size) {
        mSize = size;
    }

    public int getStringCount() {
        return mStringCount;
    }

    public void setStringCount(int stringCount) {
        mStringCount = stringCount;
    }

    public int getStyleCount() {
        return mStyleCount;
    }

    public void setStyleCount(int styleCount) {
        mStyleCount = styleCount;
    }

    public List<Integer> getStringOffsetList() {
        return mStringOffsetList;
    }

    public int getStringPoolOffset() {
        return mStringPoolOffset;
    }

    public void setStringPoolOffset(int stringPoolOffset) {
        mStringPoolOffset = stringPoolOffset;
    }

    public int getStylePoolOffset() {
        return mStylePoolOffset;
    }

    public void setStylePoolOffset(int stylePoolOffset) {
        mStylePoolOffset = stylePoolOffset;
    }

    public void setStringOffsetList(List<Integer> stringOffsetList) {
        mStringOffsetList = stringOffsetList;
    }

    public List<Integer> getStyleOffsetList() {
        return mStyleOffsetList;
    }

    public void setStyleOffsetList(List<Integer> styleOffsetList) {
        mStyleOffsetList = styleOffsetList;
    }

    public List<String> getStringList() {
        return mStringList;
    }

    public void setStringList(List<String> stringList) {
        mStringList = stringList;
    }

    public List<String> getStyleList() {
        return mStyleList;
    }

    public void setStyleList(List<String> styleList) {
        mStyleList = styleList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Manifest String Trunk：")
                .append(WRAP)
                .append("type：").append(mType)
                .append(WRAP)
                .append("size：").append(mSize)
                .append(WRAP)
                .append("string count：").append(mStringCount)
                .append(WRAP)
                .append("style count：").append(mStyleCount)
                .append(WRAP)
                .append("string pool offset：").append(mStringPoolOffset)
                .append(WRAP).append("style pool offset：")
                .append(mStylePoolOffset)
                .append(WRAP);

        if (mStringList != null && mStringList.size() > 0) {
            for (String s : mStringList) {
                sb.append(s);
                sb.append(WRAP);
            }
        }
        return sb.toString();
    }
}
