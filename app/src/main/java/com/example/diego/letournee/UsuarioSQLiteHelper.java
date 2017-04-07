package com.example.diego.letournee;

import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Diego on 05/04/2017.
 */

public class UsuarioSQLiteHelper extends SQLiteOpenHelper {
    // Se crea una variable que contenga la sentencia SQL para la creación de la tabla
    String sql = "CREATE TABLE usuarios ( id_user INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, ap_paterno TEXT, ap_materno TEXT, account_name TEXT, age TEXT, email TEXT, password TEXT)";

    public UsuarioSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory   , int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Este metodo se ejecuta automaticamente cuando la base de datos no existe
        // La primera vez que se hace el llamado a la clase se crea la Base de Datos
        db.execSQL(sql);
        db.execSQL("INSERT INTO usuarios (nombre, ap_paterno, ap_materno, account_name, age, email, password) VALUES ('Diego','Hernandez','Lopez','DDHL',19,'diego_8_1997@hotmail.com','cisco');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Este metodo se ejecuta cuando se detecta que la version de la base de datos
        // cambió, por lo que se debe definir todos los procesos de migracion de la estructura
        // anterior a la estructura nueva.
        // Se eliminara la tabla existente y se creara nuevamente.
        db.execSQL("UPDATE TABLE IF EXISTS usuarios");
        db.execSQL(sql);

    }
}
