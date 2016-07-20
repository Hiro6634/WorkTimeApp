package edu.galileo.android.workingtimeapp.timemarklist.ui;

import edu.galileo.android.workingtimeapp.entities.TimeMark;

/**
 * Created by Hiro on 18/07/2016.
 */
public interface TimeMarkListView    {
    void onTimeMarkAdded(TimeMark timeMark);
    void onTimeMarkChanged(TimeMark timeMark);
    void onTimeMarkRemoved(TimeMark timeMark);
}
