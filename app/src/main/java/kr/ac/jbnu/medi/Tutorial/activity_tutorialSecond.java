package kr.ac.jbnu.medi.Tutorial;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import kr.ac.jbnu.medi.BaseActivity;
import kr.ac.jbnu.medi.R;

public class activity_tutorialSecond extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tutorial_second);

        Button nextBtn = findViewById(R.id.btn_next);


        player = MediaPlayer.create(this, R.raw.tutorial_first);
        playSound();

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_tutorialSecond.this, activity_tutorialThird.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
