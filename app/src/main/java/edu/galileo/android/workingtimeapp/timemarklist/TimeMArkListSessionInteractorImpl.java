package edu.galileo.android.workingtimeapp.timemarklist;

/**
 * Created by Hiro on 20/07/2016.
 */
public class TimeMarkListSessionInteractorImpl implements TimeMarkListSessionInteractor{
    private TimeMarkListRepository repository;

    public TimeMarkListSessionInteractorImpl() {
        repository = new TimeMarkListRepositoryImpl();
    }

    @Override
    public void signOff() {
        repository.signOff();
    }

    @Override
    public String getCurrentUserEmail() {
        return repository.getCurrentUserEmail();
    }
}
