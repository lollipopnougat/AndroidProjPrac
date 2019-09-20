package com.bignerdranch.android.criminalintent;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;


public class CrimeActivity extends FragmentActivity {

    private static final String TAG = "Test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "调用CrimeActivity的onCreate方法");
        setContentView(R.layout.activity_crime);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new CrimeFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        Log.v(TAG, "调用CrimeActivity的onCreateView方法" + "参数name:" + name);
        return super.onCreateView(name, context, attrs);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onStart() {
        Log.v(TAG, "调用CrimeActivity的onStart方法");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v(TAG, "调用CrimeActivity的onStop方法");
        super.onStop();
    }

    @Override
    protected void onResume() {
        Log.v(TAG, "调用CrimeActivity的onResume方法");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.v(TAG, "调用CrimeActivity的onPause方法");
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.v(TAG, "调用CrimeActivity的onSaveInstanceState方法");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        Log.v(TAG, "调用CrimeActivity的onDestroy方法");
        super.onDestroy();
    }
}
