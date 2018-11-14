package com.example.leon.appmodelogeral.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.example.leon.appmodelogeral.R;
public class TelaSobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_sobre);

        //esconde a barra de acao
        getSupportActionBar().hide();

        // instanciado(criado) o objeto que irá conter a dimensao da tela
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        //pega largura e altura em pixels
        int larguraTela = dm.widthPixels;
        int alturaTela = dm.heightPixels;

        getWindow().setLayout( (int) (larguraTela*.9)  , (int) (alturaTela*.7)  );

    }
}
