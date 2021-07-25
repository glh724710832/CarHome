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
public class ChooseNewCarInformationAdvertiseAdapter extends RecyclerView.Adapter<ChooseNewCarInformationAdvertiseAdapter.ChooseNewCarInformationAdvertiseViewHolder> {

    private Context context;

    private List<ChooseCarBean> chooseCarNavigationAdvertisingList;


    public ChooseNewCarInformationAdvertiseAdapter(Context context, List<ChooseCarBean> chooseCarNavigationAdvertisingList) {
        this.context = context;
        this.chooseCarNavigationAdvertisingList = chooseCarNavigationAdvertisingList;

    }

    @NonNull

    @Override
    public ChooseNewCarInformationAdvertiseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_choose_car_information_advertise, parent, false);
        ChooseNewCarInformationAdvertiseViewHolder chooseNewCarInformationAdvertiseViewHolder = new ChooseNewCarInformationAdvertiseViewHolder(view);
        return chooseNewCarInformationAdvertiseViewHolder;
    }

    @Override
    public void onBindViewHolder(ChooseNewCarInformationAdvertiseAdapter.ChooseNewCarInformationAdvertiseViewHolder holder, int position) {
        Glide.with(context).load(chooseCarNavigationAdvertisingList.get(position).getIcon()).into(holder.ivChooseCarInformationAdvertise);
        holder.tvChooseCarInformationAdvertise.setText(chooseCarNavigationAdvertisingList.get(position).getBrand());

    }

    @Override
    public int getItemCount() {
        return chooseCarNavigationAdvertisingList.size();
    }


    public class ChooseNewCarInformationAdvertiseViewHolder extends RecyclerView.ViewHolder {
        ImageView ivChooseCarInformationAdvertise;
        TextView tvChooseCarInformationAdvertise;

        public ChooseNewCarInformationAdvertiseViewHolder(@NonNull View itemView) {
            super(itemView);
            ivChooseCarInformationAdvertise = itemView.findViewById(R.id.iv_choose_car_information_advertise);
            tvChooseCarInformationAdvertise = itemView.findViewById(R.id.tv_choose_car_information_advertise);
        }
    }
}
