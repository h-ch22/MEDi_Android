package kr.ac.jbnu.medi.Feedback;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import kr.ac.jbnu.medi.BaseActivity;
import kr.ac.jbnu.medi.R;
import kr.ac.jbnu.medi.activity_home;

public class activity_feedback extends BaseActivity {
    Boolean isGoodSelected = false;
    Boolean isBadSelected = false;
    String feedback;
    String division;
    private static final String TAG = "FeedbackHub";
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_feedback);

        final EditText field = findViewById(R.id.feedbackField);
        final ImageButton good = findViewById(R.id.btn_good);
        final ImageButton bad = findViewById(R.id.btn_bad);
        final TextView txtGood = findViewById(R.id.txt_good);
        final TextView txtBad = findViewById(R.id.txt_bad);
        Button send = findViewById(R.id.btn_sendFeedback);
        final Map<String, String> data = new HashMap<>();
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Dialog);

        good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isGoodSelected = true;
                isBadSelected = false;
                good.setImageResource(R.drawable.ic_good);
                bad.setImageResource(R.drawable.bitmap_btn_bad);
                txtGood.setTextColor(Color.parseColor("#ff6243"));
                txtBad.setTextColor(Color.parseColor("#6e6e6e"));
                division = "Good";
            }
        });

        bad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isGoodSelected = false;
                isBadSelected = true;
                bad.setImageResource(R.drawable.ic_bad);
                good.setImageResource(R.drawable.bitmap_btn_good);
                txtBad.setTextColor(Color.parseColor("#6987ff"));
                txtGood.setTextColor(Color.parseColor("#6e6e6e"));
                division = "Bad";
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feedback = field.getText().toString();
                data.put(feedback, division);

                if(!feedback.equals("")){
                    db.collection("Feedback")
                            .add(data)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    dialog.setMessage("피드백이 전송되었습니다.\n소중한 피드백은 앱을 개선하는데 최대한 반영하도록 노력하겠습니다.")
                                            .setTitle("피드백을 전송해주셔서 감사합니다.")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    Intent intent = new Intent(activity_feedback.this, activity_home.class);
                                                    startActivity(intent);
                                                    finish();
                                                }
                                            }).show();
                                }
                            })

                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "Error" , e);
                                    dialog.setMessage("오류가 발생했습니다.\n네트워크 상태를 점검한 후 다시시도해주세요.")
                                            .setTitle("오류")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                }
                                            }).show();
                                }
                            });
                }

                else {
                    dialog.setMessage("피드백 내용을 입력해주세요.").setTitle("피드백 내용 입력").setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).show();
                }
            }
        });
    }
}
