package com.example.prova_tela;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context) {
        banco = new CriaBanco(context);
    }
    public String insereDado(String placa, String modelo, String valor, String idade) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.PLACA, placa);
        valores.put(CriaBanco.MODELO, modelo);
        valores.put(CriaBanco.VALOR, valor);
        valores.put(CriaBanco.IDADE, idade);

        resultado = db.insert(CriaBanco.TABELA, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }

    public Cursor carregaDados() {
        Cursor cursor;
        String[] campos = {banco.ID, banco.PLACA};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    //Outros codigos
    public Cursor carregaDadoById(int id) {
        Cursor cursor;
        String[] campos = {banco.ID, banco.PLACA, banco.MODELO, banco.VALOR, banco.IDADE};
        String where = CriaBanco.ID + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.TABELA, campos, where, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
    public void alteraRegistro(int id, String placa, String modelo, String valor, String idade ) {
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = CriaBanco.ID + "=" + id;

        valores = new ContentValues();
        valores.put(CriaBanco.PLACA, placa);
        valores.put(CriaBanco.MODELO, modelo);
        valores.put(CriaBanco.VALOR, valor);
        valores.put(CriaBanco.IDADE, idade);

        db.update(CriaBanco.TABELA, valores, where, null);
        db.close();
    }

    public void deletaRegistro(int id) {
        String where = CriaBanco.ID + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.TABELA, where, null);
        db.close();
    }

}
