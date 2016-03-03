package myapplication.ui.activities

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.TargetApi
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.AsyncTask

import android.os.Build
import android.os.Bundle
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatEditText
import android.text.TextUtils
import android.view.KeyEvent
import android.view.View
import android.view.View.OnClickListener
import android.view.inputmethod.EditorInfo
import android.widget.TextView

import com.turing.sean.myapplication.R

import myapplication.MainActivity

import kotlinx.android.synthetic.main.activity_login.*
import myapplication.network.MyResponse
import myapplication.network.MyResponseService

import org.jetbrains.anko.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A login screen that offers login via mobile/password.
 */
class LoginActivity : AppCompatActivity(), AnkoLogger {
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    //    private var mAuthTask: UserLoginTask? = null

    // UI references.
    private lateinit var mMobileView: AppCompatEditText
    private lateinit var mPasswordView: AppCompatEditText
    private lateinit var mProgressView: View
    private lateinit var mLoginFormView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // Set up the login form.

        mMobileView = mobile

        mPasswordView = password

        password.setOnEditorActionListener(TextView.OnEditorActionListener { textView, id, keyEvent ->
            if (id == R.id.login || id == EditorInfo.IME_NULL) {
                //                attemptLogin()
                return@OnEditorActionListener true
            }
            false
        })

        mobile_sign_in_button.setOnClickListener {
            async() {
                val result = getResponse("123")
                info(result)
                startActivity<MainActivity>()
            }
        }

        mLoginFormView = login_form
        mProgressView = login_progress
    }

    private fun getResponse(param: String): MyResponse? {
        val retrofit2 = Retrofit.Builder()
                .baseUrl("https://echo.getpostman.com")
                .addConverterFactory(GsonConverterFactory.create()).build()

        val myResponseService: MyResponseService? = retrofit2.create(MyResponseService::class.java)

        val call: Call<MyResponse>? = myResponseService?.getResponse(param)

        return call?.execute()?.body()
    }


    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid mobile, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    //    private fun attemptLogin() {
    //        if (mAuthTask != null) {
    //            return
    //        }
    //
    //        // Reset errors.
    //        mMobileView!!.error = null
    //        mPasswordView!!.error = null
    //
    //        // Store values at the time of the login attempt.
    //        val mobile = mMobileView!!.text.toString()
    //        val password = mPasswordView!!.text.toString()
    //
    //        var cancel = false
    //        var focusView: View? = null
    //
    //        // Check for a valid password, if the user entered one.
    //        if (TextUtils.isEmpty(password) && !isPasswordValid(password)) {
    //            mPasswordView!!.error = getString(R.string.error_invalid_password)
    //            focusView = mPasswordView
    //            cancel = true
    //        }
    //
    //        // Check for a valid mobile address.
    //        if (TextUtils.isEmpty(mobile)) {
    //            mMobileView!!.error = getString(R.string.error_field_required)
    //            focusView = mMobileView
    //            cancel = true
    //        } else if (!isMobileValid(mobile)) {
    //            mMobileView!!.error = getString(R.string.error_invalid_mobile)
    //            focusView = mMobileView
    //            cancel = true
    //        }
    //
    //        if (cancel) {
    //            // There was an error; don't attempt login and focus the first
    //            // form field with an error.
    //            focusView!!.requestFocus()
    //        } else {
    //            // Show a progress spinner, and kick off a background task to
    //            // perform the user login attempt.
    //            showProgress(true)
    //            mAuthTask = UserLoginTask(mobile, password)
    //            mAuthTask!!.execute(null as Void)
    //        }
    //    }

    private fun isMobileValid(mobile: String): Boolean {
        //TODO: Replace this with your own logic
        return mobile.contains("150")
    }

    private fun isPasswordValid(password: String): Boolean {
        //TODO: Replace this with your own logic
        return password.length >= 8
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private fun showProgress(show: Boolean) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            val shortAnimTime = resources.getInteger(android.R.integer.config_shortAnimTime)

            login_form.visibility = if (show) View.GONE else View.VISIBLE
            login_form.animate().setDuration(shortAnimTime.toLong()).alpha(
                    (if (show) 0 else 1).toFloat()).setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    login_form.visibility = if (show) View.GONE else View.VISIBLE
                }
            })

            login_form.visibility = if (show) View.VISIBLE else View.GONE
            login_form.animate().setDuration(shortAnimTime.toLong()).alpha(
                    (if (show) 1 else 0).toFloat()).setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    login_form.visibility = if (show) View.VISIBLE else View.GONE
                }
            })
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            login_form.visibility = if (show) View.VISIBLE else View.GONE
            login_form.visibility = if (show) View.GONE else View.VISIBLE
        }
    }


    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    //    inner class UserLoginTask internal constructor(private val mMobile: String, private val mPassword: String) : AsyncTask<Void, Void, Boolean>() {
    //
    //        override fun doInBackground(vararg params: Void): Boolean? {
    //            // TODO: attempt authentication against a network service.
    //
    //            try {
    //                // Simulate network access.
    //                Thread.sleep(2000)
    //            } catch (e: InterruptedException) {
    //                return false
    //            }
    //
    //            for (credential in DUMMY_CREDENTIALS) {
    //                val pieces = credential.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    //                if (pieces[0] == mMobile) {
    //                    // Account exists, return true if the password matches.
    //                    return pieces[1] == mPassword
    //                }
    //            }
    //
    //            // TODO: register the new account here.
    //            return true
    //        }
    //
    //        override fun onPostExecute(success: Boolean?) {
    //            mAuthTask = null
    //            showProgress(false)
    //
    //            if (success!!) {
    //                //                finish();
    //                // TODO: 1/8/2016  entry main activity
    //                goForwardMainActivity()
    //            } else {
    //                mPasswordView!!.error = getString(R.string.error_incorrect_password)
    //                mPasswordView!!.requestFocus()
    //            }
    //        }
    //
    //        override fun onCancelled() {
    //            mAuthTask = null
    //            showProgress(false)
    //        }
    //    }


    fun goForwardMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    companion object {
        /**
         * A dummy authentication store containing known user names and passwords.
         * TODO: remove after connecting to a real authentication system.
         */
        private val DUMMY_CREDENTIALS = arrayOf("15001109204:crow1984", "15001109200:crow1984")
    }
}

