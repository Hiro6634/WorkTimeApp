package edu.galileo.android.workingtimeapp.timemarklist;

import java.util.Date;

import edu.galileo.android.workingtimeapp.timemarklist.events.TimeMarkEvent;

/**
 * Created by Hiro on 18/07/2016.
 */
public interface TimeMarkListPresenter {
    void onCreate();
    void onDestroy();
    void onPause();
    void onResume();

    void signOff();
    String getCurrentUserEmail();
    void removeTimeMark(Date date);
    void onEventMainThread(TimeMarkEvent event);
}
