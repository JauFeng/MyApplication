package myapplication.ui.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import myapplication.dummy.DummyOrders
import myapplication.ui.activities.OrderDetailActivity
import com.turing.sean.myapplication.R
import myapplication.ui.fragments.OrderDetailFragment

/**
 * Adapter for order list recycler view.
 */
class OrderRecyclerViewAdapter(private val mValues: List<DummyOrders.DummyOrder>) : RecyclerView.Adapter<OrderRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_order_list_content, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mOrder = mValues[position]

        //        holder.mIdView.setText(mValues.get(position).id);
        holder.mTypeView.text = mValues[position].orderType
        holder.mDoctorView.text = mValues[position].doctorName
        holder.mSectionView.text = mValues[position].section
        holder.mDateView.text = mValues[position].orderDate

        holder.mView.setOnClickListener { v ->
            val context = v.context
            val intent = Intent(context, OrderDetailActivity::class.java)
            intent.putExtra(OrderDetailFragment.ARG_ORDER_ID, holder.mOrder.id)

            intent.putExtra("flag", "modify")
            intent.putExtra("title", "我的预约")

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        //        public final TextView mIdView;
        val mTypeView: TextView
        val mDoctorView: TextView
        val mSectionView: TextView
        val mDateView: TextView

        lateinit var mOrder: DummyOrders.DummyOrder

        init {
            //            mIdView = (TextView) view.findViewById(R.id.id);

            mTypeView = mView.findViewById(R.id.order_type) as TextView
            mDoctorView = mView.findViewById(R.id.order_doctor) as TextView
            mSectionView = mView.findViewById(R.id.order_section) as TextView
            mDateView = mView.findViewById(R.id.order_date) as TextView

        }

        override fun toString(): String {
            return "ViewHolder{mView=$mView, mTypeView=$mTypeView, mDoctorView=$mDoctorView, mSectionView=$mSectionView, mDateView=$mDateView, mOrder=$mOrder}"
        }
    }
}
