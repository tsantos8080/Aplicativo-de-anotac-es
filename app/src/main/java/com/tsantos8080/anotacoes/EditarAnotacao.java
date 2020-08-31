package com.tsantos8080.anotacoes;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tsantos8080.anotacoes.bancodedados.BancoDeDados;

public class EditarAnotacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_anotacao);

        BancoDeDados db = new BancoDeDados(getBaseContext());
        final Cursor cursor = db.consultarAnotacaoPeloId(this.getIntent().getIntExtra("id", 0));

        EditText titulo = findViewById(R.id.editTextTitulo);
        EditText conteudo = findViewById(R.id.editTextConteudo);

        titulo.setText(cursor.getString(cursor.getColumnIndexOrThrow("titulo")));
        conteudo.setText(cursor.getString(cursor.getColumnIndexOrThrow("conteudo")));
    }

    public void onClickButtonGravar(View v) {
        BancoDeDados db = new BancoDeDados(getBaseContext());
        EditText titulo = findViewById(R.id.editTextTitulo);
        EditText conteudo = findViewById(R.id.editTextConteudo);

        try {
            db.atualizarAnotacao(this.getIntent().getIntExtra("id", 0),
                    titulo.getText().toString(), conteudo.getText().toString());
            Toast.makeText(getApplicationContext(), "Anotação atualizada com sucesso.", Toast.LENGTH_SHORT).show();
            finish();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Ocorreu um erro. Tente novamente.", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickButtonCancelar(View v) {
        finish();
    }

    public void onClickButtonExcluir(View v) {
        BancoDeDados db = new BancoDeDados(getBaseContext());

        try {
            db.excluirAnotacao(this.getIntent().getIntExtra("id", 0));
            Toast.makeText(getApplicationContext(), "Anotação excluída com sucesso.", Toast.LENGTH_SHORT).show();
            finish();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Ocorreu um erro. Tente novamente.", Toast.LENGTH_SHORT).show();
        }
    }
}
