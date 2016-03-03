package myapplication.ui.activities

import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.content.Context
import android.support.v7.widget.ThemedSpinnerAdapter
import android.content.res.Resources.Theme

import android.widget.TextView

import com.turing.sean.myapplication.R
import myapplication.ui.fragments.DoctorListFragment

class ChooseSectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_section)

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar!!
        actionBar!!.setDisplayShowTitleEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.title = "选择科室"

        // Setup spinner
        val spinner = findViewById(R.id.spinner) as Spinner
        spinner.adapter = MyAdapter(
                toolbar.context,
                arrayOf("内科", "外科", "妇产科", "儿科", "骨科", "肿瘤科", "皮肤性病科", "眼科", "口腔科", "耳鼻喉科", "精神心理科", "男科", "整形美容科", "中医科", "传染科", "生殖医学科", "急诊科"))

        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // When the given dropdown item is selected, show its contents in the container view.
                supportFragmentManager.beginTransaction().replace(R.id.container, DoctorListFragment.newInstance(position)).commit()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

        //        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //        fab.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View view) {
        //                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //                        .setAction("Action", null).show();
        //            }
        //        });

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_choose_section, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        val id = item.itemId

        //noinspection SimplifiableIfStatement
        //        if (id == R.id.action_settings) {
        //            return true;
        //        }

        return super.onOptionsItemSelected(item)
    }


    private class MyAdapter(context: Context, objects: Array<String>) : ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, objects), ThemedSpinnerAdapter {
        private val mDropDownHelper: ThemedSpinnerAdapter.Helper

        init {
            mDropDownHelper = ThemedSpinnerAdapter.Helper(context)
        }

        override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view: View

            if (convertView == null) {
                // Inflate the drop down using the helper's LayoutInflater
                val inflater = mDropDownHelper.dropDownViewInflater
                view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
            } else {
                view = convertView
            }

            val textView = view.findViewById(android.R.id.text1) as TextView
            textView.text = getItem(position)

            return view
        }

        override fun getDropDownViewTheme(): Theme? {
            return mDropDownHelper.dropDownViewTheme
        }

        override fun setDropDownViewTheme(theme: Theme?) {
            mDropDownHelper.dropDownViewTheme = theme
        }
    }
}
