package kr.ac.jbnu.medi.Mask;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import kr.ac.jbnu.medi.BaseActivity;
import kr.ac.jbnu.medi.R;

public class activity_maskSelect extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mask_select);

        Button guide = findViewById(R.id.btn_guide);

        Button toDo = findViewById(R.id.btn_todo);

    }
}
