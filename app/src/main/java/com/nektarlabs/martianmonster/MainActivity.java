package com.nektarlabs.martianmonster;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer1;
    private MediaPlayer mMediaPlayer2;
    private MediaPlayer mMediaPlayer3;
    private MediaPlayer mMediaPlayer4;
    private MediaPlayer mMediaPlayer5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5 })
    public void onSoundboarsdButtonClicked(View view) {
        playSoundForButton(view);
    }

    private void stopPlaying(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    private void playSoundForButton(View view) {
        Button button = (Button) view;
        int resid;

        switch(button.getId()) {
            case R.id.button1:
                stopPlaying(mMediaPlayer1);
                mMediaPlayer1 = MediaPlayer.create(this, R.raw.firstastronaut);
                mMediaPlayer1.start();
                break;
            case R.id.button2:
                stopPlaying(mMediaPlayer2);
                mMediaPlayer2 = MediaPlayer.create(this, R.raw.incrediblespeed);
                mMediaPlayer2.start();
                break;
            case R.id.button3:
                stopPlaying(mMediaPlayer3);
                mMediaPlayer3 = MediaPlayer.create(this, R.raw.tripisshort);
                mMediaPlayer3.start();
                break;
            case R.id.button4:
                stopPlaying(mMediaPlayer4);
                mMediaPlayer4 = MediaPlayer.create(this, R.raw.ufo);
                mMediaPlayer4.start();
                break;
            case R.id.button5:
                stopPlaying(mMediaPlayer5);
                mMediaPlayer5 = MediaPlayer.create(this, R.raw.blastoff);
                mMediaPlayer5.start();
                break;
            default:
                break;
        }
    }

    @OnClick(R.id.shareImageView)
    public void onShareButtonClicked(View view) {
        shareTo();
    }

    private void shareTo() {
        String message = "♫ My spaceship just blasted off, via the Martian Monster App! http://onelink.to/mmapp";
        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message);

        startActivity(Intent.createChooser(intent, "Share To"));
    }
}