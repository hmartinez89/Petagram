package com.hmartinez.petagram.restAPI.deserializador;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.hmartinez.petagram.pojo.Usuario;
import com.hmartinez.petagram.restAPI.JsonKeys;
import com.hmartinez.petagram.restAPI.model.UsuarioResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class UsuarioDeserializador implements JsonDeserializer<UsuarioResponse>{

    @Override
    public UsuarioResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        Gson gson = new Gson();
        UsuarioResponse usuarioResponse = gson.fromJson(json, UsuarioResponse.class);
        JsonObject usuarioResponseObject = json.getAsJsonObject();

        JsonArray usuarioResponseDataArray = usuarioResponseObject.getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);
        Log.i("Datos Array", "deserialize: " + usuarioResponseDataArray.toString());
        JsonObject usuarioJson = usuarioResponseDataArray.get(0).getAsJsonObject();

        String id = usuarioJson.get(JsonKeys.USER_ID).getAsString();
        String username = usuarioJson.get(JsonKeys.USER_NAME).getAsString();
        String fullName = usuarioJson.get(JsonKeys.USER_FULL_NAME).getAsString();

        Usuario usuarioActual = new Usuario(id, username, fullName);
        usuarios.add(usuarioActual);
        usuarioResponse.setUsuario(usuarios);

        return usuarioResponse;
    }
}