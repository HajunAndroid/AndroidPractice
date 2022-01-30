package kr.co.hajun.androidpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Lab17_1 extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;

    FragmentManager manager;
    OneFragment oneFragment;
    TwoFragment twoFragment;
    ThreeFragment threeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab171);

        btn1 = findViewById(R.id.main_btn1);
        btn2 = findViewById(R.id.main_btn2);
        btn3 = findViewById(R.id.main_btn3);

        manager = getSupportFragmentManager();
        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        threeFragment = new ThreeFragment();

        FragmentTransaction tf = manager.beginTransaction();
        tf.addToBackStack(null);
        tf.add(R.id.main_container,oneFragment);
        tf.commit();
    }

    public void btnClick1(View view){
        if(!oneFragment.isVisible()){
            FragmentTransaction tf = manager.beginTransaction();
            tf.addToBackStack(null);
            tf.replace(R.id.main_container,oneFragment);
            tf.commit();
        }
    }

    public void btnClick2(View view){
        if(!twoFragment.isVisible()){
            twoFragment.show(manager,null);
        }
    }

    public void btnClick3(View view){
        if(!threeFragment.isVisible()){
            FragmentTransaction tf = manager.beginTransaction();
            tf.addToBackStack(null);
            tf.replace(R.id.main_container,threeFragment);
            tf.commit();
        }
    }
}