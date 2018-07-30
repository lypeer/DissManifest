package com.lypeer.DissManifest;

import com.lypeer.DissManifest.api.Parser;
import com.lypeer.DissManifest.bean.ManifestBean;
import com.lypeer.DissManifest.parser.ManifestParser;

import static com.lypeer.DissManifest.utils.Constant.MANIFEST_PATH;

public class Main {


    public static void main(String[] args) {
        final Parser<ManifestBean> parser = new ManifestParser();
        final ManifestBean manifestBean = parser.parse(MANIFEST_PATH);

        if (manifestBean != null)
            System.out.println(manifestBean.toString());
        else
            System.out.println("parse manifest fail");
    }
}
