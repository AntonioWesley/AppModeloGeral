package com.example.leon.appmodelogeral.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.leon.appmodelogeral.R;
import com.example.leon.appmodelogeral.constantes.ConstantesDoApp;

public class TelaInicialFeedNoticiasActivity extends AppCompatActivity implements View.OnClickListener {
    private static ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial_feed_noticias);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toast.makeText(this, "Escolha uma das manchetes!", Toast.LENGTH_SHORT).show();

        this.mapearElementos();
        this.setListeners();
    }

    private void mapearElementos() {
        this.mViewHolder.btnManchete1 = (Button) this.findViewById(R.id.btn_manchete1);
        this.mViewHolder.btnManchete2 = (Button) this.findViewById(R.id.btn_manchete2);
        this.mViewHolder.btnManchete3 = (Button) this.findViewById(R.id.btn_manchete3);
        this.mViewHolder.btnManchetesTodas = (Button) this.findViewById(R.id.btn_manchete_todas);
    }

    private void setListeners() {
        this.mViewHolder.btnManchete1.setOnClickListener(this);
        this.mViewHolder.btnManchete2.setOnClickListener(this);
        this.mViewHolder.btnManchete3.setOnClickListener(this);
        this.mViewHolder.btnManchetesTodas.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            startActivity(new Intent(this, TelaPrincipalComNavDrawerActivity.class));
            finishAffinity();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        int idBotaoClicado= view.getId();
        Intent intent = null;
        if(idBotaoClicado==R.id.btn_manchete1){
            intent = new Intent(this,TelaNoticiaActivity.class);
            intent.putExtra(ConstantesDoApp.CHAVENOTICIA,ConstantesDoApp.VALORNOTICIA1);

        }else if(idBotaoClicado==R.id.btn_manchete2){
            intent = new Intent(this,TelaNoticiaActivity.class);
            intent.putExtra(ConstantesDoApp.CHAVENOTICIA,ConstantesDoApp.VALORNOTICIA2);
        }else if(idBotaoClicado==R.id.btn_manchete3){
            intent = new Intent(this,TelaNoticiaActivity.class);
            intent.putExtra(ConstantesDoApp.CHAVENOTICIA,ConstantesDoApp.VALORNOTICIA3);
        }else if(idBotaoClicado==R.id.btn_manchete_todas){
            intent = new Intent(this,TelaNoticiaActivity.class);
            intent.putExtra(ConstantesDoApp.CHAVENOTICIA,ConstantesDoApp.VALORNOTICIAGERAL);
        }
        startActivity(intent);
    }

    private static class ViewHolder {
        Button btnManchete1, btnManchete2, btnManchete3, btnManchetesTodas;
    }
}
