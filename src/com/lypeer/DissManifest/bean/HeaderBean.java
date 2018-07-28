package com.lypeer.DissManifest.bean;

import com.lypeer.DissManifest.utils.Constant;

import static com.lypeer.DissManifest.utils.TransfomUtil.bytesToHex;

public class HeaderBean {

    private String mMagicNum;
    private int mSize;

    public String getMagicNum() {
        return mMagicNum;
    }

    public void setMagicNum(String magicNum) {
        mMagicNum = magicNum;
    }

    public int getSize() {
        return mSize;
    }

    public void setSize(int size) {
        mSize = size;
    }

    @Override
    public String toString() {

        return "Manifest Header：" +
                Constant.WRAP +
                "magicNum：" + mMagicNum +
                Constant.WRAP +
                "fileSize：" + mSize;
    }
}
