package edu.galileo.android.workingtimeapp.login;


import android.util.Log;

import org.greenrobot.eventbus.Subscribe;

import edu.galileo.android.workingtimeapp.lib.EventBus;
import edu.galileo.android.workingtimeapp.lib.GreenRobotEventBus;
import edu.galileo.android.workingtimeapp.login.Events.LoginEvent;
import edu.galileo.android.workingtimeapp.login.ui.LoginView;

/**
 * Created by Hiro on 17/07/2016.
 */
public class LoginPresenterImpl implements LoginPresenter {
    private LoginView view;
    private EventBus eventBus;
    private LoginInteractor interactor;

    public LoginPresenterImpl(LoginView view) {
        this.view = view;
        this.interactor = new LoginInteractorImpl();
        this.eventBus = GreenRobotEventBus.getInstance();
    }

    @Override
    public void onCreate(){
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        view = null;
        eventBus.unregister(this);
    }

    @Override
    public void checkForAuthenticatedUser() {
        if( view != null){
            view.disableInputs();
            view.showProgress();
        }
        interactor.checkSession();
    }

    @Override
    public void validateLogin(String email, String password) {
        if( view != null){
            view.disableInputs();
            view.showProgress();
        }
        interactor.doSignIn(email, password);

    }

    @Override
    public void registerNewUser(String email, String password) {
        if( view != null){
            view.disableInputs();
            view.showProgress();
        }
        interactor.doSignUp(email, password);
    }

    @Override
    @Subscribe
    public void onEventMainThread(LoginEvent event) {
        switch (event.getEventType()){
            case LoginEvent.onSignInSuccess:
                onSignInSuccess();
                break;
            case LoginEvent.onSignUpSuccess:
                onSignUpSuccess();
                break;
            case LoginEvent.onSignInError:
                onSignInError(event.getErrorMessage());
                break;
            case LoginEvent.onSignUpError:
                onSignUpError(event.getErrorMessage());
                break;
            case LoginEvent.onFailedToRecoverSession:
                onFailedRecoverSession();
                break;
        }
    }

    private void onFailedRecoverSession() {
        if( view != null) {
            view.hideProgress();
            view.enableInputs();
        }
        Log.e("LoginPresenterImpl", "onFailedRecoverSession");
    }

    private void onSignInSuccess(){
        if( view != null){
            view.navigateToMainScreen();
        }
    }

    private void onSignUpSuccess(){
        if( view != null){
            view.newUserSuccess();
        }
    }

    private void onSignInError(String error){
        if( view != null){
            view.hideProgress();
            view.enableInputs();
            view.loginError(error);
        }
    }

    private void onSignUpError(String error){
        if( view != null){
            view.hideProgress();
            view.enableInputs();
            view.userSignUpError(error);
        }
    }
}
