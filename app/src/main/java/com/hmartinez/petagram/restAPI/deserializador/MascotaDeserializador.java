package com.hmartinez.petagram.restAPI.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.hmartinez.petagram.pojo.DataSet;
import com.hmartinez.petagram.restAPI.JsonKeys;
import com.hmartinez.petagram.restAPI.model.MascotaResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MascotaDeserializador implements JsonDeserializer<MascotaResponse>{

    @Override
    public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MascotaResponse mascotaResponse = gson.fromJson(json, MascotaResponse.class);
        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        mascotaResponse.setMascotas(deserializarMascotaDeJson(mascotaResponseData));
        return mascotaResponse;
    }

    private ArrayList<DataSet> deserializarMascotaDeJson(JsonArray mascotaResponseData){
        ArrayList<DataSet> mascotas = new ArrayList<>();

        for(int i=0; i < mascotaResponseData.size(); i++){
            JsonObject mascotaReponseDataObject = mascotaResponseData.get(i).getAsJsonObject();

            JsonObject userJason    = mascotaReponseDataObject.getAsJsonObject(JsonKeys.USER);
            String id               = userJason.get(JsonKeys.USER_ID).getAsString();
            String fullName         = userJason.get(JsonKeys.USER_FULL_NAME).getAsString();

            JsonObject imageJson            = mascotaReponseDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            JsonObject stdResolutionJson    = imageJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);
            String url                      = stdResolutionJson.get(JsonKeys.MEDIA_URL).getAsString();

            JsonObject likesJson = mascotaReponseDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int likes = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            DataSet mascotaActual = new DataSet();
            mascotaActual.setId(id);
            mascotaActual.setFullName(fullName);
            mascotaActual.setUrlFoto(url);
            mascotaActual.setLikes(likes);

            mascotas.add(mascotaActual);
        }

        return mascotas;
    }
}