package com.example.aaa.pulltorlianxidemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.handmark.pulltorefresh.library.PullToRefreshBase;

/**
 * Created by aaa on 15-4-17.
 */
public class PullToRereshRsycleView  extends PullToRefreshBase<RecyclerView> {
    public PullToRereshRsycleView(Context context) {
        super(context);
    }

    public PullToRereshRsycleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullToRereshRsycleView(Context context, Mode mode) {
        super(context, mode);
    }

    public PullToRereshRsycleView(Context context, Mode mode, AnimationStyle animStyle) {
        super(context, mode, animStyle);
    }

    @Override
    public Orientation getPullToRefreshScrollDirection() {
        return Orientation.VERTICAL;
    }

    @Override
    protected RecyclerView createRefreshableView(Context context, AttributeSet attrs) {
          RecyclerView recyclerView=new RecyclerView(context,attrs);
          recyclerView.setId(R.id.resycle);
        return recyclerView;
    }

    @Override
    protected boolean isReadyForPullEnd() {
       RecyclerView recyclerView=getRefreshableView();
        View view = recyclerView.getChildAt(getChildCount() - 1);
        int position = recyclerView.getChildPosition(view);
        return position==getChildCount()-1 && getBottom()==recyclerView.getHeight();
    }

    @Override
    protected boolean isReadyForPullStart() {
        RecyclerView recyclerView=getRefreshableView();
        View view = recyclerView.getChildAt(0);
        int position = recyclerView.getChildPosition(view);
        return position==0 && getTop()==0;
    }
}
