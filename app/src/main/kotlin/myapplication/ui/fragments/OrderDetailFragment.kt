package myapplication.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.AppCompatButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import myapplication.dummy.DummyOrders
import myapplication.ui.activities.OrderDetailActivity
import com.turing.sean.myapplication.R

/**
 * A fragment representing a single Order detail screen.
 * This fragment is either contained in a [OrderDetailActivity]
 * in two-pane mode (on tablets) or a [OrderDetailActivity]
 * on handsets.
 */
class OrderDetailFragment : Fragment() {

    /**
     * The dummy Orders this fragment is presenting.
     */
    private var mOrder: DummyOrders.DummyOrder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments.containsKey(ARG_ORDER_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mOrder = DummyOrders.ORDER_MAP[arguments.getString(ARG_ORDER_ID)]

            //            Activity activity = this.getActivity();
            //            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            //            if (appBarLayout != null) {
            //                appBarLayout.setTitle("我的预约");
            //            }


        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_order_detail, container, false)

        // Show the dummy order as text in a TextView.
        if (mOrder != null) {
            //            ((TextView) rootView.findViewById(R.id.aaa)).setText(mOrder.details);
        }

        val button = rootView.findViewById(R.id.button) as AppCompatButton

        val flag = activity.intent.getStringExtra("flag")

        if (flag == "modify") {
            button.text = "预约修改"
            button.setOnClickListener { }
        } else if (flag == "submit") {
            button.text = "去支付"
            button.setOnClickListener { }
        }

        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the oder ID that this fragment represents.
         */
        val ARG_ORDER_ID = "order_id"
    }
}
/**
 * Mandatory empty constructor for the fragment manager to instantiate the
 * fragment (e.g. upon screen orientation changes).
 */
