package myapplication.ui.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.turing.sean.myapplication.R
import myapplication.dummy.DummyDoctors
import myapplication.ui.adapters.DoctorRecyclerViewAdapter

/**
 * A doctor list fragment containing a recycler view.
 */
class DoctorListFragment : Fragment() {

    /**
     * The section number index.
     */
    private var sectionNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            sectionNumber = arguments.getInt(ARG_SECTION_NUMBER)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_choose_section, container, false)

        // TODO: 1/5/2016 Set section label
        //        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        //        textView.setText(getString(R.string.section_format, sectionNumber));

        // Set recycler view.
        val recyclerView = rootView.findViewById(R.id.doctor_list) as? RecyclerView

        if (recyclerView != null) {
            val context = rootView.context
            recyclerView.layoutManager = LinearLayoutManager(context)
        }

        // Set recycler view's adapter.
        assert(recyclerView != null)
        recyclerView?.adapter = DoctorRecyclerViewAdapter(DummyDoctors.DOCTORS)

        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the section number for this fragment.
         */
        private val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section number.
         */
        fun newInstance(sectionNumber: Int): DoctorListFragment {
            val fragment = DoctorListFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}
