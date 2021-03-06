package myapplication.ui.activities

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem

import com.turing.sean.myapplication.R
import myapplication.ui.fragments.DoctorDetailFragment

/**
 * An activity representing a single Doctor detail screen. This
 * activity is only used narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of doctors
 * in a [ChooseSectionActivity].
 */
class DoctorDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_detail)

        val toolbar = findViewById(R.id.detail_toolbar) as Toolbar
        toolbar.title = "选择医生"
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
            actionBar.setShowHideAnimationEnabled(true)
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = "牟小芬"
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
            arguments.putString(DoctorDetailFragment.ARG_DOCTOR_ID, intent.getStringExtra(DoctorDetailFragment.ARG_DOCTOR_ID))
            val fragment = DoctorDetailFragment()
            fragment.arguments = arguments
            supportFragmentManager.beginTransaction().add(R.id.doctor_detail_container, fragment).commit()
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
            NavUtils.navigateUpTo(this, Intent(this, ChooseSectionActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
