package com.lnp.tmnt;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class CharacterListFragment extends Fragment {

    private static final String SAVED_SUBTITLE_VISIBLE = "subtitle";

    private RecyclerView mCrimeRecyclerView;
    private CharacterAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_character_list, container, false);
/*        Toolbar toolbar = view.findViewById(R.id.toolbar);
        //view.setSupportActionBar(toolbar);

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
        });*/
        mCrimeRecyclerView = view.findViewById(R.id.character_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }



    private void updateUI() {
        CharacterLab chLab = CharacterLab.get();
        List<com.lnp.tmnt.Character> chlst = chLab.getCharacterList();

        if (mAdapter == null) {
            mAdapter = new CharacterAdapter(chlst);
            mCrimeRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private class CharacterHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mChaName;
        private TextView mProgramName;
        private ImageView mProgramImg;

        private com.lnp.tmnt.Character mCh;

        public CharacterHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mChaName = itemView.findViewById(R.id.list_item_chara_name);
            mProgramName = itemView.findViewById(R.id.list_item_chara_program_name);
            mProgramImg = itemView.findViewById(R.id.list_item_chara_program_img);
        }

        public void bindCharacter(com.lnp.tmnt.Character ch) {
            mCh = ch;
            mChaName.setText(mCh.getmName());
            mProgramName.setText(mCh.getmProgramName());
            mProgramImg.setImageResource(mCh.getmProgramPicId());
        }

        @Override
        public void onClick(View v) {

            Intent intent = CharacterActivity.newIntent(getActivity(), mCh.getmId());
            startActivity(intent);
        }
    }

    private class CharacterAdapter extends RecyclerView.Adapter<CharacterHolder> {

        private List<com.lnp.tmnt.Character> mChs;

        public CharacterAdapter(List<com.lnp.tmnt.Character> crimes) {
            mChs = crimes;
        }

        @Override
        public CharacterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_chara, parent, false);
            return new CharacterHolder(view);
        }

        @Override
        public void onBindViewHolder(CharacterHolder holder, int position) {
            com.lnp.tmnt.Character ch = mChs.get(position);
            holder.bindCharacter(ch);
        }

        @Override
        public int getItemCount() {
            return mChs.size();
        }
    }
}
