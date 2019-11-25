package com.bignerdranch.android.beatbox;

import android.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;


public class BeatBoxActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return BeatBoxFragment.newInstance();
    }
}
