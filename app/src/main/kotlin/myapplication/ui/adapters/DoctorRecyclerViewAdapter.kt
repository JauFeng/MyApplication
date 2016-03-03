package myapplication.ui.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.turing.sean.myapplication.R
import myapplication.dummy.DummyDoctors
import myapplication.ui.activities.DoctorDetailActivity
import myapplication.ui.fragments.DoctorDetailFragment

/**
 * Adapter for doctor list recycler view.
 */
class DoctorRecyclerViewAdapter(private val mValues: List<DummyDoctors.DummyDoctor>) : RecyclerView.Adapter<DoctorRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_doctor_list_content, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mDoctor = mValues[position]

        //        holder.mIdView.setText(mValues.get(position).id);
        holder.mDoctorNameView.text = mValues[position].doctorName
        holder.mDoctorTitleView.text = mValues[position].doctorTitle
        holder.mDoctorHospitalView.text = mValues[position].doctorHospital
        holder.mDoctorFeatureView.text = mValues[position].doctorFeature

        holder.mView.setOnClickListener { v ->
            val context = v.context
            val intent = Intent(context, DoctorDetailActivity::class.java)
            intent.putExtra(DoctorDetailFragment.ARG_DOCTOR_ID, holder.mDoctor.id)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        //        public final TextView mIdView;
        val mDoctorNameView: TextView
        val mDoctorTitleView: TextView
        val mDoctorHospitalView: TextView
        val mDoctorFeatureView: TextView

        lateinit var mDoctor: DummyDoctors.DummyDoctor

        init {
            //            mIdView = (TextView) view.findViewById(R.id.id);

            mDoctorNameView = mView.findViewById(R.id.doctor_name) as TextView
            mDoctorTitleView = mView.findViewById(R.id.doctor_title) as TextView
            mDoctorHospitalView = mView.findViewById(R.id.doctor_hospital) as TextView
            mDoctorFeatureView = mView.findViewById(R.id.doctor_feature) as TextView

        }

        override fun toString(): String {
            return "ViewHolder{mView=$mView, mDoctorNameView=$mDoctorNameView, mDoctorTitleView=$mDoctorTitleView, mDoctorHospitalView=$mDoctorHospitalView, mDoctorFeatureView=$mDoctorFeatureView, mDoctor=$mDoctor}"
        }
    }
}
