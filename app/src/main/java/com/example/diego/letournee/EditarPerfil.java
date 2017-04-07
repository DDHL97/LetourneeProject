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
import android.widget.EditText;
import android.widget.Toast;

public class EditarPerfil extends AppCompatActivity {

    Cursor fila, fila2;
    EditText edt_nombre, edt_ap_pat, edt_ap_mat, edt_account_name, edt_age, edt_email;
    String id_user = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                  //      .setAction("Action", null).show();
                registrar();
                goBack();
            }
        });

        edt_nombre = (EditText) findViewById(R.id.edt_nombre_edit);
        edt_ap_pat = (EditText) findViewById(R.id.edt_ap_pat_edit);
        edt_ap_mat = (EditText) findViewById(R.id.edt_ap_mat_edit);
        edt_account_name = (EditText) findViewById(R.id.edt_account_name_edit);
        edt_age = (EditText) findViewById(R.id.edt_age_edit);
        edt_email = (EditText) findViewById(R.id.edt_email_edit);

        Intent intent1= getIntent();
        Bundle extras = intent1.getExtras();
        id_user =(String)extras.get("id_user");
        UsuarioSQLiteHelper usuario = new UsuarioSQLiteHelper(this, "DBguia", null, 1);
        SQLiteDatabase db = usuario.getWritableDatabase();
        fila = db.rawQuery("SELECT nombre, ap_paterno, ap_materno, account_name, age, email FROM usuarios WHERE id_user = '" + id_user+"'",null);
        if (fila.moveToFirst()) {
            String nombre = fila.getString(0);
            String ap_pat = fila.getString(1);
            String ap_mat = fila.getString(2);
            String account_name = fila.getString(3);
            String age = fila.getString(4);
            String correo = fila.getString(5);
            edt_nombre.setText(nombre);
            edt_ap_pat.setText(ap_pat);
            edt_ap_mat.setText(ap_mat);
            edt_account_name.setText(account_name);
            edt_age.setText(age);
            edt_email.setText(correo);
        }
    }


    public void registrar(){
        String nombre = edt_nombre.getText().toString();
        String ap_paterno = edt_ap_pat.getText().toString();
        String ap_materno = edt_ap_mat.getText().toString();
        String account_name = edt_account_name.getText().toString();
        String age = edt_age.getText().toString();
        String email = edt_email.getText().toString();

        //validamos que se ingresen todos los campos
        if (nombre.length() >0 && ap_paterno.length() > 0 && ap_materno.length()>0 && account_name.length() >0 && age.length()>0 && email.length()>0) {
            //abrimos la base de datos de clientes
            UsuarioSQLiteHelper usuario = new UsuarioSQLiteHelper(this, "DBguia", null, 1);
            SQLiteDatabase db = usuario.getWritableDatabase();
            db.execSQL("UPDATE usuarios SET nombre = '"+nombre+"', ap_paterno = '"+ ap_paterno+"', ap_materno = '"+ap_materno +"', account_name = '"+account_name+"', age = '"+age+"', email = '" + email + "' WHERE  id_user = '" + id_user+"'");
            //String stsql = "INSERT INTO usuarios (nombre, ap_paterno, ap_materno, account_name, age, email, password) VALUES ('" + nombre + "','" + ap_paterno + "','" + ap_materno + "','" + account_name + "','" + age + "','" + email + "','" + password + "');";
            db.close();
            Toast.makeText(this, "Cambios guardados con exito", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this, "Problemas al guardar cambios ", Toast.LENGTH_SHORT).show();
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
        Intent intent = new Intent(this, Perfil.class);
        String auxPass= id_user;
        intent.putExtra("id_user",auxPass);
        startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed() {
        goBack();
    }
}
