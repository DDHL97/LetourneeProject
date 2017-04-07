package com.example.diego.letournee;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Inicio extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView tv_name_perfil, tv_email_perfil, tv_user;
    ImageView img_user_perfil;
    Cursor fila;
    String password = "";
    String nombre = "";
    NavigationView navigationView;
    String id_user="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        tv_name_perfil = (TextView) findViewById(R.id.tv_name_perfil);
        tv_email_perfil = (TextView) findViewById(R.id.id_email_perfil);
        tv_user = (TextView) findViewById(R.id.tv_usuario);
        Intent intent1 = getIntent();
        Bundle extras = intent1.getExtras();
        password = (String) extras.get("password");
        UsuarioSQLiteHelper usuario = new UsuarioSQLiteHelper(this, "DBguia", null, 1);
        SQLiteDatabase db = usuario.getWritableDatabase();
        fila = db.rawQuery("SELECT nombre, id_user FROM usuarios WHERE password = '" + password+"'",null);
        if (fila.moveToFirst()) {
            nombre = fila.getString(0);
            id_user = fila.getString(1);
            tv_user.setText(id_user);
        }

        navigationView.setOnClickListener(onClickListener);
    }

    private  View.OnClickListener onClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            if (v == navigationView) {
                tv_name_perfil.setText(nombre);

            }
        }
    };

    private void goLogin(){
        Intent intent = new Intent(this, IniciarSesion.class);
        startActivity(intent);
        finish();
    }
    private void goPerfil(){
        Intent intent = new Intent(this, Perfil.class);
        String auxPass= tv_user.getText().toString();
        intent.putExtra("id_user",auxPass);
        startActivity(intent);
        finish();
    }
/*
    Thread sqlThread = new Thread() {
        public void run() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                // "jdbc:mysql://IP:PUERTO/DB", "USER", "PASSWORD");
                // Si estás utilizando el emulador de android y tenes el mysql en tu misma PC no utilizar 127.0.0.1 o localhost como IP, utilizar 10.0.2.2
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://jnc6n3xpbgc3kek2.chr7pe7iynqr.eu-west-1.rds.amazonaws.com/wkxzh9zdiar3e279", "adnoolsuxxfj06s3", "epymerq47eyabfhm");
                //En el stsql se puede agregar cualquier consulta SQL deseada.

                String stsql = "SELECT nombre FROM usuarios;";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(stsql);
                rs.next();
                System.out.println( rs.getString(1) );
                conn.close();
            } catch (SQLException se) {
                System.out.println("oops! No se puede conectar. Error: " + se.toString());
            } catch (ClassNotFoundException e) {
                System.out.println("oops! No se encuentra la clase. Error: " + e.getMessage());
            }
        }
    };*/



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_perfil) {
            // Handle the camera action
            goPerfil();
        } else if (id == R.id.nav_gallery) {
        } else if (id == R.id.nav_slideshow) {
        } else if (id == R.id.nav_manage) {
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }else if (id == R.id.nav_exit) {
            goLogin();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
