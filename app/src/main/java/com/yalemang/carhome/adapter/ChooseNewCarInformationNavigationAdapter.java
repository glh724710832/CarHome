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
public class ChooseNewCarInformationNavigationAdapter extends RecyclerView.Adapter<ChooseNewCarInformationNavigationAdapter.ChooseNewCarInformationNavigationViewHolder> {

    private Context context;
    private List<CarBrandBean> carBrandBeanList;
    private List<ChooseCarBean> chooseCarBeanList;

    public ChooseNewCarInformationNavigationAdapter(Context context, List<CarBrandBean> carBrandBeanList, List<ChooseCarBean> chooseCarBeanList) {
        this.context = context;
        this.carBrandBeanList = carBrandBeanList;
        this.chooseCarBeanList = chooseCarBeanList;

    }

    @NonNull

    @Override
    public ChooseNewCarInformationNavigationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_choose_car_information_navigation, parent, false);
        ChooseNewCarInformationNavigationViewHolder chooseNewCarInformationNavigationViewHolder = new ChooseNewCarInformationNavigationViewHolder(view);
        return chooseNewCarInformationNavigationViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChooseNewCarInformationNavigationAdapter.ChooseNewCarInformationNavigationViewHolder holder, int position) {
        Glide.with(context).load(chooseCarBeanList.get(position).getIcon()).into(holder.ivChooseCarNavigation);
        holder.tvChooseCarNavigation.setText(chooseCarBeanList.get(position).getBrand());

    }

    @Override
    public int getItemCount() {
        return chooseCarBeanList.size();
    }


    public class ChooseNewCarInformationNavigationViewHolder extends RecyclerView.ViewHolder {
        ImageView ivChooseCarNavigation;
        TextView tvChooseCarNavigation;

        public ChooseNewCarInformationNavigationViewHolder(@NonNull View itemView) {
            super(itemView);
            ivChooseCarNavigation = itemView.findViewById(R.id.iv_choose_car_navigation);
            tvChooseCarNavigation = itemView.findViewById(R.id.tv_choose_car_navigation);
        }
    }
}
