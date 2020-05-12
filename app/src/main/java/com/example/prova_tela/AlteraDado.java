package com.example.prova_tela;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlteraDado extends AppCompatActivity {

    EditText carro;
    EditText modelo;
    EditText valor;
    EditText idade;
    Button alterar;
    Button deletar;
    Button voltar;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altera_dado);

        codigo = this.getIntent().getStringExtra("codigo");

        crud = new BancoController(getBaseContext());

        carro = (EditText)findViewById(R.id.editText4);
        modelo = (EditText)findViewById(R.id.editText5);
        valor = (EditText)findViewById(R.id.editText6);
        idade = (EditText)findViewById(R.id.editText7);
        alterar = (Button)findViewById(R.id.button2);

        cursor = crud.carregaDadoById(Integer.parseInt(codigo));
        carro.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.PLACA)));
        modelo.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.MODELO)));
        valor.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.VALOR)));
        idade.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.IDADE)));
        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.alteraRegistro(Integer.parseInt(codigo), carro.getText().toString(), modelo.getText().toString(),
                        valor.getText().toString(), idade.getText().toString());

                Intent intent = new Intent(AlteraDado.this, ConsultaDado.class);
                startActivity(intent);
                finish();
            }
        });
        //Codigo Antes
        deletar = (Button)findViewById(R.id.button3);
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.deletaRegistro(Integer.parseInt(codigo));
                Intent intent = new Intent(AlteraDado.this,ConsultaDado.class);
                startActivity(intent);
                finish();
            }
        });
        //Codigo Antes
        voltar = (Button)findViewById(R.id.voltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlteraDado.this,BancoDadosActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


}
