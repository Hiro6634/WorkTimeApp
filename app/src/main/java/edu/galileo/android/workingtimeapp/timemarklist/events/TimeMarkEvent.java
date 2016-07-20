package edu.galileo.android.workingtimeapp.timemarklist.events;

import java.sql.Time;

import edu.galileo.android.workingtimeapp.entities.TimeMark;

/**
 * Created by Hiro on 18/07/2016.
 */
public class TimeMarkEvent {
    public final static int onTimeMarkAdded = 0;
    public final static int onTimeMarkChanged = 1;
    public final static int onTimeMarkRemoved = 2;

    private TimeMark timeMark;
    private int eventType;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public TimeMark getTimeMark() {
        return timeMark;
    }

    public void setTimeMark(TimeMark timeMark) {
        this.timeMark = timeMark;
    }
}
