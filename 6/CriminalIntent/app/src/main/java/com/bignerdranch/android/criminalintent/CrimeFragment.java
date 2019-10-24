package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

public class CrimeFragment extends Fragment {

    private static final String ARG_CRIME_ID = "crime_id";
    private static final String DIALOG_DATE = "DialogDate";
    private static final String DIALOG_TIME = "DialogTime";
    private static final int REQUEST_DATE = 0;
    private static final int REQUEST_TIME = 1;

    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private Button mTimeButton;
    private CheckBox mSolvedCheckBox;

    public static CrimeFragment newInstance(UUID crimeId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, crimeId);

        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID crimeId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);
        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime, container, false);

        mTitleField = v.findViewById(R.id.crime_title);
        mTitleField.setText(mCrime.getTitle());
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

        mDateButton = v.findViewById(R.id.crime_date);
        mTimeButton = v.findViewById(R.id.crime_time);
        updateDate();
        mDateButton.setOnClickListener(vi -> {
            FragmentManager manager = getFragmentManager();
            DatePickerFragment dialog = DatePickerFragment
                    .newInstance(mCrime.getDate());
            dialog.setTargetFragment(this, REQUEST_DATE);
            dialog.show(manager, DIALOG_DATE);

        });

        mTimeButton.setOnClickListener(vi -> {
            FragmentManager manager = getFragmentManager();
            TimePickerFragment dialog = TimePickerFragment
                    .newInstance(mCrime.getDate());
            dialog.setTargetFragment(this, REQUEST_TIME);
            dialog.show(manager, DIALOG_TIME);
        });

        mSolvedCheckBox = v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setChecked(mCrime.isSolved());
        mSolvedCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            mCrime.setSolved(isChecked);
        });
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_DATE) {
            Date date = (Date) data
                    .getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            //mCrime.setDate(date);
            Calendar calendarc = Calendar.getInstance();
            Calendar mcal = Calendar.getInstance();
            mcal.setTime(mCrime.getDate());
            calendarc.setTime(date);
            Date daten = new GregorianCalendar(calendarc.get(Calendar.YEAR), calendarc.get(Calendar.MONTH), calendarc.get(Calendar.DAY_OF_MONTH), mcal.get(Calendar.HOUR_OF_DAY), mcal.get(Calendar.MINUTE)).getTime();
            mCrime.setDate(daten);
            updateDate();
        }
        else if (requestCode == REQUEST_TIME) {
            Date date = (Date) data.getSerializableExtra(TimePickerFragment.EXTRA_TIME);
            Calendar calendarc = Calendar.getInstance();
            Calendar mcal = Calendar.getInstance();
            mcal.setTime(mCrime.getDate());
            calendarc.setTime(date);
            Date daten = new GregorianCalendar(mcal.get(Calendar.YEAR), mcal.get(Calendar.MONTH), mcal.get(Calendar.DAY_OF_MONTH), calendarc.get(Calendar.HOUR_OF_DAY), calendarc.get(Calendar.MINUTE)).getTime();
            mCrime.setDate(daten);
            updateDate();

        }
    }

    private void updateDate() {
        String date = (String) DateFormat.format("EEEE, MMMM d, yyyy", mCrime.getDate());
        String time = (String) DateFormat.format("h:mm a", mCrime.getDate());
        mDateButton.setText(date);
        mTimeButton.setText(time);
    }
}
