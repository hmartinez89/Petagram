package com.hmartinez.petagram.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hmartinez.petagram.pojo.DataSet;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper{
    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascotas = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                                         ConstantesBaseDatos.TABLE_MASCOTAS_ID      + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                         ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE  + " TEXT, " +
                                         ConstantesBaseDatos.TABLE_MASCOTAS_FOTO    + " INTEGER" +
                                         ")";

        String queryCrearTablaLikesMascotas = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA + "(" +
                                              ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                              ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + " INTEGER, " +
                                              ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES + " INTEGER, " +
                                              "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + ") " +
                                              "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ")" +
                                              ")";
        db.execSQL(queryCrearTablaMascotas);
        db.execSQL(queryCrearTablaLikesMascotas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA);
        onCreate(db);
    }

    public ArrayList<DataSet> obtenerTodasLasMascotas(){
        ArrayList<DataSet> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        /*while(registros.moveToNext()){
            DataSet mascotaActual = new DataSet();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setsNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES +")" +
                                "as Likes FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA + " WHERE " +
                                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if(registrosLikes.moveToNext())
                mascotaActual.setLikes(registrosLikes.getInt(0));
            else
                mascotaActual.setLikes(0);

            mascotas.add(mascotaActual);
        }*/

        db.close();
        return mascotas;
    }

    public ArrayList<DataSet> obtenerLasMascotasFavoritas(){
        ArrayList<DataSet> mascotasFavoritas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA + " ORDER BY "
                       + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID + " DESC LIMIT 5";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        /*while(registros.moveToNext()){
            DataSet mascotaFavoritaActual = new DataSet();
            mascotaFavoritaActual.setId(registros.getInt(1));

            String queryLikes = "SELECT COUNT (" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES +
                                ") as Likes FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA + " WHERE " +
                                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID + "<=" + registros.getInt(0) +
                                " AND " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" +
                                mascotaFavoritaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if(registrosLikes.moveToNext())
                mascotaFavoritaActual.setLikes(registrosLikes.getInt(0));

            String queryFoto = "SELECT " + ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE +", " +
                               ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + " FROM " +
                               ConstantesBaseDatos.TABLE_MASCOTAS + " WHERE " +
                               ConstantesBaseDatos.TABLE_MASCOTAS_ID + "=" + mascotaFavoritaActual.getId();

            Cursor registrosNombreYFoto = db.rawQuery(queryFoto, null);
            if(registrosNombreYFoto.moveToNext()){
                mascotaFavoritaActual.setFullName(registrosNombreYFoto.getString(0));
                //mascotaFavoritaActual.setUrlFoto(registrosNombreYFoto.getInt(1));
            }
            mascotasFavoritas.add(mascotaFavoritaActual);
        }*/
        db.close();
        return mascotasFavoritas;
    }
    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTA, null,contentValues);
        db.close();
    }

    public int obtenerLikesMascota(DataSet mascota){
        int likes = 0;

        String query = "SELECT COUNT (" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES + ")" +
                       " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                       " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if(registros.moveToNext())
            likes = registros.getInt(0);

        db.close();

        return likes;
    }

    public int contarRegistrosTotales(){
        int registrosTotales = 0;

        String query = "SELECT COUNT (" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ")" +
                       " FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if(registros.moveToNext())
            registrosTotales = registros.getInt(0);

        return registrosTotales;
    }
}