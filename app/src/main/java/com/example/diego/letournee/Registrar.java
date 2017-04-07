package com.example.diego.letournee;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.sql.Connection;
import  java.sql.DriverManager;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.security.MessageDigest.*;

public class Registrar extends AppCompatActivity {
Button btn_registrar;
    EditText edt_name, edt_ap_paterno, edt_ap_materno, edt_account_name, edt_age, edt_email, edt_password;
    Connection conexionMySQL = null;

    String nombre = "";
    String ap_paterno = "";
    String ap_materno = "";
    String account_name = "";
    String age = "";
    String email ="";
    String password = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                registrar();
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        edt_name = (EditText) findViewById(R.id.edt_name);
        edt_ap_paterno = (EditText) findViewById(R.id.edt_ap_paterno);
        edt_ap_materno  = (EditText) findViewById(R.id.edt_ap_materno);
        edt_account_name  = (EditText) findViewById(R.id.edt_account_name);
        edt_age  = (EditText) findViewById(R.id.edt_age);
        edt_email  = (EditText) findViewById(R.id.edt_email);
        edt_password  = (EditText) findViewById(R.id.edt_password);

        btn_registrar = (Button) findViewById(R.id.btn_registrar);
        btn_registrar.setOnClickListener(onClickListener);

    }
    private  View.OnClickListener onClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            if (v == btn_registrar) {
                registrar();

            }
        }
    };

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
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed() {
        goBack();
    }


    public void registrar(){
         nombre = edt_name.getText().toString();
         ap_paterno = edt_ap_paterno.getText().toString();
         ap_materno = edt_ap_materno.getText().toString();
         account_name = edt_account_name.getText().toString();
         age = edt_age.getText().toString();
         email = edt_email.getText().toString();
         password = edt_password.getText().toString();
       // MessageDigest md5 = MessageDigest.getInstance("MD5");
        // md5.update(StandardCharsets.UTF_8.encode(edt_password.getText().toString()));
        //String md5_pass = String.format("%032x", new BigInteger(1,md5.digest()));

        if (password.isEmpty() || password.length()<4 ){
            edt_password.setError("Escriba una contraseña mayor a 4 caracteres");
        }
        //validamos que se ingresen todos los campos
        if (nombre.length() >0 && ap_paterno.length() > 0 && ap_materno.length()>0 && account_name.length() >0 && age.length()>0 && email.length()>0 && password.length()>0) {

            //abrimos la base de datos de clientes
            UsuarioSQLiteHelper usuario = new UsuarioSQLiteHelper(this, "DBguia", null, 1);
            SQLiteDatabase db = usuario.getWritableDatabase();
            db.execSQL("INSERT INTO usuarios (nombre, ap_paterno, ap_materno, account_name, age, email, password) VALUES ('" + nombre + "','" + ap_paterno + "','" + ap_materno + "','" + account_name + "','" + age + "','" + email + "','" + password + "');");
            String stsql = "INSERT INTO usuarios (nombre, ap_paterno, ap_materno, account_name, age, email, password) VALUES ('" + nombre + "','" + ap_paterno + "','" + ap_materno + "','" + account_name + "','" + age + "','" + email + "','" + password + "');";
            db.close();
            Toast.makeText(this, "El usuario se ha registrado con exito", Toast.LENGTH_SHORT).show();
            edt_name.setText("");
            edt_ap_paterno.setText("");
            edt_ap_materno.setText("");
            edt_account_name.setText("");
            edt_age.setText("");
            edt_email.setText("");
            edt_password.setText("");
        } else if (nombre.isEmpty()) {
            edt_name.setError("Campo obligatorio");
        }else if (ap_paterno.isEmpty()) {
            edt_ap_paterno.setError("Campo obligatorio");
        }else if (ap_materno.isEmpty()) {
            edt_ap_materno.setError("Campo obligatorio");
        }else if (account_name.isEmpty()) {
            edt_account_name.setError("Campo obligatorio");
        }else if (age.length() == 0) {
            edt_age.setError("Campo obligatorio");
        }else if (email.isEmpty()) {
            edt_email.setError("Campo obligatorio");
            //Toast.makeText(this, "Por favor de llenar los campos correspondientes", Toast.LENGTH_SHORT).show();
        }else if (nombre.length() >0 && ap_paterno.length() == 0 && ap_materno.length() == 0 && account_name.length() == 0 && age.length()==0 && email.length()==0 && password.length()==0){
            edt_name.setError("Campo obligatorio");
            edt_ap_paterno.setError("Campo obligatorio");
            edt_ap_materno.setError("Campo obligatorio");
            edt_age.setError("Campo obligatorio");
            edt_email.setError("Campo obligatorio");
        }
    }


}
