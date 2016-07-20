package edu.galileo.android.workingtimeapp.login.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.galileo.android.workingtimeapp.R;
import edu.galileo.android.workingtimeapp.login.LoginPresenter;
import edu.galileo.android.workingtimeapp.login.LoginPresenterImpl;
import edu.galileo.android.workingtimeapp.timemarklist.ui.TimeMarkListActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @Bind(R.id.editTxtEmail)
    EditText inputEmail;
    @Bind(R.id.editTxtPassword)
    EditText inputPassword;
    @Bind(R.id.btnSignin)
    Button btnSignin;
    @Bind(R.id.btnSignup)
    Button btnSignup;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.layoutMainContainer)
    RelativeLayout container;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        presenter = new LoginPresenterImpl(this);
        presenter.onCreate();
        presenter.checkForAuthenticatedUser();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void enableInputs() {
        setInputs(true);
    }

    @Override
    public void disableInputs() {
        setInputs(false);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @OnClick(R.id.btnSignin)
    @Override
    public void handleSignIn() {
        presenter.validateLogin(inputEmail.getText().toString(),
                                inputPassword.getText().toString());
    }

    @Override
    public void loginError(String error) {
        inputPassword.setText("");
        String msgError = String.format(getString(R.string.login_error_message_signin), error);
        inputPassword.setError(msgError);
    }

    @Override
    public void navigateToMainScreen() {
        startActivity(new Intent(this, TimeMarkListActivity.class));
    }

    @OnClick(R.id.btnSignup)
    @Override
    public void handleSignUp() {
        presenter.registerNewUser( inputEmail.getText().toString(),
                                inputPassword.getText().toString());
    }

    @Override
    public void userSignUpError(String error) {
        inputPassword.setText("");
        String msgError = String.format(getString(R.string.login_notice_message_signup), error);
        inputPassword.setError(msgError);
    }

    @Override
    public void newUserSuccess() {
        Snackbar.make(container, getString(R.string.login_notice_message_signup),Snackbar.LENGTH_SHORT).show();
    }

    private void setInputs(boolean enabled) {
        inputEmail.setEnabled(enabled);
        inputPassword.setEnabled(enabled);
        btnSignin.setEnabled(enabled);
        btnSignup.setEnabled(enabled);
    }
}
