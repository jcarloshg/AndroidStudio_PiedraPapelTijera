package com.example.piedrapapeltijera;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    int contrincante, you;
    ImageView imgV_contrincante, imgV_you;
    final static String GANA_CPU = "Gana CPU", GANA_YOU = "Tú ganas", EMPATE = "EMPATE";
    TextView textView_state_game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        init_components();

        contrincante = getIntent().getIntExtra("contrincante", contrincante);
        you = getIntent().getIntExtra("you", you);

        Log.d("[CONTRINCANTE]", "" + contrincante);

        set_img(imgV_you, you);
        set_img(imgV_contrincante, contrincante);

        textView_state_game.setText(check_winner(contrincante, you));
    }

    private void set_img(ImageView imgV_player, int player) {
        if (player==MainActivity.PIEDRA){
            imgV_player.setImageResource(R.drawable.piedra);
        }

        if (player==MainActivity.PAPEL){
            imgV_player.setImageResource(R.drawable.papel);
        }

        if (player==MainActivity.TIJERA){
            imgV_player.setImageResource(R.drawable.tijera);
        }

    }

    private String check_winner(int contrincante, int you) {
        String state_game = EMPATE;

        // piedra gana a tijera
        if (contrincante==MainActivity.PIEDRA && you == MainActivity.TIJERA){
            state_game = GANA_CPU;
        }
        if (contrincante==MainActivity.TIJERA && you == MainActivity.PIEDRA){
            state_game = GANA_YOU;
        }

        // papel gana a piedra
        if (contrincante==MainActivity.PAPEL && you == MainActivity.PIEDRA){
            state_game = GANA_CPU;
        }
        if (contrincante==MainActivity.PIEDRA && you == MainActivity.PAPEL){
            state_game = GANA_YOU;
        }

        // TIJERA gana a PAPEL
        if (contrincante==MainActivity.TIJERA && you == MainActivity.PAPEL){
            state_game = GANA_CPU;
        }
        if (contrincante==MainActivity.PAPEL && you == MainActivity.TIJERA){
            state_game = GANA_YOU;
        }

        return state_game;
    }

    private void init_components() {
        imgV_contrincante = (ImageView) findViewById(R.id.imgV_contrincante);
        imgV_you = (ImageView) findViewById(R.id.imgV_you);
        textView_state_game = (TextView) findViewById(R.id.textView_state_game);
    }
}