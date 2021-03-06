package com.tsdproject.pokerplanning.access

import android.content.Intent
import android.os.Bundle
import com.tsdproject.pokerplanning.R
import com.tsdproject.pokerplanning.base.BaseActivity
import com.tsdproject.pokerplanning.base.BasePresenter
import com.tsdproject.pokerplanning.createroom.CreateRoomActivity
import com.tsdproject.pokerplanning.model.utils.EditTextUtil
import com.tsdproject.pokerplanning.model.utils.ResUtil
import kotlinx.android.synthetic.main.activity_access.*

class AccessActivity : BaseActivity(), AccessView {

    private lateinit var presenter: AccessPresenter

    override fun providePresenter(): BasePresenter? {
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_access)
        presenter = AccessPresenterImpl(this)
        loginButton.setOnClickListener { onLoginButtonClick() }
    }

    private fun onLoginButtonClick() {
        EditTextUtil.checkIfEditTextEmpty(loginEditText)
        EditTextUtil.checkIfEditTextEmpty(passwordEditText)
        if (!isCredentialsError()) {
            presenter.login(loginEditText.text.toString(), passwordEditText.text.toString())
        }
    }

    private fun isCredentialsError(): Boolean {
        val isLoginError = !loginEditText.error.isNullOrEmpty()
        val isPasswordError = !passwordEditText.error.isNullOrEmpty()
        return isLoginError || isPasswordError
    }

    override fun navigateToCreateRoom(){
        startActivity(Intent(this, CreateRoomActivity::class.java))
    }

    override fun setInputErrors() {
        loginEditText.error = ResUtil.getString(R.string.wrong_login_password)
        passwordEditText.error = ResUtil.getString(R.string.wrong_login_password)
    }

    override fun clearEditTexts() {
        loginEditText.clearError()
        passwordEditText.clearError()
        loginEditText.setText("")
        passwordEditText.setText("")
    }

}
