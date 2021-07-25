package com.yalemang.carhome.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author Administrator
 */
public class ChooseCarFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<String> tabTitleList;
    private List<Fragment> fragmentList;

    public ChooseCarFragmentPagerAdapter(FragmentManager fragmentManager, List<String> tabTitleList, List<Fragment> fragmentList) {
        super(fragmentManager);
        this.tabTitleList = tabTitleList;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitleList.get(position);
    }
}
