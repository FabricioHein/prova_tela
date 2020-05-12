package com.example.prova_tela;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insere_dado);
        Button botao = (Button)findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                EditText placa = (EditText)findViewById(R.id.editText);
                EditText modelo = (EditText)findViewById((R.id.editText2));
                EditText idade = (EditText)findViewById(R.id.editText3);
                EditText valor = (EditText)findViewById(R.id.editText4);
                String placaString = placa.getText().toString();
                String modeloString = modelo.getText().toString();
                String valorString = valor.getText().toString();
                String idadeString = idade.getText().toString();
                String resultado;

                resultado = crud.insereDado(placaString,modeloString,valorString, idadeString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();


            }
        });
        Button btlistar = (Button) findViewById(R.id.botaolistar);
        btlistar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                CarregaTelaListar();
            }
        });

    }

    private void CarregaTelaListar() {
        //setContentView(R.layout.activity_banco_dados_consulta);
        Intent intent = new Intent(MainActivity.this, ConsultaDado.class);
        startActivity(intent);
        finish();
    }
}
