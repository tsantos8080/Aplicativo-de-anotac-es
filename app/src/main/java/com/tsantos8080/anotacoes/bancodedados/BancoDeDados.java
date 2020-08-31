package com.tsantos8080.anotacoes.bancodedados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoDeDados {

    private SQLiteDatabase db;
    private GerenciarBanco gerenciarBanco;

    public BancoDeDados(Context context) {
        gerenciarBanco = new GerenciarBanco(context);
    }

    public boolean criarAnotacao(String titulo, String conteudo) {
        db = gerenciarBanco.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", titulo);
        contentValues.put("conteudo", conteudo);

        long result = db.insert("anotacoes", null, contentValues);

        db.close();

        return result > 0;
    }

    public void atualizarAnotacao(int id, String titulo, String conteudo) {
        db = gerenciarBanco.getWritableDatabase();

        String where = "_id = " + id;

        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", titulo);
        contentValues.put("conteudo", conteudo);

        db.update("anotacoes", contentValues, where, null);
        db.close();
    }

    public Cursor obterAnotacoes() {
        db = gerenciarBanco.getReadableDatabase();

        String[] fields = {"_id", "titulo"};

        Cursor cursor = db.query("anotacoes", fields, null, null, null, null, "_id ASC");

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();

        return cursor;
    }

    public void excluirAnotacao(int id) {
        db = gerenciarBanco.getWritableDatabase();

        String where = "_id = " + id;

        db.delete("anotacoes", where, null);
        db.close();
    }

    public Cursor consultarAnotacaoPeloId(int id) {
        db = gerenciarBanco.getReadableDatabase();

        String[] fields = {"_id", "titulo", "conteudo"};

        String where = "_id = " + id;

        Cursor cursor = db.query("anotacoes", fields, where, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();

        return cursor;
    }
}
