package com.example.leon.appmodelogeral.view;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.leon.appmodelogeral.R;
public class SplashActivity extends AppCompatActivity {

    private int tempo=3000; //tempo que a tela vai ser mostrada, 3000 equivale a 3 segundos
    Context contextoDaActivity; //variavel que sera usada para pegar o contexto da tela
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        contextoDaActivity=this; //pegando o contexto

       //abaixo e instanciada uma classe interna com o metodo para executar a mudanca de tela
        // apos decorrido o tempo definido na variavel
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(contextoDaActivity,LoginActivity.class));
                finishAffinity();
            }
        },tempo);
    }
}
