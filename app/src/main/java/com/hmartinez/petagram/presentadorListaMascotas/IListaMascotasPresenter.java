package com.hmartinez.petagram.presentadorListaMascotas;

import com.hmartinez.petagram.pojo.Usuario;

public interface IListaMascotasPresenter {

    public void obtenerRecentMedia_SELF();

    public void obtenerRecentMedia_OTHER();

    public void obtener_USER_ID_OTHER();

    public void obtenerMascotas();

    public void mostrarMascotasRV();

    public String determinarCuenta();
}
