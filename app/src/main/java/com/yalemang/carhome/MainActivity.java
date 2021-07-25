package com.yalemang.carhome;


import androidx.fragment.app.Fragment;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.yalemang.carhome.fragment.ChooseFragment;
import com.yalemang.carhome.fragment.ForumFragment;
import com.yalemang.carhome.fragment.HomeFragment;
import com.yalemang.carhome.fragment.MineFragment;
import com.yalemang.carhome.fragment.SecondHandCarFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * @author Administrator
 */
public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {


    BottomNavigationBar mainBottomNavigationBar;

    private Fragment myFragment;
    private List<String> tabTitleList;
    private List<Fragment> fragmentList = new ArrayList<>();


    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(MainActivity.this);
        mainBottomNavigationBar = findViewById(R.id.main_bottom_navigation_bar);

    }

    @Override
    protected void initData() {
        tabTitleList = new ArrayList<>();
        tabTitleList.add("首页");
        tabTitleList.add("论坛");
        tabTitleList.add("选车");
        tabTitleList.add("二手车");
        tabTitleList.add("我的");

        mainBottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.home, tabTitleList.get(0)))
                .addItem(new BottomNavigationItem(R.mipmap.forum, tabTitleList.get(1)))
                .addItem(new BottomNavigationItem(R.mipmap.search, tabTitleList.get(2)))
                .addItem(new BottomNavigationItem(R.mipmap.second, tabTitleList.get(3)))
                .addItem(new BottomNavigationItem(R.mipmap.mine, tabTitleList.get(4)))
                .setActiveColor("#1E90FF")
                .setInActiveColor("#708090")
                .setBarBackgroundColor("#FFFFFF")
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setTabSelectedListener(MainActivity.this)
                .initialise();//初始化，一定要放在末尾

        //设置默认首页
        replaceFragment(0);
    }

    private void replaceFragment(int position) {

        if (myFragment != null) {
            //当不为空就说明已经选择了fragment,消除当前碎片页面（不消除的话会让下一选中页面和当前界面重复）
            getSupportFragmentManager().beginTransaction().hide(myFragment).commit();
        }
        //复用fragment,避免下方选择重复new创建碎片对象
        myFragment = getSupportFragmentManager().findFragmentByTag(String.valueOf(position));
        if (myFragment == null) {
            switch (position) {
                case 0:
                    myFragment = new HomeFragment();

                    break;
                case 1:
                    myFragment = new ForumFragment();

                    break;
                case 2:
                    myFragment = new ChooseFragment();
                    break;
                case 3:
                    myFragment = new SecondHandCarFragment();
                    break;
                case 4:
                    myFragment = new MineFragment();
                    break;
                default:
            }


            //碎片为空，将选中的碎片加载显现
            getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, myFragment, String.valueOf(position)).commit();
        } else {
            //碎片不为空，直接显示当前界面
            getSupportFragmentManager().beginTransaction().show(myFragment).commit();
        }

    }

    @Override
    public void onTabSelected(int position) {
        replaceFragment(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}