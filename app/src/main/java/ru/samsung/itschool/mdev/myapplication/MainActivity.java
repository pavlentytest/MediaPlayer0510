package ru.samsung.itschool.mdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button btnStart, btnStop;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.start);
        btnStop = findViewById(R.id.stop);
        btnStart.setOnClickListener(view -> doPlay(view));
        btnStop.setOnClickListener(view ->doPlay(view));
    }
    private void doPlay(View view) {

        if(view.getId() == R.id.start) {
            if(mp == null) {
                mp = MediaPlayer.create(getApplicationContext(), R.raw.canon);
                mp.start();
            } else {
                if(mp.isPlaying()) {
                    mp.pause();
                } else {
                    mp.start();
                }
            }
        } else {
            mp.stop();
            mp = null;
           //mp.release(); //????
        }

    }
}