package com.example.piedrapapeltijera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView btn_piedra, btn_papel, btn_tijera;
    public final static int PIEDRA = 0, PAPEL = 1, TIJERA = 2;
    final static int MIN = 0, MAX = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_components();
        set_onClick_imageView();

    }

    private void set_onClick_imageView() {
        btn_piedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int contrincante = (int) Math.random() * (MAX - MIN + 0) + MIN;
                int you = PIEDRA;
                go_to_ResultadoActivity(contrincante, you);
            }
        });
        btn_papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int contrincante = (int) Math.random() * (MAX - MIN + 0) + MIN;
                int you = PAPEL;
                go_to_ResultadoActivity(contrincante, you);
            }
        });
        btn_tijera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int contrincante = (int) Math.random() * (MAX - MIN + 0) + MIN;
                int you = TIJERA;
                go_to_ResultadoActivity(contrincante, you);
            }
        });
    }

    private void go_to_ResultadoActivity(int contrincante, int you) {
        Intent intent = new Intent(getApplicationContext(), Resultado.class);
        intent.putExtra("contrincante", contrincante);
        intent.putExtra("you", you);
        startActivity(intent);
    }

    private void init_components() {
        btn_piedra = (ImageView) findViewById(R.id.btn_piedra);
        btn_papel = (ImageView) findViewById(R.id.btn_papel);
        btn_tijera = (ImageView) findViewById(R.id.btn_tijera);
    }
}