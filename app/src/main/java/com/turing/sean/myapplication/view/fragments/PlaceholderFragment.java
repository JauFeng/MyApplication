package com.turing.sean.myapplication.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.turing.sean.myapplication.dummy.DummyOrders;
import com.turing.sean.myapplication.view.adapters.OrderRecyclerViewAdapter;
import com.turing.sean.myapplication.R;

/**
 * A placeholder fragment containing a recycler view.
 */
public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * The section number index.
     */
    private int sectionNumber = 0;


    public PlaceholderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // TODO: 1/5/2016 Set section label
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//        textView.setText(getString(R.string.section_format, sectionNumber));
        textView.setText(getString(R.string.section_one_label));


        // Set recycler view.
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.order_list);

        if (recyclerView != null) {
            Context context = rootView.getContext();
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        }

        // Set recycler view's adapter.
        assert recyclerView != null;
        recyclerView.setAdapter(new OrderRecyclerViewAdapter(DummyOrders.ORDERS));

        return rootView;
    }




}
