package com.yalemang.carhome.fragment.choose;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.yalemang.carhome.R;
import com.yalemang.carhome.adapter.ChooseNewCarAdapter;
import com.yalemang.carhome.adapter.ChooseNewCarFirstLetterAdapter;
import com.yalemang.carhome.bean.CarBrandBean;
import com.yalemang.carhome.bean.ChooseCarBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ChooseNewCarFragment extends Fragment {

    private static final String TAG = "ChooseNewCarFragment";
    private String AUTOHOME_URL = "http://www.autohome.com.cn/ashx/AjaxIndexCarFind.ashx?type=1";
    private static RecyclerView chooseNewCarRecyclerView;
    private static RecyclerView chooseNewCarFirstLetterRecyclerView;
    private static CarBrandBean carBrandBean;
    private static List<CarBrandBean> carBrandBeanList = new ArrayList<>();
    private static List<ChooseCarBean> chooseCarBeanList, chooseCarBeanTextList, chooseCarNavigationAdvertisingList, chooseCarBeanTwoRoundList;
    private static List<String> firstLetterList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.choose_new_car_fragment, container, false);
        chooseNewCarRecyclerView = view.findViewById(R.id.recycler_view_choose_new_car_fragment);
        chooseNewCarFirstLetterRecyclerView = view.findViewById(R.id.recycler_view_choose_new_car_firstletter);
        initView();
        initData();
        return view;
    }

    private void initData() {
        Log.d(TAG, "initData" + "     e.getMessage()");

        chooseCarBeanList = new ArrayList<>();
        chooseCarBeanList.add(new ChooseCarBean(R.mipmap.sales_list_choose_new_car, "销量榜"));
        chooseCarBeanList.add(new ChooseCarBean(R.mipmap.new_car_choose_new_car, "新车上市"));
        chooseCarBeanList.add(new ChooseCarBean(R.mipmap.attention_choose_new_car, "关注榜"));
        chooseCarBeanList.add(new ChooseCarBean(R.mipmap.discount_choose_new_car, "降价优惠"));
        chooseCarBeanList.add(new ChooseCarBean(R.mipmap.nearby_choose_new_car, "附近经销商"));
        chooseCarBeanList.add(new ChooseCarBean(R.mipmap.vr, "VR体验中心"));
        chooseCarBeanList.add(new ChooseCarBean(R.mipmap.replacement_choose_new_car, "购车置换"));
        chooseCarBeanList.add(new ChooseCarBean(R.mipmap.all_choose_new_car, "全部"));

        chooseCarBeanTextList = new ArrayList<>();
        chooseCarBeanTextList.add(new ChooseCarBean("suv"));
        chooseCarBeanTextList.add(new ChooseCarBean("轿车"));
        chooseCarBeanTextList.add(new ChooseCarBean("自动挡"));
        chooseCarBeanTextList.add(new ChooseCarBean("合资"));
        chooseCarBeanTextList.add(new ChooseCarBean("七座车"));
        chooseCarBeanTextList.add(new ChooseCarBean("5-8万"));
        chooseCarBeanTextList.add(new ChooseCarBean("8-15万"));
        chooseCarBeanTextList.add(new ChooseCarBean("15-20万"));
        chooseCarBeanTextList.add(new ChooseCarBean("20-50万"));
        chooseCarBeanTextList.add(new ChooseCarBean("更多条件"));

        chooseCarBeanTwoRoundList = new ArrayList<>();
        chooseCarBeanTwoRoundList.add(new ChooseCarBean(R.mipmap.bmw, "宝马3系", "免费查成交价"));
        chooseCarBeanTwoRoundList.add(new ChooseCarBean(R.mipmap.highlander, "汉兰达", "免费查成交价"));


        //广告品牌
        chooseCarNavigationAdvertisingList = new ArrayList<>();
        chooseCarNavigationAdvertisingList.add(new ChooseCarBean(R.mipmap.one_car, "宝马五系"));
        chooseCarNavigationAdvertisingList.add(new ChooseCarBean(R.mipmap.two_car, "红旗H9"));
        chooseCarNavigationAdvertisingList.add(new ChooseCarBean(R.mipmap.three_car, "广汽埃安"));
        chooseCarNavigationAdvertisingList.add(new ChooseCarBean(R.mipmap.four_car, "荣威RX5"));
        chooseCarNavigationAdvertisingList.add(new ChooseCarBean(R.mipmap.two_car, "红旗H9"));
        chooseCarNavigationAdvertisingList.add(new ChooseCarBean(R.mipmap.five_car, "炫界Pro"));

        firstLetterList = new ArrayList<>();
        firstLetterList.add("选");
        firstLetterList.add("A");
        firstLetterList.add("B");
        firstLetterList.add("C");
        firstLetterList.add("D");
        firstLetterList.add("E");
        firstLetterList.add("F");
        firstLetterList.add("G");
        firstLetterList.add("H");
        firstLetterList.add("I");
        firstLetterList.add("J");
        firstLetterList.add("K");
        firstLetterList.add("L");
        firstLetterList.add("M");
        firstLetterList.add("N");
        firstLetterList.add("O");
        firstLetterList.add("P");
        firstLetterList.add("Q");
        firstLetterList.add("R");
        firstLetterList.add("S");
        firstLetterList.add("T");
        firstLetterList.add("U");
        firstLetterList.add("V");
        firstLetterList.add("w");
        firstLetterList.add("X");
        firstLetterList.add("Y");
        firstLetterList.add("Z");

        requestBrand(AUTOHOME_URL);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), firstLetterList.size());
        gridLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        chooseNewCarFirstLetterRecyclerView.setLayoutManager(gridLayoutManager);
        chooseNewCarFirstLetterRecyclerView.setAdapter(new ChooseNewCarFirstLetterAdapter(getActivity(), firstLetterList));


    }

    private void initView() {
        Log.d(TAG, "initView" + "     e.getMessage()");
    }

    private void requestBrand(String requestUrl) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(requestUrl).build();
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
                    Log.d(TAG, "isSuccessful");
                    //获取服务器返回的Json，是否登陆成功需继续解析json
                    String json = response.body().string();
                    Gson gson = new Gson();
                    carBrandBean = gson.fromJson(json, CarBrandBean.class);
                    Message message = new Message();
                    message.obj = carBrandBean;
                    brandHandler.sendMessage(message);
                    Log.d(TAG, "isSuccessful");
                } else {
                    //服务器返回404 505类错误

                }
            }
        });
    }

    static Handler brandHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            carBrandBean = (CarBrandBean) msg.obj;
            carBrandBeanList.add(carBrandBean);
            Log.d(TAG, "brandHandler");
            Log.d(TAG, carBrandBean.getMessage());
            Log.d(TAG, carBrandBean.getResult().getBranditems().get(0).getName());
            Log.d(TAG, carBrandBeanList.get(0).getResult().getBranditems().get(0).getName());

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(chooseNewCarRecyclerView.getContext());
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            chooseNewCarRecyclerView.setLayoutManager(linearLayoutManager);
            chooseNewCarRecyclerView.setAdapter(new ChooseNewCarAdapter(chooseNewCarRecyclerView.getContext(), carBrandBeanList, chooseCarBeanList, chooseCarBeanTextList, chooseCarNavigationAdvertisingList, chooseCarBeanTwoRoundList, firstLetterList));

        }
    };


}

