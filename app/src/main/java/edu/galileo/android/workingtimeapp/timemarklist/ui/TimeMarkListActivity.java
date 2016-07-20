package edu.galileo.android.workingtimeapp.timemarklist.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.galileo.android.workingtimeapp.R;
import edu.galileo.android.workingtimeapp.entities.TimeMark;
import edu.galileo.android.workingtimeapp.timemarklist.TimeMarkListPresenter;
import edu.galileo.android.workingtimeapp.timemarklist.ui.adapters.OnItemClickListener;
import edu.galileo.android.workingtimeapp.timemarklist.ui.adapters.TimeMarkListAdapter;

public class TimeMarkListActivity extends AppCompatActivity implements TimeMarkListView, OnItemClickListener {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recyclerViewTimeMarks)
    RecyclerView recyclerViewTimeMarks;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    private TimeMarkListPresenter presenter;
    private TimeMarkListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timemarklist);
        ButterKnife.bind(this);

        setupAdapter();
        setupRecyclerView();
        presenter.onCreate();
        setupToolbar();
    }

    private void setupRecyclerView() {
        recyclerViewTimeMarks.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTimeMarks.setAdapter(adapter);
    }

    private void setupAdapter() {
        adapter = new TimeMarkListAdapter(new ArrayList<TimeMark>(), this);
    }

    private void setupToolbar() {
        toolbar.setTitle(presenter.getCurrentUserEmail());
        setSupportActionBar(toolbar);
    }


    @Override
    protected void onResume() {
        presenter.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        presenter.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @OnClick(R.id.fab)
    public void addTimeMark(){

    }

    @Override
    public void onTimeMarkAdded(TimeMark timeMark) {

    }

    @Override
    public void onTimeMarkChanged(TimeMark timeMark) {

    }

    @Override
    public void onTimeMarkRemoved(TimeMark timeMark) {

    }

    @Override
    public void onItemClick(TimeMark timeMark) {

    }

    @Override
    public void onItemLongClick(TimeMark timeMark) {

    }
}
