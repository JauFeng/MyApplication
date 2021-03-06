package myapplication.ui.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.ActionBar
import android.support.v4.app.NavUtils
import android.view.MenuItem

import myapplication.MainActivity
import com.turing.sean.myapplication.R
import myapplication.ui.fragments.OrderDetailFragment

/**
 * An activity representing a single Order detail screen. This
 * activity is only used narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a [MainActivity].
 */
class OrderDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail)
        val toolbar = findViewById(R.id.detail_toolbar) as Toolbar
        setSupportActionBar(toolbar)

        //        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //        fab.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View view) {
        //                Snackbar.make(view, "Replace with your own detail action", Snackbar.LENGTH_LONG)
        //                        .setAction("Action", null).show();
        //            }
        //        });

        // Show the Up button in the action bar.
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)

            actionBar.title = intent.getStringExtra("title")
        }

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            val arguments = Bundle()
            arguments.putString(OrderDetailFragment.ARG_ORDER_ID,
                    intent.getStringExtra(OrderDetailFragment.ARG_ORDER_ID))
            val fragment = OrderDetailFragment()
            fragment.arguments = arguments
            supportFragmentManager.beginTransaction().add(R.id.order_detail_container, fragment).commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpTo(this, Intent(this, MainActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
