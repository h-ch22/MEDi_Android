package kr.ac.jbnu.medi.Tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import kr.ac.jbnu.medi.BaseActivity;
import kr.ac.jbnu.medi.R;

public class activity_tutorialThird extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tutorial_third);

        Button nextBtn = findViewById(R.id.btn_next);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_tutorialThird.this, activity_tutorialFinish.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
