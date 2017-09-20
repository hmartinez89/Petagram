package com.hmartinez.petagram.presentadorListaMascotas;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hmartinez.petagram.R;
import com.hmartinez.petagram.db.ConstructorMascotas;
import com.hmartinez.petagram.listaMascotasView.IListasMascotasView;
import com.hmartinez.petagram.pojo.DataSet;
import com.hmartinez.petagram.pojo.Usuario;
import com.hmartinez.petagram.restAPI.ConstantesRestAPI;
import com.hmartinez.petagram.restAPI.EndpointsApi;
import com.hmartinez.petagram.restAPI.adapter.RestAPIAdapter;
import com.hmartinez.petagram.restAPI.model.MascotaResponse;
import com.hmartinez.petagram.restAPI.model.UsuarioResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaMascotasPresenter implements IListaMascotasPresenter {

    private IListasMascotasView IListaMascotasView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<DataSet> mascotas;
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public ListaMascotasPresenter(IListasMascotasView IListaMascotasView, Context context) {
        this.IListaMascotasView = IListaMascotasView;
        this.context = context;

        if (determinarCuenta().equalsIgnoreCase("_ZdR17")){
            obtenerRecentMedia_SELF();}
        else{
            obtener_USER_ID_OTHER();}
    }

    @Override
    public void obtener_USER_ID_OTHER(){
        final RestAPIAdapter adapter = new RestAPIAdapter();
        Gson gsonUsuario = adapter.construyeGsonDeserializadorUsuario();
        EndpointsApi endpointsApi = adapter.establecerConexion(gsonUsuario);

        Call<UsuarioResponse> usuarioResponseCall = endpointsApi.getUserInfo(determinarCuenta(), ConstantesRestAPI.ACCESS_TOKEN);
        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse = response.body();
                usuarios = usuarioResponse.getUsuarios();

                obtenerRecentMedia_OTHER();
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {
                Toast.makeText(context, "Falló la conexión de usuario.", Toast.LENGTH_LONG).show();
                Log.i("FALLO CONEXION USUARIO", t.toString());
            }
        });
    }

    @Override
    public void obtenerRecentMedia_SELF() {
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
                Toast.makeText(context, call.request().url().toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "Falló la conexión.", Toast.LENGTH_LONG).show();
                Log.i("FALLO LA CONEXION", t.toString());
            }
        });
    }

    @Override
    public void obtenerRecentMedia_OTHER(){
        RestAPIAdapter adapter = new RestAPIAdapter();
        Gson gsonRecentMedia = adapter.construyeGsonDeserializadorRecentMedia();
        EndpointsApi endpointsApi = adapter.establecerConexion(gsonRecentMedia);

        Call<MascotaResponse> mascotaResponseCall = endpointsApi.getUserRecentMedia(usuarios.get(0).getId());
        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotas = mascotaResponse.getMascotas();
                mostrarMascotasRV();
                Toast.makeText(context, call.request().url().toString(), Toast.LENGTH_LONG).show();
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

    @Override
    public String determinarCuenta() {
        SharedPreferences cuenta = context
                .getSharedPreferences(context.getString(R.string.spConfigurarCuenta), Context.MODE_PRIVATE);

        return cuenta.getString(context.getString(R.string.spDatoUsuario), "_ZdR17");
    }
}