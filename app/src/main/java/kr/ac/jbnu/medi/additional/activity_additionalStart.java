package kr.ac.jbnu.medi.additional;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;

import kr.ac.jbnu.medi.BaseActivity;
import kr.ac.jbnu.medi.R;

public class activity_additionalStart extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_additionalstart);

        Button confirm = findViewById(R.id.btn_confirm);
        Button check = findViewById(R.id.btn_check);



    }
}
