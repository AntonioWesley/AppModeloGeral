package com.example.leon.appmodelogeral.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.leon.appmodelogeral.R;

public class    LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private static ViewHolder mViewHolder = new ViewHolder();
    private String login,senha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.mapearElementos();
        this.mViewHolder.btnEntrar.setOnClickListener(this);
    }

    private void mapearElementos() {
        this.mViewHolder.etLogin = (EditText) findViewById(R.id.et_login);
        this.mViewHolder.etSenha = (EditText) findViewById(R.id.et_senha);
        this.mViewHolder.btnEntrar = (Button) findViewById(R.id.btn_entrar);
    }

    @Override
    public void onClick(View view) {
        login = this.mViewHolder.etLogin.getText().toString();
        senha = this.mViewHolder.etSenha.getText().toString();
        if(login.equalsIgnoreCase("admin") &&
                senha.equalsIgnoreCase("qwe123") ){
            startActivity(new Intent(this,TelaPrincipalComNavDrawerActivity.class));
        }else{
            Toast.makeText(this, "Login e/ou senha incorretos!",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private static class ViewHolder{
        EditText etLogin, etSenha;
        Button btnEntrar;

    }
}
