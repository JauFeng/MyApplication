package com.turing.sean.myapplication.view.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.turing.sean.myapplication.dummy.DummyOrders;
import com.turing.sean.myapplication.view.activities.OrderDetailActivity;
import com.turing.sean.myapplication.R;

/**
 * A fragment representing a single Order detail screen.
 * This fragment is either contained in a {@link OrderDetailActivity}
 * in two-pane mode (on tablets) or a {@link OrderDetailActivity}
 * on handsets.
 */
public class OrderDetailFragment extends Fragment {
    /**
     * The fragment argument representing the oder ID that this fragment represents.
     */
    public static final String ARG_ORDER_ID = "order_id";

    /**
     * The dummy Orders this fragment is presenting.
     */
    private DummyOrders.DummyOrder mOrder;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public OrderDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ORDER_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mOrder = DummyOrders.ORDER_MAP.get(getArguments().getString(ARG_ORDER_ID));

//            Activity activity = this.getActivity();
//            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
//            if (appBarLayout != null) {
//                appBarLayout.setTitle("我的预约");
//            }


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_order_detail, container, false);

        // Show the dummy order as text in a TextView.
        if (mOrder != null) {
//            ((TextView) rootView.findViewById(R.id.aaa)).setText(mOrder.details);
        }

        AppCompatButton button = (AppCompatButton) rootView.findViewById(R.id.button);

        String flag = getActivity().getIntent().getStringExtra("flag");

        if (flag.equals("modify")) {
            button.setText("预约修改");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO: 1/8/2016 go to modify order
                }
            });
        } else if (flag.equals("submit")) {
            button.setText("去支付");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO: 1/8/2016 go to submit order
                }
            });
        }

        return rootView;
    }
}
