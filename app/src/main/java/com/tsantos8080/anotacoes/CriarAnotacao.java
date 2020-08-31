package com.tsantos8080.anotacoes;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tsantos8080.anotacoes.bancodedados.BancoDeDados;

public class CriarAnotacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_anotacao);
    }

    public void onClickButtonCriar(View v) {
        EditText editTextTitulo = findViewById(R.id.editTextTitulo);
        EditText editTextConteudo = findViewById(R.id.editTextConteudo);

        BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext());
        boolean result = bancoDeDados.criarAnotacao(editTextTitulo.getText().toString(),
                editTextConteudo.getText().toString());

        if (result) {
            Toast.makeText(this, "Anotação criada com sucesso.", Toast.LENGTH_SHORT).show();
            finish();
        }
        Toast.makeText(this, "Ocorreu um erro. Tente novamente.", Toast.LENGTH_SHORT).show();

    }

    public void onClickButtonCancelar(View v) {
        finish();
    }
}
