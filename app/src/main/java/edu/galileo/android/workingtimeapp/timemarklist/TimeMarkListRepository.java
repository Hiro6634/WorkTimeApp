package edu.galileo.android.workingtimeapp.timemarklist;

import java.util.Date;

/**
 * Created by Hiro on 18/07/2016.
 */
public interface TimeMarkListRepository {
    void signOff();
    String getCurrentUserEmail();
    void removeTimeMark( Date date );
    void subscribetoTimeMarkEvents();
    void unsubscribetoTimeMarkEvents();
    void destroyListener();
}
