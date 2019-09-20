package com.lnp.tmnt;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm1 = getSupportFragmentManager();
        Fragment fragment1 = fm1.findFragmentById(R.id.fragment);
        if (fragment1 == null) {
            fragment1 = new FragmentMain();
            fm1.beginTransaction().add(R.id.fragment, fragment1).commit();
        }
    }
}
