package kr.co.hajun.androidpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Part2_Mission1 extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2_mission1);

        Button btn = findViewById(R.id.messenger_btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast toast = Toast.makeText(this, "ok button click...",Toast.LENGTH_SHORT);
        toast.show();
    }
}