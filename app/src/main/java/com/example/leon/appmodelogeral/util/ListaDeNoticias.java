package com.example.leon.appmodelogeral.util;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.example.leon.appmodelogeral.R;
import com.example.leon.appmodelogeral.entidades.Noticia;

import java.util.ArrayList;
import java.util.List;

public class ListaDeNoticias {
    public List<Noticia> listaDeNoticias;

    public ListaDeNoticias(Context context){
        this.listaDeNoticias = this.criarLista(context);
    }
    public List<Noticia>  criarLista(Context context){
        List<Noticia> listaDeNoticias= new ArrayList<>();
        Noticia noticia1 = new Noticia("Hamas anuncia cessar-fogo",
                "Grupos palestinos, incluindo o movimento islâmico Hamas no poder na Faixa de Gaza, anunciaram nesta terça-feira (13) um cessar-fogo com Israel. Eles indicaram que o acordo, fechado com ajuda do Egito, será cumprido se o Estado hebreu o respeitar.",
                ContextCompat.getDrawable(context, R.drawable.gaza));
        Noticia noticia2 = new Noticia("Dólar fecha em alta",
                "O dólar fechou em alta nesta terça-feira (13), após indicações do presidente eleito Jair Bolsonaro sobre inviabilidade de votação da reforma da Previdência neste ano. O dia foi marcado ainda por alívio nas tensões comerciais no mercado externo com a divulgação de conversas entre Estados Unidos e China.",
                ContextCompat.getDrawable(context, R.drawable.dolar));
        Noticia noticia3 = new Noticia("Como é feita a prova do Enem, segundo o Inep",
                "Ao contrário dos demais vestibulares, as questões do Exame Nacional do Ensino Médio (Enem) não são elaboradas todas por uma mesma equipe no período de elaboração anual das provas: cada questão passa por um processo longo de elaboração, revisão e calibragem até ser aprovada como uma possível pergunta do exame.",
                ContextCompat.getDrawable(context, R.drawable.provaazul2));

        listaDeNoticias.add(noticia1);
        listaDeNoticias.add(noticia2);
        listaDeNoticias.add(noticia3);

        return listaDeNoticias;
    }
    public List<Noticia> getListaDeNoticias(){
        return this.listaDeNoticias;
    }
}
