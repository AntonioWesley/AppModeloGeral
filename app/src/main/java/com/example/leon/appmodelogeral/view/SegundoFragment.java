package com.example.leon.appmodelogeral.view;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.leon.appmodelogeral.R;


public class SegundoFragment extends Fragment implements View.OnClickListener {
    Context context;
    private static ViewHolder mViewHolder = new ViewHolder();
    MediaPlayer mediaPlayer = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_segundo, container, false);
        this.mViewHolder.btnTocarAudio = (Button) view.findViewById(R.id.btn_tocar_audio);
        this.mViewHolder.radioSom1 = (RadioButton) view.findViewById(R.id.radio_opcao1);
        this.mViewHolder.radioSom2 = (RadioButton) view.findViewById(R.id.radio_opcao2);
        mediaPlayer = new MediaPlayer();
        this.mViewHolder.btnTocarAudio.setOnClickListener(this);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mediaPlayer.stop();
    }

    @Override
    public void onClick(View view) {
        if (this.mViewHolder.radioSom1.isChecked()) {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer = MediaPlayer.create(this.context, R.raw.canary);
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        } else if (this.mViewHolder.radioSom2.isChecked()) {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer = MediaPlayer.create(this.context, R.raw.alien);
            mediaPlayer.start();

        } else {
            Toast.makeText(this.context, "Escolha pelo menos um som para ser tocado!", Toast.LENGTH_SHORT).show();
        }
    }

    private static class ViewHolder {
        Button btnTocarAudio;
        RadioButton radioSom1, radioSom2;
    }

}
