package com.charmingwong.wxnews;

/**
 * Created by 56223 on 2016/11/27.
 */

public interface OnResponseCallback {
    public void onResponseSuccess(Object response);

    public void onResponseError(Exception e);
}
