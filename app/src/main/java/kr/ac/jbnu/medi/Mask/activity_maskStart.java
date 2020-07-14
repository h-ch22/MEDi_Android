package kr.ac.jbnu.medi.Mask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import kr.ac.jbnu.medi.Bandage.activity_bandageSelect;
import kr.ac.jbnu.medi.Bandage.activity_bandageStart;
import kr.ac.jbnu.medi.BaseActivity;
import kr.ac.jbnu.medi.R;

public class activity_maskStart extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mask_start);

        Button start = findViewById(R.id.btn_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_maskStart.this, activity_maskSelect.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
