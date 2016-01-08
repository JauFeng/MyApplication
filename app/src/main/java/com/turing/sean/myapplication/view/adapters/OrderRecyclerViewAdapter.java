package com.turing.sean.myapplication.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.turing.sean.myapplication.dummy.DummyOrders;
import com.turing.sean.myapplication.view.activities.OrderDetailActivity;
import com.turing.sean.myapplication.R;
import com.turing.sean.myapplication.view.fragments.OrderDetailFragment;

import java.util.List;

/**
 * Adapter for order list recycler view.
 */
public class OrderRecyclerViewAdapter extends RecyclerView.Adapter<OrderRecyclerViewAdapter.ViewHolder> {

    private final List<DummyOrders.DummyOrder> mValues;

    public OrderRecyclerViewAdapter(List<DummyOrders.DummyOrder> orders) {
        mValues = orders;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_order_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mOrder = mValues.get(position);

//        holder.mIdView.setText(mValues.get(position).id);
        holder.mTypeView.setText(mValues.get(position).orderType);
        holder.mDoctorView.setText(mValues.get(position).doctorName);
        holder.mSectionView.setText(mValues.get(position).section);
        holder.mDateView.setText(mValues.get(position).orderDate);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context context = v.getContext();
                Intent intent = new Intent(context, OrderDetailActivity.class);
                intent.putExtra(OrderDetailFragment.ARG_ORDER_ID, holder.mOrder.id);

                intent.putExtra("flag", "modify");
                intent.putExtra("title", "我的预约");

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
        public final TextView mTypeView;
        public final TextView mDoctorView;
        public final TextView mSectionView;
        public final TextView mDateView;

        public DummyOrders.DummyOrder mOrder;

        public ViewHolder(View view) {
            super(view);
            mView = view;
//            mIdView = (TextView) view.findViewById(R.id.id);

            mTypeView = (TextView) view.findViewById(R.id.order_type);
            mDoctorView = (TextView) view.findViewById(R.id.order_doctor);
            mSectionView = (TextView) view.findViewById(R.id.order_section);
            mDateView = (TextView) view.findViewById(R.id.order_date);

        }

        @Override
        public String toString() {
            return "ViewHolder{" +
                    "mView=" + mView +
                    ", mTypeView=" + mTypeView +
                    ", mDoctorView=" + mDoctorView +
                    ", mSectionView=" + mSectionView +
                    ", mDateView=" + mDateView +
                    ", mOrder=" + mOrder +
                    '}';
        }
    }
}
