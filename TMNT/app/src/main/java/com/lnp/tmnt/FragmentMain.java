package com.lnp.tmnt;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class FragmentMain extends Fragment {
    private MediaPlayer player;
    private View view;
    private int currentSelectItemName = R.string.Leo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_layout, container, false);
        player = MediaPlayer.create(getActivity(), R.raw.tmnt_theme);
        return view;
    }

    private ImageButton imgBtn;
    private ImageButton playBtn;
    private TextView txtView;

    @Override
    public void onStart() {
        super.onStart();
        imgBtn = view.findViewById(R.id.imgbtn);
        playBtn = view.findViewById(R.id.playbtn);
        playBtn.setOnClickListener(v -> {
            if (player.isPlaying()) {
                player.pause();
                playBtn.setImageResource(R.drawable.ic_action_play);
                Toast.makeText(getContext(), "已暂停", Toast.LENGTH_SHORT).show();
            } else {
                player.start();
                playBtn.setImageResource(R.drawable.ic_action_pause);
                Toast.makeText(getContext(), "继续播放", Toast.LENGTH_SHORT).show();
            }
        });
        txtView = view.findViewById(R.id.textview1);
        RadioGroup radGroup = view.findViewById(R.id.radiogroup);
        imgBtn.setOnClickListener(v -> {
            txtView.setText(currentSelectItemName);
        });
        radGroup.setOnCheckedChangeListener((g, checkedID) -> {
            switch (checkedID) {
                case R.id.btn1:
                    currentSelectItemName = R.string.Leo;
                    imgBtn.setImageResource(R.drawable.tmntleo);
                    break;
                case R.id.btn2:
                    currentSelectItemName = R.string.Mike;
                    imgBtn.setImageResource(R.drawable.tmntmike);
                    break;
                case R.id.btn3:
                    currentSelectItemName = R.string.Don;
                    imgBtn.setImageResource(R.drawable.tmntdon);
                    break;
                case R.id.btn4:
                    currentSelectItemName = R.string.Raph;
                    imgBtn.setImageResource(R.drawable.tmntraph);
                    break;
                default:
                    break;
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        if (player != null) {
            player.setLooping(true);
            player.start();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (player.isPlaying()) player.stop();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.release();
    }


}
