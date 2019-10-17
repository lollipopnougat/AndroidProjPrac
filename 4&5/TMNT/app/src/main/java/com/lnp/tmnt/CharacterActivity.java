package com.lnp.tmnt;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;
import java.util.UUID;

public class CharacterActivity extends AppCompatActivity {
    private static final String EXTRA_CHARA_ID = "com.lnp.tmnt.character_id";
    private ViewPager mViewPager;
    private List<com.lnp.tmnt.Character> mCharas;

    public static Intent newIntent(Context packageContext, UUID charaId) {
        Intent intent = new Intent(packageContext, CharacterActivity.class);
        intent.putExtra(EXTRA_CHARA_ID, charaId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CHARA_ID);

        mViewPager = findViewById(R.id.fragment_character_viewpager);

        mCharas = CharacterLab.get().getCharacterList();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                com.lnp.tmnt.Character ch = mCharas.get(position);
                return CharacterFragment.newInstance(ch.getmId());
            }

            @Override
            public int getCount() {
                return mCharas.size();
            }
        });

        for (int i = 0; i < mCharas.size(); i++) {
            if (mCharas.get(i).getmId().equals(crimeId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }

}
