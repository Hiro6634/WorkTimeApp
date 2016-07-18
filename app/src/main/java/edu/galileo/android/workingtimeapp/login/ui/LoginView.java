package edu.galileo.android.workingtimeapp.login.ui;

/**
 * Created by Hiro on 17/07/2016.
 */
public interface LoginView {
    void enableInputs();
    void disableInputs();
    void showProgress();
    void hideProgress();
    void loginError(String error);
    void navigateToMainScreen();
    void newUserSuccess();
    void userSignUpError(String error);
    void handleSignIn();
    void handleSignUp();
}
