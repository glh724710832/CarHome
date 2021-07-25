package com.yalemang.carhome.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yalemang.carhome.R;
import com.yalemang.carhome.bean.CarBrandBean;
import com.yalemang.carhome.bean.ChooseCarBean;

import java.util.List;

/**
 * @author Administrator
 */
public class ChooseNewCarInformationBrandAdapter extends RecyclerView.Adapter<ChooseNewCarInformationBrandAdapter.ChooseNewCarInformationBrandViewHolder> {

    private Context context;
    private List<CarBrandBean> carBrandBeanList;

    public ChooseNewCarInformationBrandAdapter(Context context, List<CarBrandBean> carBrandBeanList) {
        this.context = context;
        this.carBrandBeanList = carBrandBeanList;

    }


    @Override
    public ChooseNewCarInformationBrandViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_choose_car_information_brand, parent, false);
        ChooseNewCarInformationBrandViewHolder chooseNewCarInformationBrandViewHolder = new ChooseNewCarInformationBrandViewHolder(view);
        return chooseNewCarInformationBrandViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChooseNewCarInformationBrandAdapter.ChooseNewCarInformationBrandViewHolder holder, int position) {
        Glide.with(context).load(carBrandBeanList.get(0).getResult().getBranditems().get(position + 25).getLogo()).into(holder.ivChooseCarBrand);
        holder.tvChooseCarBrand.setText(carBrandBeanList.get(0).getResult().getBranditems().get(position + 25).getName());


    }

    @Override
    public int getItemCount() {
        return 5;
    }


    public class ChooseNewCarInformationBrandViewHolder extends RecyclerView.ViewHolder {
        ImageView ivChooseCarBrand;
        TextView tvChooseCarBrand;

        public ChooseNewCarInformationBrandViewHolder(@NonNull View itemView) {
            super(itemView);
            ivChooseCarBrand = itemView.findViewById(R.id.iv_choose_car_information_brand);
            tvChooseCarBrand = itemView.findViewById(R.id.tv_choose_car_information_brand);
        }
    }
}
