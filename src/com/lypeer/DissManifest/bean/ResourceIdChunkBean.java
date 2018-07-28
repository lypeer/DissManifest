package com.lypeer.DissManifest.bean;

import com.lypeer.DissManifest.utils.Constant;

import java.util.List;

import static com.lypeer.DissManifest.utils.Constant.WRAP;

public class ResourceIdChunkBean {

    private String mType;
    private int mSize;
    private List<Integer> mResourceIdList;

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

    public List<Integer> getResourceIdList() {
        return mResourceIdList;
    }

    public void setResourceIdList(List<Integer> resourceIdList) {
        mResourceIdList = resourceIdList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Manifest Resource Id Chunk：")
                .append(WRAP)
                .append("type：").append(mType)
                .append(WRAP)
                .append("size：").append(mSize)
                .append(WRAP);

        if (mResourceIdList != null && mResourceIdList.size() > 0) {
            for (Integer i : mResourceIdList) {
                sb.append("id：").append(i)
                        .append(WRAP);
            }
        }
        return sb.toString();
    }
}
