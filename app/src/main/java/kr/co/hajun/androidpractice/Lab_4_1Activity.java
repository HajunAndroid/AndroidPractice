package kr.co.hajun.androidpractice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Lab_4_1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab41);

        Toast t = Toast.makeText(this, "종료하려면 한번더 누르세요",Toast.LENGTH_SHORT);
        t.show();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle("알림");
        builder.setMessage("정말 종료 하시겠습니까?");
        builder.setPositiveButton("OK",null);
        builder.setNegativeButton("NO",null);
    }
}