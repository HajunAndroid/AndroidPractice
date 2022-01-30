package kr.co.hajun.androidpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;

public class Lab17_3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab173);
        ViewPager pager = findViewById(R.id.lab2_pager);
        MyPageAdapter pageAdapter = new MyPageAdapter(getSupportFragmentManager());
        pager.setAdapter(pageAdapter);
    }

    class MyPageAdapter extends FragmentPagerAdapter{
        ArrayList<Fragment> fragments;
        public MyPageAdapter(FragmentManager manager){
            super(manager);
            fragments = new ArrayList<>();
            fragments.add(new OneFragment());
            fragments.add(new ThreeFragment());
        }
        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}