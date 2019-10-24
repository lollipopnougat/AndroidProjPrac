package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment createFragment();
    private final String Tag = "Fragment";
    private String FragmentName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Tag,FragmentName + " onCreate()");
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);


        if (fragment == null) {
            fragment = createFragment();
            FragmentName = fragment.getClass().getName();
                    fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Tag,FragmentName + " onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Tag,FragmentName + " onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Tag,FragmentName + " onDestroy()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Tag,FragmentName + " onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Tag,FragmentName + " onStart()");
    }
}
