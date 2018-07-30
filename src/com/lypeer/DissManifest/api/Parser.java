package com.lypeer.DissManifest.api;

import com.sun.istack.internal.Nullable;

public interface Parser<R> {

    @Nullable
    R parse(String filePath);
}
