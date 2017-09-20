package com.hmartinez.petagram.configurarCuentaView;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.hmartinez.petagram.R;
import com.hmartinez.petagram.configurarCuentaPresenter.ConfigurarCuentaPresenter;
import com.hmartinez.petagram.configurarCuentaPresenter.IConfigurarCuentaPresenter;

public class ConfigurarCuenta extends AppCompatActivity implements IConfigurarCuentaView{
    private TextInputEditText tietUsuario;
    private Button btnGuardar;
    private Toolbar abConfigurarCuenta;
    private IConfigurarCuentaPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.configurar_cuenta);

        generarToolbar();
        presenter = new ConfigurarCuentaPresenter(this, getApplicationContext());

        tietUsuario = (TextInputEditText)findViewById(R.id.tiet_usuario_configurar_cuenta);
        btnGuardar = (Button)findViewById(R.id.btn_guardarUsuario_configurar_cuenta);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarUsuario();
            }
        });
    }

    @Override
    public void generarToolbar() {
        abConfigurarCuenta = (Toolbar)findViewById(R.id.tbGeneral);
        setSupportActionBar(abConfigurarCuenta);
        getSupportActionBar().setLogo(R.drawable.icons8_cat_footprint_filled_50);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void guardarUsuario() {
        presenter.guardarCuenta(tietUsuario);
    }
}