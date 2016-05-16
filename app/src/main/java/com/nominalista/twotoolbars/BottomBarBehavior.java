package com.nominalista.twotoolbars;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Nominalista on 15/05/16.
 */
public class BottomBarBehavior extends CoordinatorLayout.Behavior<BottomBarLayout> {

    private Context mContext;
    private int mBottomBarHeight;
    private int mToolbarHeight;
    private int mToolbarPinHeight;

    public BottomBarBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mBottomBarHeight = Math.round(context.getResources().getDimension(R.dimen.bottom_bar_height));
        mToolbarHeight = Math.round(context.getResources().getDimension(R.dimen.toolbar_height));
        mToolbarPinHeight = Math.round(context.getResources().getDimension(R.dimen.toolbar_pin_height));
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, BottomBarLayout child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, BottomBarLayout child, View dependency) {
        int offset = -dependency.getTop();
        if (offset >= mToolbarHeight - mToolbarPinHeight) {
            offset -= mToolbarHeight - mToolbarPinHeight;
            child.setTranslationY(offset);
            return true;
        }
        return false;
    }
}

