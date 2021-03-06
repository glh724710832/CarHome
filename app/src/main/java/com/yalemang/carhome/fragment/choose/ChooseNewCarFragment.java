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
        chooseCarBeanList.add(new ChooseCarBean(R.mipmap.sales_list_choose_new_car, "?????????"));
        chooseCarBeanList.add(new ChooseCarBean(R.mipmap.new_car_choose_new_car, "????????????"));
        chooseCarBeanList.add(new ChooseCarBean(R.mipmap.attention_choose_new_car, "?????????"));
        chooseCarBeanList.add(new ChooseCarBean(R.mipmap.discount_choose_new_car, "????????????"));
        chooseCarBeanList.add(new ChooseCarBean(R.mipmap.nearby_choose_new_car, "???????????????"));
        chooseCarBeanList.add(new ChooseCarBean(R.mipmap.vr, "VR????????????"));
        chooseCarBeanList.add(new ChooseCarBean(R.mipmap.replacement_choose_new_car, "????????????"));
        chooseCarBeanList.add(new ChooseCarBean(R.mipmap.all_choose_new_car, "??????"));

        chooseCarBeanTextList = new ArrayList<>();
        chooseCarBeanTextList.add(new ChooseCarBean("suv"));
        chooseCarBeanTextList.add(new ChooseCarBean("??????"));
        chooseCarBeanTextList.add(new ChooseCarBean("?????????"));
        chooseCarBeanTextList.add(new ChooseCarBean("??????"));
        chooseCarBeanTextList.add(new ChooseCarBean("?????????"));
        chooseCarBeanTextList.add(new ChooseCarBean("5-8???"));
        chooseCarBeanTextList.add(new ChooseCarBean("8-15???"));
        chooseCarBeanTextList.add(new ChooseCarBean("15-20???"));
        chooseCarBeanTextList.add(new ChooseCarBean("20-50???"));
        chooseCarBeanTextList.add(new ChooseCarBean("????????????"));

        chooseCarBeanTwoRoundList = new ArrayList<>();
        chooseCarBeanTwoRoundList.add(new ChooseCarBean(R.mipmap.bmw, "??????3???", "??????????????????"));
        chooseCarBeanTwoRoundList.add(new ChooseCarBean(R.mipmap.highlander, "?????????", "??????????????????"));


        //????????????
        chooseCarNavigationAdvertisingList = new ArrayList<>();
        chooseCarNavigationAdvertisingList.add(new ChooseCarBean(R.mipmap.one_car, "????????????"));
        chooseCarNavigationAdvertisingList.add(new ChooseCarBean(R.mipmap.two_car, "??????H9"));
        chooseCarNavigationAdvertisingList.add(new ChooseCarBean(R.mipmap.three_car, "????????????"));
        chooseCarNavigationAdvertisingList.add(new ChooseCarBean(R.mipmap.four_car, "??????RX5"));
        chooseCarNavigationAdvertisingList.add(new ChooseCarBean(R.mipmap.two_car, "??????H9"));
        chooseCarNavigationAdvertisingList.add(new ChooseCarBean(R.mipmap.five_car, "??????Pro"));

        firstLetterList = new ArrayList<>();
        firstLetterList.add("???");
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
                //??????????????????/?????????????????????????????????
                Log.d("onFailure", e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if (response.isSuccessful()) {
                    Log.d(TAG, "isSuccessful");
                    //????????????????????????Json????????????????????????????????????json
                    String json = response.body().string();
                    Gson gson = new Gson();
                    carBrandBean = gson.fromJson(json, CarBrandBean.class);
                    Message message = new Message();
                    message.obj = carBrandBean;
                    brandHandler.sendMessage(message);
                    Log.d(TAG, "isSuccessful");
                } else {
                    //???????????????404 505?????????

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

