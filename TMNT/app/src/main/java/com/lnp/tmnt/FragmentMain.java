package com.lnp.tmnt;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

import java.io.IOException;

public class FragmentMain extends Fragment {
    private static final String TAG = "Test";
    private MediaPlayer player;
    private View view;
    private int currentSelectItemName = R.string.Leo;
    private int currentPlayingSec;
    private boolean isStopped = false;

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
            Log.v(TAG,"player.current:"+player.getCurrentPosition());
            if (player.isPlaying()) {
                player.pause();
                playBtn.setImageResource(R.drawable.ic_action_play);
                Toast.makeText(getContext(), "已暂停", Toast.LENGTH_SHORT).show();
            } else {
                if(isStopped) {
                    try {
                        player.prepare();
                    } catch (IOException e) {
                        Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                    player.seekTo(currentPlayingSec);
                }
                player.start();
                Log.v(TAG,"继续播放");
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
            if(!isStopped) {
                player.setLooping(true);
                player.start();
                isStopped = false;
            }


        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (player.isPlaying()) {
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
        player.release();
    }


}
