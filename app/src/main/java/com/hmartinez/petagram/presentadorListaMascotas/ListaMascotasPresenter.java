package com.hmartinez.petagram.presentadorListaMascotas;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hmartinez.petagram.db.ConstructorMascotas;
import com.hmartinez.petagram.listaMascotasView.IListasMascotasView;
import com.hmartinez.petagram.pojo.DataSet;
import com.hmartinez.petagram.restAPI.EndpointsApi;
import com.hmartinez.petagram.restAPI.adapter.RestAPIAdapter;
import com.hmartinez.petagram.restAPI.model.MascotaResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaMascotasPresenter implements IListaMascotasPresenter{

    private IListasMascotasView IListaMascotasView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<DataSet> mascotas;

    public ListaMascotasPresenter(IListasMascotasView IListaMascotasView, Context context) {
        this.IListaMascotasView = IListaMascotasView;
        this.context = context;
        obtenerRecentMedia();
    }

    @Override
    public void obtenerRecentMedia(){
        RestAPIAdapter adapter = new RestAPIAdapter();
        Gson gsonRecentMedia = adapter.construyeGsonDeserializadorRecentMedia();
        EndpointsApi endpointsApi = adapter.establecerConexion(gsonRecentMedia);

        Call<MascotaResponse> mascotaResponseCall = endpointsApi.getRecentMedia();
        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotas = mascotaResponse.getMascotas();
                mostrarMascotasRV();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "Falló la conexión.", Toast.LENGTH_LONG).show();
                Log.i("FALLO LA CONEXION", t.toString());
            }
        });
    }

    @Override //Obtiene mascotas de la base de datos
    public void obtenerMascotas() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        IListaMascotasView.inicializarAdaptadorRV(IListaMascotasView.crearAdaptador(mascotas));
        IListaMascotasView.generarGridLayout();
    }
}
