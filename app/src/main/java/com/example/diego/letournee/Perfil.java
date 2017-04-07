package com.example.diego.letournee;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Perfil extends AppCompatActivity {
Cursor fila;
    TextView tv_nombre, tv_ap_paterno, tv_ap_materno, tv_account_name, tv_age, tv_email;
    String id_user= "", password = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                goEditar();
            }
        });

        tv_nombre = (TextView) findViewById(R.id.tv_nombre_perfil);
        tv_ap_paterno = (TextView) findViewById(R.id.tv_ap_paterno_perfil);
        tv_ap_materno = (TextView) findViewById(R.id.tv_ap_materno_perfil);
        tv_account_name = (TextView) findViewById(R.id.tv_account_name_perfil);
        tv_age = (TextView) findViewById(R.id.tv_age_perfil);
        tv_email = (TextView) findViewById(R.id.tv_email_perfil);

        Intent intent1= getIntent();
        Bundle extras = intent1.getExtras();
        id_user =(String)extras.get("id_user");
        UsuarioSQLiteHelper usuario = new UsuarioSQLiteHelper(this, "DBguia", null, 1);
        SQLiteDatabase db = usuario.getWritableDatabase();
        fila = db.rawQuery("SELECT id_user, nombre, ap_paterno, ap_materno, account_name, age, email, password FROM usuarios WHERE id_user = '" + id_user+"'",null);
        if (fila.moveToFirst()) {
            String id = fila.getString(0);
            String nombre = fila.getString(1);
            String ap_pat = fila.getString(2);
            String ap_mat = fila.getString(3);
            String account_name = fila.getString(4);
            String age = fila.getString(5);
            String correo = fila.getString(6);
            password = fila.getString(7);
            tv_nombre.setText(nombre);
            tv_ap_paterno.setText(ap_pat);
            tv_ap_materno.setText(ap_mat);
            tv_account_name.setText(account_name);
            tv_age.setText(age);
            tv_email.setText(correo);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                goBack();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void goBack(){
        Intent intent = new Intent(this, Inicio.class);
        String auxPass= password;
        intent.putExtra("password",auxPass);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        goBack();
    }

    public void goEditar(){
        Intent intent = new Intent(this, EditarPerfil.class);
        String auxPass= id_user;
        intent.putExtra("id_user",auxPass);
        startActivity(intent);
        finish();
    }
}
