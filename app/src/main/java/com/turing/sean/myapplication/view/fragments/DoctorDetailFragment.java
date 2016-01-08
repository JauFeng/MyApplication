package com.turing.sean.myapplication.view.fragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.turing.sean.myapplication.R;
import com.turing.sean.myapplication.dummy.DummyDoctors;
import com.turing.sean.myapplication.view.activities.OrderDetailActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * A fragment representing a single Doctor detail screen.
 * This fragment is either contained in a {@link com.turing.sean.myapplication.view.activities.DoctorDetailActivity}
 * in two-pane mode (on tablets) or a {@link com.turing.sean.myapplication.view.activities.DoctorDetailActivity}
 * on handsets.
 */
public class DoctorDetailFragment extends Fragment {
    /**
     * The fragment argument representing the doctor ID that this fragment represents.
     */
    public static final String ARG_DOCTOR_ID = "doctor_id";

    /**
     * The dummy Doctors this fragment is presenting.
     */
    private DummyDoctors.DummyDoctor mDoctor;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public DoctorDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_DOCTOR_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mDoctor = DummyDoctors.DOCTOR_MAP.get(getArguments().getString(ARG_DOCTOR_ID));

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
        View rootView = inflater.inflate(R.layout.fragment_doctor_detail, container, false);

        // Show the dummy doctor as text in a TextView.
        if (mDoctor != null) {
//            ((TextView) rootView.findViewById(R.id.text_view)).setText(mDoctor.details);
        }

        final Calendar now = Calendar.getInstance();

        final AppCompatEditText date = (AppCompatEditText) rootView.findViewById(R.id.order_date);

        date.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        date.setText(String.format("%d-%d-%d", year, monthOfYear + 1, dayOfMonth));
                    }
                }, now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));

                datePickerDialog.show();
            }
        });


        final AppCompatEditText time = (AppCompatEditText) rootView.findViewById(R.id.order_time);

        time.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        time.setText(String.format("%d:%d", hourOfDay, minute));
                    }
                }, now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), true);

                timePickerDialog.show();
            }
        });


        AppCompatButton button = (AppCompatButton) rootView.findViewById(R.id.submit_order);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OrderDetailActivity.class);
                intent.putExtra("flag", "submit");
                intent.putExtra("title", "确认预约");
                startActivity(intent);
            }
        });


        return rootView;
    }
}
