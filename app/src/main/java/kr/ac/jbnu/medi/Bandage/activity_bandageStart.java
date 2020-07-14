package kr.ac.jbnu.medi.Bandage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import kr.ac.jbnu.medi.BaseActivity;
import kr.ac.jbnu.medi.R;

public class activity_bandageStart extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bandage_start);

        Button start = findViewById(R.id.btn_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_bandageStart.this, activity_bandageSelect.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
