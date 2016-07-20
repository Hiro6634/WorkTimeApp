package edu.galileo.android.workingtimeapp.timemarklist.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.galileo.android.workingtimeapp.R;
import edu.galileo.android.workingtimeapp.entities.TimeMark;

/**
 * Created by Hiro on 20/07/2016.
 */
public class TimeMarkListAdapter extends RecyclerView.Adapter<TimeMarkListAdapter.ViewHolder> {
    private List<TimeMark> timeMarkList;
    private OnItemClickListener onItemClickListener;

    public TimeMarkListAdapter(List<TimeMark> timeMarkList, OnItemClickListener onItemClickListener) {
        this.timeMarkList = timeMarkList;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_timemark, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TimeMark timeMark = timeMarkList.get(position);
        holder.setClickListener( timeMark, onItemClickListener);

        holder.txtDate.setText(timeMark.getDate().toString());
        holder.txtStartTime.setText(timeMark.getInTime());
        holder.txtEndTime.setText(timeMark.getOutTime());
        holder.txtObservation.setText(timeMark.getObservation());

    }

    @Override
    public int getItemCount() {
        return timeMarkList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.txtDate)
        TextView txtDate;
        @Bind(R.id.txtStartTime)
        TextView txtStartTime;
        @Bind(R.id.txtEndTime)
        TextView txtEndTime;
        @Bind(R.id.txtObservation)
        TextView txtObservation;

        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.view = itemView;
        }

        private void setClickListener(final TimeMark timeMark, final OnItemClickListener listener){
            view.setOnClickListener( new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    listener.onItemClick(timeMark);
                }
            });

            view.setOnLongClickListener(new View.OnLongClickListener(){

                @Override
                public boolean onLongClick(View view) {
                    listener.onItemLongClick(timeMark);
                    return false;
                }
            });
        }
    }
}
