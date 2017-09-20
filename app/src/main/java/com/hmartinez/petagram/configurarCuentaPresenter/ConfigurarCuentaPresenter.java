package com.hmartinez.petagram.configurarCuentaPresenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Toast;

import com.hmartinez.petagram.R;
import com.hmartinez.petagram.configurarCuentaView.IConfigurarCuentaView;

public class ConfigurarCuentaPresenter implements IConfigurarCuentaPresenter{
    public static String usuarioActual = "_ZdR17";
    private IConfigurarCuentaView IConfigurarCuentaView;
    private Context context;

    public ConfigurarCuentaPresenter(IConfigurarCuentaView IConfigurarCuentaView,Context context){
        this.IConfigurarCuentaView = IConfigurarCuentaView;
        this.context = context;
    }

    @Override
    public void guardarCuenta(View v) {
        String usuario ="";
        TextInputEditText tietUsuario = (TextInputEditText) v.findViewById(R.id.tiet_usuario_configurar_cuenta);
        usuario = tietUsuario.getText().toString();

        SharedPreferences cuenta = context
                .getSharedPreferences(context.getString(R.string.spConfigurarCuenta), Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = cuenta.edit();
        editor.putString(context.getString(R.string.spDatoUsuario), usuario);
        editor.commit();

        Toast.makeText(context, "Cuenta Guardada", Toast.LENGTH_LONG).show();
        usuarioActual = usuario;
    }
}
