package com.yalemang.carhome.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yalemang.carhome.R;
import com.yalemang.carhome.bean.CarBrandBean;
import com.yalemang.carhome.bean.ChooseCarBean;

import java.util.List;

public class ChooseNewCarBrandListAdapter extends RecyclerView.Adapter<ChooseNewCarBrandListAdapter.ChooseNewCarBrandListViewHolder> {

    private Context context;
    private List<CarBrandBean> carBrandBeanList;


    private int NAVIGATION = 0;
    private int BRAND = 1;

    public ChooseNewCarBrandListAdapter(Context context, List<CarBrandBean> carBrandBeanList) {
        this.context = context;
        this.carBrandBeanList = carBrandBeanList;

    }

    @NonNull

    @Override
    public ChooseNewCarBrandListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_choose_car_brand_list, parent, false);
        ChooseNewCarBrandListViewHolder chooseNewCarBrandListViewHolder = new ChooseNewCarBrandListViewHolder(view);
        return chooseNewCarBrandListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChooseNewCarBrandListAdapter.ChooseNewCarBrandListViewHolder holder, int position) {

        Glide.with(context).load(carBrandBeanList.get(0).getResult().getBranditems().get(position + 5).getLogo()).into(holder.ivChooseNewCarBrandList);
        holder.tvChooseNewCarListBrand.setText(carBrandBeanList.get(0).getResult().getBranditems().get(position + 5).getName());

    }

    @Override
    public int getItemCount() {
        return 16;
    }


    public class ChooseNewCarBrandListViewHolder extends RecyclerView.ViewHolder {
        ImageView ivChooseNewCarBrandList;
        TextView tvChooseNewCarListBrand;
        TextView tvChooseNewCarBrandListDiscount;

        public ChooseNewCarBrandListViewHolder(@NonNull View itemView) {
            super(itemView);
            ivChooseNewCarBrandList = itemView.findViewById(R.id.iv_choose_new_car_brand_list);
            tvChooseNewCarListBrand = itemView.findViewById(R.id.tv_choose_new_car_list_brand);
            tvChooseNewCarBrandListDiscount = itemView.findViewById(R.id.tv_choose_new_car_brand_list_discount);
        }
    }
}
