package edu.galileo.android.workingtimeapp.timemarklist;

import java.util.Date;

/**
 * Created by Hiro on 18/07/2016.
*/
public interface TimeMarkListInteractor {
    void subscribe();
    void unsubscribe();
    void destroyListener();
    void removeTimeMark(Date timeMarkdate);
}
