package com.example.leon.appmodelogeral.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.leon.appmodelogeral.R;


public class HomeFragment extends Fragment implements View.OnClickListener{
    Context context;
    private static ViewHolder mViewHolder = new ViewHolder();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        this.mViewHolder.btnAbrirFeed = (Button) view.findViewById(R.id.btn_abrir_feed);

        this.mViewHolder.btnAbrirFeed.setOnClickListener(this);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        this.context=context;
        super.onAttach(context);

    }

    @Override
    public void onClick(View view) {
       startActivity(new Intent(this.context,TelaInicialFeedNoticiasActivity.class));
    }

    private static class ViewHolder{
       Button btnAbrirFeed;
    }
}
