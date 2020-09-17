package kr.ac.jbnu.medi;

import android.app.ProgressDialog;
import android.media.MediaPlayer;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private ProgressDialog mProgressDialog;
    protected static MediaPlayer player;

    public void showProgressDialog(){
        if(mProgressDialog == null){
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(true);
            mProgressDialog.setMessage("잠시 기다려주세요!");
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog(){
        if(mProgressDialog == null && mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }

    public void playSound(){
        player.setLooping(false);
        player.start();
    }
}
