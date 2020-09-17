package kr.ac.jbnu.medi.Tutorial;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import kr.ac.jbnu.medi.BaseActivity;
import kr.ac.jbnu.medi.R;
import kr.ac.jbnu.medi.activity_home;

public class activity_tutorialFinish extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tutorial_finish);

        Button startBtn = findViewById(R.id.btn_start);


        player = MediaPlayer.create(this, R.raw.finish);
        playSound();

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_tutorialFinish.this, activity_home.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
