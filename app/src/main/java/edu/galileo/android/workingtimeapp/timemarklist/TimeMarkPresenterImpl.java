package edu.galileo.android.workingtimeapp.timemarklist;

import org.greenrobot.eventbus.Subscribe;

import java.util.Date;

import edu.galileo.android.workingtimeapp.entities.TimeMark;
import edu.galileo.android.workingtimeapp.lib.EventBus;
import edu.galileo.android.workingtimeapp.lib.GreenRobotEventBus;
import edu.galileo.android.workingtimeapp.timemarklist.events.TimeMarkEvent;
import edu.galileo.android.workingtimeapp.timemarklist.ui.TimeMarkListView;

/**
 * Created by Hiro on 20/07/2016.
 */
public class TimeMarkPresenterImpl implements TimeMarkListPresenter {
    private EventBus eventBus;
    private TimeMarkListView view;
    private TimeMarkListInteractor listInteractor;
    private TimeMarkListSessionInteractor sessionInteractor;

    public TimeMarkPresenterImpl(TimeMarkListView view) {
        this.view = view;
        eventBus = GreenRobotEventBus.getInstance();
        this.listInteractor = new TimeMarkListInteractorImpl();
        this.sessionInteractor = new TimeMarkListSessionInteractorImpl();
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
        listInteractor.destroyListener();
        view = null;
    }

    @Override
    public void onPause() {
        listInteractor.unsubscribe();
    }

    @Override
    public void onResume() {
        listInteractor.subscribe();
    }

    @Override
    public void signOff() {
        listInteractor.unsubscribe();
        listInteractor.destroyListener();
        sessionInteractor.signOff();
    }

    @Override
    public String getCurrentUserEmail() {
        return sessionInteractor.getCurrentUserEmail();
    }

    @Override
    public void removeTimeMark( Date date) {
        listInteractor.removeTimeMark(date);
    }

    @Override
    @Subscribe
    public void onEventMainThread(TimeMarkEvent event) {
        TimeMark timeMark = event.getTimeMark();
        switch(event.getEventType()){
            case TimeMarkEvent.onTimeMarkAdded:
                onTimeMarkAdded(timeMark);
                break;
            case TimeMarkEvent.onTimeMarkChanged:
                onTimeMarkChanged(timeMark);
                break;
            case TimeMarkEvent.onTimeMarkRemoved:
                onTimeMarkRemoved(timeMark);
                break;
        }
    }

    private void onTimeMarkAdded(TimeMark timeMark){
        if( view != null){
            view.onTimeMarkAdded(timeMark);
        }
    }

    private void onTimeMarkChanged(TimeMark timeMark){
        if( view != null){
            view.onTimeMarkChanged(timeMark);
        }
    }

    private void onTimeMarkRemoved(TimeMark timeMark){
        if( view != null){
            view.onTimeMarkRemoved(timeMark);
        }
    }
}
