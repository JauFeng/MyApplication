package myapplication.ui.fragments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatEditText
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker

import com.turing.sean.myapplication.R
import myapplication.dummy.DummyDoctors
import myapplication.ui.activities.OrderDetailActivity

import java.util.Calendar

import myapplication.ui.activities.DoctorDetailActivity

/**
 * A fragment representing a single Doctor detail screen.
 * This fragment is either contained in a [DoctorDetailActivity]
 * in two-pane mode (on tablets) or a [DoctorDetailActivity]
 * on handsets.
 */
class DoctorDetailFragment : Fragment() {

    /**
     * The dummy Doctors this fragment is presenting.
     */
    private var mDoctor: DummyDoctors.DummyDoctor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments.containsKey(ARG_DOCTOR_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mDoctor = DummyDoctors.DOCTOR_MAP[arguments.getString(ARG_DOCTOR_ID)]

            //            Activity activity = this.getActivity();
            //            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            //            if (appBarLayout != null) {
            //                appBarLayout.setTitle("我的预约");
            //            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_doctor_detail, container, false)

        // Show the dummy doctor as text in a TextView.
        if (mDoctor != null) {
            //            ((TextView) rootView.findViewById(R.id.text_view)).setText(mDoctor.details);
        }

        val now = Calendar.getInstance()

        val date = rootView.findViewById(R.id.order_date) as AppCompatEditText

        date.setOnClickListener {
            val datePickerDialog = DatePickerDialog(context, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth -> date.setText(String.format("%d-%d-%d", year, monthOfYear + 1, dayOfMonth)) }, now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH))

            datePickerDialog.show()
        }


        val time = rootView.findViewById(R.id.order_time) as AppCompatEditText

        time.setOnClickListener {
            val timePickerDialog = TimePickerDialog(context, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute -> time.setText(String.format("%d:%d", hourOfDay, minute)) }, now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), true)

            timePickerDialog.show()
        }


        val button = rootView.findViewById(R.id.submit_order) as AppCompatButton

        button.setOnClickListener {
            val intent = Intent(activity, OrderDetailActivity::class.java)
            intent.putExtra("flag", "submit")
            intent.putExtra("title", "确认预约")
            startActivity(intent)
        }


        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the doctor ID that this fragment represents.
         */
        val ARG_DOCTOR_ID = "doctor_id"
    }
}
/**
 * Mandatory empty constructor for the fragment manager to instantiate the
 * fragment (e.g. upon screen orientation changes).
 */
