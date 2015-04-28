package com.example.aaa.pulltorlianxidemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends ActionBarActivity {

    private RecyclerView recycler;
    private MyAdapter adapter;
    private PullToRereshRsycleView rereshRsycleView;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    List<String> list = new ArrayList<>();
                    for (int i = 0; i < 100; i++) {
                        list.add(String.format("第%03d条数据", i));
                    }
                    adapter.addAll(list);
                    rereshRsycleView.onRefreshComplete();
                    break;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //11111111
        recycler = ((RecyclerView) findViewById(R.id.resycle));
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recycler.setLayoutManager(manager);
        List<String> list=new ArrayList<>();
        for (int i = 0; i <30 ; i++) {
            list.add(String.format("第%3d条数据",i));

        }
        adapter = new MyAdapter(this, list);
        recycler.setAdapter(adapter);
        rereshRsycleView= (PullToRereshRsycleView) findViewById(R.id.recychr);
        rereshRsycleView.setMode(PullToRefreshBase.Mode.BOTH);
        rereshRsycleView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>() {
            @Override
            public void onRefresh(PullToRefreshBase<RecyclerView> refreshView) {
                adapter.clear();
                handler.sendEmptyMessageDelayed(0,2000);


            }
        });



    }



}
