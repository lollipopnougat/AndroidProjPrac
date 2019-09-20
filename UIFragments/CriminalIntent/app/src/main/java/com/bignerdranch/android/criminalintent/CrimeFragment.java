package com.bignerdranch.android.criminalintent;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;



public class CrimeFragment extends Fragment {
    private static final String TAG="Test";
    private Crime mCrime;
    private EditText mTitleField;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG,"调用CrimeFragment的onCreate方法");
        mCrime = new Crime();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime, container, false);
        Log.v(TAG,"调用CrimeFragment的onCreateView方法");
        mTitleField = (EditText) v.findViewById(R.id.crime_title);
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        Log.v(TAG,"调用CrimeFragment的onAttach方法");
        super.onAttach(context);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.v(TAG,"调用CrimeFragment的onActivityCreated方法");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.v(TAG,"调用CrimeFragment的onStart方法");
        super.onStart();
    }

    @Override
    public void onStop() {
        Log.v(TAG,"调用CrimeFragment的onStop方法");
        super.onStop();
    }

    @Override
    public void onResume() {
        Log.v(TAG,"调用CrimeFragment的onResume方法");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.v(TAG,"调用CrimeFragment的onPause方法");
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Log.v(TAG,"调用CrimeFragment的onSaveInstanceState方法");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        Log.v(TAG,"调用CrimeFragment的onDestroyView方法");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.v(TAG,"调用CrimeFragment的onDestroy方法");
        super.onDestroy();
    }
}
