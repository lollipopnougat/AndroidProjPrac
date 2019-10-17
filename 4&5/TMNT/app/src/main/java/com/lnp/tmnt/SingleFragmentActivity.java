package com.lnp.tmnt;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public abstract class SingleFragmentActivity extends FragmentActivity {

    protected abstract Fragment createFragment();
    private final String Tag = "Fragment";
    private String FragmentName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Tag,FragmentName + " onCreate()");
        setContentView(R.layout.activity_main);
        /*Toolbar toolbar = findViewById(R.id.toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

        });*/
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
