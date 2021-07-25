package com.yalemang.carhome.fragment;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.yalemang.carhome.R;
import com.yalemang.carhome.adapter.ChooseCarFragmentPagerAdapter;
import com.yalemang.carhome.bean.CarBrandBean;
import com.yalemang.carhome.fragment.choose.ChooseNewCarFragment;
import com.yalemang.carhome.fragment.choose.ChooseNewPowerFragment;
import com.yalemang.carhome.fragment.choose.ChooseSecondHandCarFragment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * 展示首页内容
 */
public class ChooseFragment extends Fragment {


    private Unbinder unbinder;
    private String AUTOHOME_URL = "http://www.autohome.com.cn/ashx/AjaxIndexCarFind.ashx?type=1";

    private List<String> tabTitleList;
    private List<Fragment> fragmentList;

    private TabLayout chooseCarTabLayout;
    private ViewPager chooseCarViewpager;
    private CarBrandBean carBrandBean;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //此处采用封装的方法
        View view = getView(R.layout.fragment_choose_car);
        unbinder = ButterKnife.bind(this, view);

        chooseCarTabLayout = view.findViewById(R.id.tl_choose_car);
        chooseCarViewpager = view.findViewById(R.id.vp_choose_car);

        initView();
        initData();
        return view;
    }

    private void initData() {

        setTablayout();

    }


    private void initView() {

//        chooseCarTabLayout = getView(R.layout.choose_new_car_fragment).findViewById(R.id.tl_choose_car);
//        chooseCarViewpager = getView(R.layout.choose_new_car_fragment).findViewById(R.id.vp_choose_car);

    }


    private void setTablayout() {
        fragmentList = new ArrayList<>();

        //绑定碎片
        fragmentList.add(new ChooseNewPowerFragment());
        fragmentList.add(new ChooseNewCarFragment());
        fragmentList.add(new ChooseSecondHandCarFragment());

        tabTitleList = new ArrayList<>();
        //添加标题
        tabTitleList.add("新能源");
        tabTitleList.add("新车");
        tabTitleList.add("二手车");

        for (int i = 0; i < tabTitleList.size(); i++) {
            chooseCarTabLayout.addTab(chooseCarTabLayout.newTab().setText(tabTitleList.get(i)));
        }

        //tablayout与viewpager绑定
        chooseCarTabLayout.setupWithViewPager(chooseCarViewpager);

        chooseCarViewpager.setAdapter(new ChooseCarFragmentPagerAdapter(getFragmentManager(), tabTitleList, fragmentList));
    }




    /**
     * 避免内存泄漏
     */

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }


    /**
     * 网络请求获取文章信息
     */
    private void requestArticle() {
        //发起网络请求 okhttp依赖已导入
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(AUTOHOME_URL).build();
        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //因为网络问题/请求超时等原因请求失败
                Log.d("onFailure", e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    //获取服务器返回的Json，是否登陆成功需继续解析json
                    String json = response.body().string();
                    Gson gson = new Gson();
                    carBrandBean = gson.fromJson(json, CarBrandBean.class);
                    Message message = new Message();
                    message.obj = carBrandBean;
                    //userHandler.sendMessage(message);
                } else {
                    //服务器返回404 505类错误

                }


            }
        });
    }


    public View getView(int layoutId) {
        View view = LayoutInflater.from(getContext()).inflate(layoutId, null);
        return view;
    }

}
