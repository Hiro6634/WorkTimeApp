package edu.galileo.android.workingtimeapp.timemarklist;

import java.util.Date;

/**
 * Created by Hiro on 20/07/2016.
 */
public class TimeMarkListInteractorImpl implements TimeMarkListInteractor {
    private TimeMarkListRepository repository;


    public TimeMarkListInteractorImpl() {
        repository = new TimeMarkListRepositoryImpl();
    }

    @Override
    public void subscribe() {
        repository.subscribetoTimeMarkEvents();
    }

    @Override
    public void unsubscribe() {
        repository.unsubscribetoTimeMarkEvents();
    }

    @Override
    public void destroyListener() {
        repository.destroyListener();
    }

    @Override
    public void removeTimeMark(Date timeMarkdate) {
        repository.removeTimeMark(timeMarkdate);
    }
}
