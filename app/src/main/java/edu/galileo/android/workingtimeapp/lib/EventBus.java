package edu.galileo.android.workingtimeapp.lib;

/**
 * Created by Hiro on 17/07/2016.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
