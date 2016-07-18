package edu.galileo.android.workingtimeapp.login;

/**
 * Created by Hiro on 17/07/2016.
 */
public interface LoginInteractor {
    void checkSession();
    void doSignUp( String email, String password);
    void doSignIn( String email, String password);
}
