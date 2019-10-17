package com.lnp.tmnt;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

public class CharacterListActivity extends SingleFragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected Fragment createFragment() {
        return new CharacterListFragment();
    }
}
