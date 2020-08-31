package com.tsantos8080.anotacoes.bancodedados;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class BancoDeDados {

    private SQLiteDatabase banco;
    private GerenciarBanco gerenciarBanco;

    public BancoDeDados(Context context) {
        gerenciarBanco = new GerenciarBanco(context);
    }

    public boolean criarAnotacao(String titulo, String conteudo) {
        banco = gerenciarBanco.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", titulo);
        contentValues.put("conteudo", conteudo);

        long result = banco.insert("anotacoes", null, contentValues);
        banco.close();

        return result > 0;
    }
}
