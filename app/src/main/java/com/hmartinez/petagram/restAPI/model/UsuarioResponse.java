package com.hmartinez.petagram.restAPI.model;

import com.hmartinez.petagram.pojo.Usuario;

import java.util.ArrayList;

public class UsuarioResponse {
    ArrayList<Usuario> usuarios;

    public ArrayList<Usuario> getUsuarios() { return usuarios; }

    public void setUsuario(ArrayList<Usuario> usuarios) { this.usuarios = usuarios; }
}
