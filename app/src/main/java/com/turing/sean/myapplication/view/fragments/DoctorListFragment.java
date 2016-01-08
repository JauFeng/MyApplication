package com.turing.sean.myapplication.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.turing.sean.myapplication.R;
import com.turing.sean.myapplication.dummy.DummyDoctors;
import com.turing.sean.myapplication.view.adapters.DoctorRecyclerViewAdapter;

/**
 * A doctor list fragment containing a recycler view.
 */
public class DoctorListFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * The section number index.
     */
    private int sectionNumber = 0;


    public DoctorListFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section number.
     */
    public static DoctorListFragment newInstance(int sectionNumber) {
        DoctorListFragment fragment = new DoctorListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_choose_section, container, false);

        // TODO: 1/5/2016 Set section label
//        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//        textView.setText(getString(R.string.section_format, sectionNumber));

        // Set recycler view.
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.doctor_list);

        if (recyclerView != null) {
            Context context = rootView.getContext();
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        }

        // Set recycler view's adapter.
        assert recyclerView != null;
        recyclerView.setAdapter(new DoctorRecyclerViewAdapter(DummyDoctors.DOCTORS));

        return rootView;
    }
}
