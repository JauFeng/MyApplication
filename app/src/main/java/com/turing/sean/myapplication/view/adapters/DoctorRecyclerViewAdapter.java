package com.turing.sean.myapplication.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.turing.sean.myapplication.R;
import com.turing.sean.myapplication.dummy.DummyDoctors;
import com.turing.sean.myapplication.view.activities.DoctorDetailActivity;
import com.turing.sean.myapplication.view.fragments.DoctorDetailFragment;

import java.util.List;

/**
 * Adapter for doctor list recycler view.
 */
public class DoctorRecyclerViewAdapter extends RecyclerView.Adapter<DoctorRecyclerViewAdapter.ViewHolder> {

    private final List<DummyDoctors.DummyDoctor> mValues;

    public DoctorRecyclerViewAdapter(List<DummyDoctors.DummyDoctor> doctors) {
        mValues = doctors;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_doctor_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mDoctor = mValues.get(position);

//        holder.mIdView.setText(mValues.get(position).id);
        holder.mDoctorNameView.setText(mValues.get(position).doctorName);
        holder.mDoctorTitleView.setText(mValues.get(position).doctorTitle);
        holder.mDoctorHospitalView.setText(mValues.get(position).doctorHospital);
        holder.mDoctorFeatureView.setText(mValues.get(position).doctorFeature);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context context = v.getContext();
                Intent intent = new Intent(context, DoctorDetailActivity.class);
                intent.putExtra(DoctorDetailFragment.ARG_DOCTOR_ID, holder.mDoctor.id);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        //        public final TextView mIdView;
        public final TextView mDoctorNameView;
        public final TextView mDoctorTitleView;
        public final TextView mDoctorHospitalView;
        public final TextView mDoctorFeatureView;

        public DummyDoctors.DummyDoctor mDoctor;

        public ViewHolder(View view) {
            super(view);
            mView = view;
//            mIdView = (TextView) view.findViewById(R.id.id);

            mDoctorNameView = (TextView) view.findViewById(R.id.doctor_name);
            mDoctorTitleView = (TextView) view.findViewById(R.id.doctor_title);
            mDoctorHospitalView = (TextView) view.findViewById(R.id.doctor_hospital);
            mDoctorFeatureView = (TextView) view.findViewById(R.id.doctor_feature);

        }

        @Override
        public String toString() {
            return "ViewHolder{" +
                    "mView=" + mView +
                    ", mDoctorNameView=" + mDoctorNameView +
                    ", mDoctorTitleView=" + mDoctorTitleView +
                    ", mDoctorHospitalView=" + mDoctorHospitalView +
                    ", mDoctorFeatureView=" + mDoctorFeatureView +
                    ", mDoctor=" + mDoctor +
                    '}';
        }
    }
}
