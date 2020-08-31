package com.tsantos8080.anotacoes.bancodedados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GerenciarBanco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "bancoDeDados.db";
    private static final int VERSAO = 1;

    public GerenciarBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE anotacoes (_id integer primary key autoincrement, titulo text," +
                "conteudo text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS anotacoes";
        db.execSQL(sql);
        onCreate(db);
    }
}
