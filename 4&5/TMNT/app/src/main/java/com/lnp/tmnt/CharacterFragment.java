package com.lnp.tmnt;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class CharacterFragment extends Fragment {
    private static final String ARG_CHARA_ID = "character_id";
    private static final String TAG = "Test";
    private MediaPlayer player;
    private View view;
    private int currentPlayingSec;
    private boolean isStopped = false;

    public static CharacterFragment newInstance(UUID crimeId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CHARA_ID, crimeId);

        CharacterFragment fragment = new CharacterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private com.lnp.tmnt.Character currentCharacter;
    private ImageButton imgBtn;
    private ImageView imgView;
    private ImageButton playBtn;
    private TextView txtViewProN;
    private TextView txtViewNicN;
    private TextView txtViewChN;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        UUID uid = (UUID) getArguments().getSerializable(ARG_CHARA_ID);
        List<Character> mChs = CharacterLab.get().getCharacterList();
        currentCharacter = CharacterLab.get().getCharacter(uid);
        /*
        mChs.forEach(el -> {
            if(el.getmId().equals(uid)) {
                currentCharacter = el;
                return;
            }
        });*/
        view = inflater.inflate(R.layout.character_layout, container, false);
        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.v(TAG, "当前： " + currentCharacter.getmName());
        txtViewNicN = view.findViewById(R.id.chara_name_textview);
        txtViewNicN.setText(currentCharacter.getmNickName());
        txtViewProN = view.findViewById(R.id.chara_program_name_textview);
        txtViewProN.setText(currentCharacter.getmProgramName());
        imgView = view.findViewById(R.id.chara_program_img_imgview);
        imgBtn = view.findViewById(R.id.imgbtn);
        playBtn = view.findViewById(R.id.playbtn);
        imgView.setImageResource(currentCharacter.getmProgramPicId());
        imgBtn.setImageResource(currentCharacter.getmCharacterPicId());
        playBtn.setOnClickListener(v -> {
            if (player == null) {
                player = MediaPlayer.create(getActivity(), currentCharacter.getmProgram());
                player.setLooping(true);
                player.start();
                playBtn.setImageResource(R.drawable.ic_action_pause);
            } else if (player.isPlaying()) {
                player.pause();
                playBtn.setImageResource(R.drawable.ic_action_play);
                Toast.makeText(getContext(), "已暂停", Toast.LENGTH_SHORT).show();
            } else if (isStopped) {
                try {
                    player.prepare();
                } catch (IOException e) {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                player.seekTo(currentPlayingSec);
            } else {
                player.start();
                Log.v(TAG, "继续播放");
                playBtn.setImageResource(R.drawable.ic_action_pause);
                Toast.makeText(getContext(), "继续播放", Toast.LENGTH_SHORT).show();
            }
        });
        txtViewChN = view.findViewById(R.id.textview1);
        imgBtn.setOnClickListener(v -> {
            txtViewChN.setText(currentCharacter.getmName());
        });

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();

        if (player != null && player.isPlaying()) {
            currentPlayingSec = player.getCurrentPosition();
            player.stop();
            isStopped = true;
            playBtn.setImageResource(R.drawable.ic_action_play);
            Toast.makeText(getContext(), "已停止", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(player != null) player.release();
    }


}
