package kr.ac.jbnu.medi.Mask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;

import kr.ac.jbnu.medi.BaseActivity;
import kr.ac.jbnu.medi.Mask.TODO.View.activity_livePreview;
import kr.ac.jbnu.medi.R;

public class activity_maskSelect extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mask_select);

        Button guide = findViewById(R.id.btn_guide);

        Button toDo = findViewById(R.id.btn_todo);

        toDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_maskSelect.this, activity_livePreview.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
