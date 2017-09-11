package com.hmartinez.petagram.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

import com.hmartinez.petagram.fragments.FotosFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PageAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> fragmentos;
    private Context context;

    private final FragmentManager mFragmentManager;
    private FragmentTransaction mCurTransaction = null;
    private Fragment mCurrentPrimaryItem = null;

    public PageAdapter(FragmentManager fm, ArrayList<Fragment> fragmentos, Context context) {
        super(fm);
        this.mFragmentManager = fm;
        this.fragmentos = fragmentos;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0)
            return fragmentos.get(position);
        else{
            fragmentos.set(position, new FotosFragment());
            return fragmentos.get(position);
        }

    }

    @Override
    public int getCount() {
        return fragmentos.size();
    }

    @Override
    public int getItemPosition(Object object){
        return POSITION_NONE;
    }
}