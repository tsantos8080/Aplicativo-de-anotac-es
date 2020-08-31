package com.tsantos8080.anotacoes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TelaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
    }

    public void onClickButtonCriarAnotacao(View V) {
        startActivity(new Intent(this, CriarAnotacao.class));
    }
}
