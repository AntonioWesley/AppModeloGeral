package com.example.leon.appmodelogeral.view;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leon.appmodelogeral.R;
import com.example.leon.appmodelogeral.constantes.ConstantesDoApp;
import com.example.leon.appmodelogeral.entidades.Noticia;
import com.example.leon.appmodelogeral.util.ListaDeNoticias;

import java.util.ArrayList;
import java.util.List;

public class TelaNoticiaActivity extends AppCompatActivity implements View.OnClickListener{
    private static ViewHolder mViewHolder = new ViewHolder();
    String noticiaEscolhida;
    static int posicaoLista;
    List<Noticia> lista = new ArrayList<>();
    ListaDeNoticias listaDeNoticias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_noticia);
        listaDeNoticias = new ListaDeNoticias(this);
        lista.addAll(listaDeNoticias.getListaDeNoticias());
        this.mapearElementos();
        this.setListeners();
        this.carregarNoticia();
    }

    private void mapearElementos() {
        this.mViewHolder.tvManchete= (TextView) this.findViewById(R.id.tv_manchete);
        this.mViewHolder.tvCorpoNoticia= (TextView) this.findViewById(R.id.tv_corpo_noticia);
        this.mViewHolder.ivImagemNoticia= (ImageView) this.findViewById(R.id.iv_imagem_noticia);
        this.mViewHolder.btnFecharNoticia= (Button) this.findViewById(R.id.btn_fechar_noticia);
        this.mViewHolder.btnProximaNoticia= (Button) this.findViewById(R.id.btn_proxima_noticia);

    }
    private void setListeners() {
        this.mViewHolder.btnFecharNoticia.setOnClickListener(this);
        this.mViewHolder.btnProximaNoticia.setOnClickListener(this);
        this.mViewHolder.ivImagemNoticia.setOnClickListener(this);

    }

    private void carregarNoticia() {
        noticiaEscolhida= getIntent().getStringExtra(ConstantesDoApp.CHAVENOTICIA);
        if(noticiaEscolhida.equalsIgnoreCase(ConstantesDoApp.VALORNOTICIA1)){
            posicaoLista=0;

            this.mViewHolder.btnProximaNoticia.setVisibility(View.INVISIBLE);
        }else if(noticiaEscolhida.equalsIgnoreCase(ConstantesDoApp.VALORNOTICIA2)){
            posicaoLista=1;
            this.mViewHolder.btnProximaNoticia.setVisibility(View.INVISIBLE);
        } else if(noticiaEscolhida.equalsIgnoreCase(ConstantesDoApp.VALORNOTICIA3)){
            posicaoLista=2;
            this.mViewHolder.btnProximaNoticia.setVisibility(View.INVISIBLE);
        } else if(noticiaEscolhida.equalsIgnoreCase(ConstantesDoApp.VALORNOTICIAGERAL)){
            posicaoLista=0;
            this.mViewHolder.btnProximaNoticia.setVisibility(View.VISIBLE);
        }
        this.mViewHolder.tvManchete.setText(lista.get(posicaoLista).getManchete());
        this.mViewHolder.tvCorpoNoticia.setText(lista.get(posicaoLista).getCorpoNoticia());
        this.mViewHolder.ivImagemNoticia.setImageDrawable((lista.get(posicaoLista).getImagem()));
        this.mViewHolder.ivImagemNoticia.setTag((lista.get(posicaoLista).getImagem()));


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
        if(view.getId()==R.id.btn_fechar_noticia){
            finishAffinity();
            startActivity(new Intent(this,TelaInicialFeedNoticiasActivity.class));
        }
        if(view.getId()==R.id.btn_proxima_noticia) {
                posicaoLista++;

                this.mViewHolder.tvManchete.setText(lista.get(posicaoLista).getManchete());
                this.mViewHolder.tvCorpoNoticia.setText(lista.get(posicaoLista).getCorpoNoticia());
                this.mViewHolder.ivImagemNoticia.setImageDrawable((lista.get(posicaoLista).getImagem()));

                if(posicaoLista>=2) {
                     this.mViewHolder.btnProximaNoticia.setVisibility(View.INVISIBLE);
                 }
        }

    }

    private static class ViewHolder{
        TextView tvManchete,tvCorpoNoticia;
        ImageView ivImagemNoticia;
        Button btnProximaNoticia;
        Button btnFecharNoticia;

    }
}
