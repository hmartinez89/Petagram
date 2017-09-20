package com.hmartinez.petagram.restAPI;

import com.hmartinez.petagram.configurarCuentaPresenter.ConfigurarCuentaPresenter;

public final class ConstantesRestAPI {

    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "6038494184.ae4892b.a67b13b0b9c54ac28535ec0614eea120";

    //My Recent Media
    public static final String KEY_GET_RECENT_MEDIA_SELF_USER = "users/self/media/recent/";
    public static final String KEY_ACCESS_TOKEN = "?access_token=" + ACCESS_TOKEN;
    public static final String URL_GET_RECENT_MEDIA_SELF_USER = KEY_GET_RECENT_MEDIA_SELF_USER + KEY_ACCESS_TOKEN;

    //Any user Recent Media
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/";
    public  static final String KEY_GET_RECENT_MEDIA_ANY_USER = "media/recent/";

    //Any user info
    public static final String KEY_GET_USER_INFO = "users/search";
}