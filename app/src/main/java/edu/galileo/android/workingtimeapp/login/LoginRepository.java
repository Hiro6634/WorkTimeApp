package edu.galileo.android.workingtimeapp.login;

/**
 * Created by Hiro on 17/07/2016.
 */
public interface LoginRepository {
    void signUp( String email, String password);
    void signIn( String email, String password);
    void checkSession();
}
