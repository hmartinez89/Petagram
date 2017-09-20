package com.hmartinez.petagram.restAPI;

import com.hmartinez.petagram.restAPI.model.MascotaResponse;
import com.hmartinez.petagram.restAPI.model.UsuarioResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface EndpointsApi {

    @GET(ConstantesRestAPI.URL_GET_RECENT_MEDIA_SELF_USER)
    Call<MascotaResponse> getRecentMedia();

    @GET(ConstantesRestAPI.KEY_GET_USER_INFO)
    Call<UsuarioResponse> getUserInfo(@Query("q") String user_name, @Query("access_token") String access_token);

    @GET(ConstantesRestAPI.KEY_GET_RECENT_MEDIA_USER+"{user-id}/"+ConstantesRestAPI.KEY_GET_RECENT_MEDIA_ANY_USER+ConstantesRestAPI.KEY_ACCESS_TOKEN)
    Call<MascotaResponse> getUserRecentMedia(@Path("user-id") String user_id);
}
