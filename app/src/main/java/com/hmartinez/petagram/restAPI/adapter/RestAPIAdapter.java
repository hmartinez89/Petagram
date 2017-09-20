package com.hmartinez.petagram.restAPI.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hmartinez.petagram.restAPI.ConstantesRestAPI;
import com.hmartinez.petagram.restAPI.EndpointsApi;
import com.hmartinez.petagram.restAPI.deserializador.MascotaDeserializador;
import com.hmartinez.petagram.restAPI.deserializador.UsuarioDeserializador;
import com.hmartinez.petagram.restAPI.model.MascotaResponse;
import com.hmartinez.petagram.restAPI.model.UsuarioResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestAPIAdapter {

    public EndpointsApi establecerConexion(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestAPI.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointsApi.class);
    }

    public Gson construyeGsonDeserializadorRecentMedia(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializador());

        return gsonBuilder.create();
    }

    public Gson construyeGsonDeserializadorUsuario(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(UsuarioResponse.class, new UsuarioDeserializador());

        return gsonBuilder.create();
    }
}
