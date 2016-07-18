package edu.galileo.android.workingtimeapp.login;

import edu.galileo.android.workingtimeapp.login.Events.LoginEvent;

/**
 * Created by Hiro on 17/07/2016.
 */
public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void checkForAuthenticatedUser();
    void validateLogin(String email, String password);
    void registerNewUser( String email, String password);
    void onEventMainThread(LoginEvent event);
}
