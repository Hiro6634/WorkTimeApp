package edu.galileo.android.workingtimeapp.entities;

import java.security.Timestamp;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Hiro on 18/07/2016.
 */
public class TimeMark {
    private Date date;
    private String inTime;
    private String outTime;
    private String Observation;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getObservation() {
        return Observation;
    }

    public void setObservation(String observation) {
        Observation = observation;
    }
}
