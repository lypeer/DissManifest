package com.lypeer.DissManifest.bean;

import com.lypeer.DissManifest.utils.Constant;

public class ManifestBean {

    private HeaderBean mHeaderBean;
    private StringChunkBean mStringChunkBean;
    private ResourceIdChunkBean mResourceIdChunkBean;

    public ResourceIdChunkBean getResourceIdChunkBean() {
        return mResourceIdChunkBean;
    }

    public void setResourceIdChunkBean(ResourceIdChunkBean resourceIdChunkBean) {
        mResourceIdChunkBean = resourceIdChunkBean;
    }

    public HeaderBean getHeaderBean() {
        return mHeaderBean;
    }

    public void setHeaderBean(HeaderBean headerBean) {
        mHeaderBean = headerBean;
    }

    public StringChunkBean getStringChunkBean() {
        return mStringChunkBean;
    }

    public void setStringChunkBean(StringChunkBean stringChunkBean) {
        mStringChunkBean = stringChunkBean;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        writeToSb(sb, mHeaderBean, "Header parse fail");
        writeToSb(sb, mStringChunkBean, "String chunk parse fail");
        writeToSb(sb, mResourceIdChunkBean, "Resource Id chunk parse fail");
        return sb.toString();
    }

    private void writeToSb(StringBuilder sb, Object bean, String failMessge) {
        if (bean != null) {
            sb.append(bean.toString());
        } else {
            sb.append(failMessge);
        }
        sb.append(Constant.WRAP);
    }
}
