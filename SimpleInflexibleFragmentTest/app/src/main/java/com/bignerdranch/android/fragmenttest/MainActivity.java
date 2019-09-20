package com.bignerdranch.android.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm1 = getSupportFragmentManager();
        Fragment fragment1 = fm1.findFragmentById(R.id.fragment1);
        FragmentManager fm2 = getSupportFragmentManager();
        Fragment fragment2 = fm2.findFragmentById(R.id.fragment2);
        if (fragment1 == null) {
            fragment1 = new OneFragment();
            fm1.beginTransaction().add(R.id.fragment1, fragment1).commit();
        }
        if (fragment2 == null) {
            fragment2 = new TwoFragment();
            fm2.beginTransaction().add(R.id.fragment2, fragment2).commit();
        }
    }



}
