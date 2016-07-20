package edu.galileo.android.workingtimeapp.timemarklist.ui.adapters;

import edu.galileo.android.workingtimeapp.entities.TimeMark;

/**
 * Created by Hiro on 20/07/2016.
 */
public interface OnItemClickListener {
    void onItemClick(TimeMark timeMark);
    void onItemLongClick(TimeMark timeMark);
}
