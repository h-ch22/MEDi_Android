package kr.ac.jbnu.medi.Tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.media.MediaPlayer;

import androidx.annotation.Nullable;

import kr.ac.jbnu.medi.BaseActivity;
import kr.ac.jbnu.medi.R;

public class activity_tutorialStart extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tutorial_start);

        Button startBtn = findViewById(R.id.btn_start);

        player = MediaPlayer.create(this, R.raw.tutorial_start);
        playSound();

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_tutorialStart.this, activity_tutorialSecond.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
