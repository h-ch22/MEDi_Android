package kr.ac.jbnu.medi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import kr.ac.jbnu.medi.Bandage.activity_bandageStart;
import kr.ac.jbnu.medi.HandSanitizer.activity_handSanitizerStart;
import kr.ac.jbnu.medi.Mask.activity_maskStart;
import kr.ac.jbnu.medi.Thermometer.activity_thermometerStart;

public class activity_home extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home);

        Button mask = findViewById(R.id.btn_Mask);
        Button handsanitizer = findViewById(R.id.btn_HandSanitizer);
        Button band = findViewById(R.id.btn_band);
        Button thermometer = findViewById(R.id.btn_Thermometer);

        mask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_home.this, activity_maskStart.class);
                startActivity(intent);
                finish();
            }
        });

        handsanitizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_home.this, activity_handSanitizerStart.class);
                startActivity(intent);
                finish();
            }
        });

        band.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_home.this, activity_bandageStart.class);
                startActivity(intent);
                finish();
            }
        });

        thermometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_home.this, activity_thermometerStart.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
