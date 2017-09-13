package com.hmartinez.petagram.db;

public final class ConstantesBaseDatos {
    public static final String DATABASE_NAME            = "petagram";
    public static final int DATABASE_VERSION            = 1;
    public static final String TABLE_MASCOTAS           = "mascotas";
    public static final String TABLE_MASCOTAS_ID        = "id";
    public static final String TABLE_MASCOTAS_NOMBRE    = "nombre";
    public static final String TABLE_MASCOTAS_FOTO      = "foto";

    public static final String TABLE_LIKES_MASCOTA              = "likes_mascotas";
    public static final String TABLE_LIKES_MASCOTA_ID           = "id";
    public static final String TABLE_LIKES_MASCOTA_ID_MASCOTA   = "id_contacto";
    public static final String TABLE_LIKES_MASCOTA_NUMERO_LIKES = "numero_likes";
}
