package com.tsantos8080.anotacoes;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CriarAnotacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_anotacao);
    }

    public void onClickButtonCriar(View V) {

    }

    public void onClickButtonCancelar(View V) {
        finish();
    }
}
