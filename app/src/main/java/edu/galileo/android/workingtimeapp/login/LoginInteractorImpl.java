package edu.galileo.android.workingtimeapp.login;

/**
 * Created by Hiro on 17/07/2016.
 */
public class LoginInteractorImpl implements LoginInteractor {
    private LoginRepository repository;

    public LoginInteractorImpl() {
        repository = new LoginRepositoryImpl();
    }

    @Override
    public void checkSession() {
        repository.checkSession();
    }

    @Override
    public void doSignUp(String email, String password) {
        repository.signUp(email, password);
    }

    @Override
    public void doSignIn(String email, String password) {
        repository.signIn(email, password);
    }
}
