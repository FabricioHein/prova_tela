package com.example.prova_tela;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco  extends SQLiteOpenHelper {
    private static final String modelo_BANCO = "banco.db";
    static final String TABELA = "Carros";
    static final String ID = "_id";
    static final String PLACA = "xxxx-xxxx";
    static final String MODELO = "CORSA";
    static final String VALOR = "10.000";
    static final String IDADE = "5";
    private static final int VERSAO = 1;

    public CriaBanco(Context context) {
        super(context, modelo_BANCO, null, VERSAO);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = " CREATE TABLE " + TABELA + " ("
                + ID + " integer primary key autoincrement, "
                + PLACA + " text,"
                + MODELO + " text,"
                + VALOR + " text"
                + IDADE + " text"
                + " )";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }



    }
