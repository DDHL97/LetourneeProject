package com.example.diego.letournee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {
    Button btn_huasca, btn_huichapan, btn_realMonte, btn_MinChico,btn_Tecozautla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btn_huasca = (Button) findViewById(R.id.btn_huascap);
        btn_huichapan =(Button) findViewById(R.id.btn_Huichapanp);
        btn_MinChico = (Button) findViewById(R.id.btn_MinChicop);
        btn_realMonte = (Button) findViewById(R.id.btn_realMontep);
        btn_Tecozautla = (Button) findViewById(R.id.btn_tecozautlap);

        btn_huasca.setOnClickListener(onClickListener);
        btn_huichapan.setOnClickListener(onClickListener);
        btn_realMonte.setOnClickListener(onClickListener);
        btn_Tecozautla.setOnClickListener(onClickListener);
        btn_MinChico.setOnClickListener(onClickListener);
    }

    private  View.OnClickListener onClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            if (v == btn_huasca) {
                goHuasca();
            }else if (v == btn_huichapan){
                goHuichapan();
            }else if (v == btn_MinChico){
                goMinChico();
            }else if (v == btn_Tecozautla){
                goTecozautla();
            }else if (v == btn_realMonte){
                goRealMonte();
            }

        }
    };

    private void goHuasca(){
        Intent intent = new Intent(this, HOC1.class);
        startActivity(intent);
        finish();
    }
    private void goRealMonte(){
        Intent intent = new Intent(this, RMC1.class);
        startActivity(intent);
        finish();
    }
    private void goHuichapan(){
        Intent intent = new Intent(this, HC1.class);
        startActivity(intent);
        finish();
    }
    private void goMinChico(){
        Intent intent = new Intent(this, MCH1.class);
        startActivity(intent);
        finish();
    }

    private void goTecozautla(){
        Intent intent = new Intent(this, TTL1.class);
        startActivity(intent);
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        menu.add(menu.NONE,100,menu.NONE,"Salir");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.itemRegistrar:
                RegistrarseMenu();
                break;
            case R.id.itemIniciarSesion:
                IniciarSesionMenu();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void RegistrarseMenu(){
        Intent intent = new Intent(this, Registrar.class);
        startActivity(intent);
        finish();
    }
    public void IniciarSesionMenu(){
        Intent intent = new Intent(this, IniciarSesion.class);
        startActivity(intent);
        finish();
    }
}
