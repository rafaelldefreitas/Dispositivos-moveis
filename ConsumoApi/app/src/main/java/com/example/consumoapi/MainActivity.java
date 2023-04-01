package com.example.consumoapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tarefa tarefa =new  Tarefa();
                tarefa.execute("https://viacep.com.br/ws/01001000/json/");
            }
        });
    }
     private class Tarefa extends AsyncTask<String, String, String>{

         @Override
         protected String doInBackground(String... strings) {
             String retorno = Conexao.getDados(strings[0]);
             return retorno;

         }

         @Override
         protected void onPostExecute(String s) {
            textView.setText(s);
         }
     }
}