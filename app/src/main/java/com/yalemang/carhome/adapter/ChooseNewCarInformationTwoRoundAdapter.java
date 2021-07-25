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
public class ChooseNewCarInformationTwoRoundAdapter extends RecyclerView.Adapter<ChooseNewCarInformationTwoRoundAdapter.ChooseNewCarInformationTwoRoundViewHolder> {

    private Context context;
    private List<ChooseCarBean> chooseCarBeanTwoRoundList;


    public ChooseNewCarInformationTwoRoundAdapter(Context context, List<ChooseCarBean> chooseCarBeanTwoRoundList) {
        this.context = context;
        this.chooseCarBeanTwoRoundList = chooseCarBeanTwoRoundList;

    }

    @NonNull

    @Override
    public ChooseNewCarInformationTwoRoundViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_choose_car_information_two_round, parent, false);
        ChooseNewCarInformationTwoRoundViewHolder chooseNewCarInformationTwoRoundViewHolder = new ChooseNewCarInformationTwoRoundViewHolder(view);
        return chooseNewCarInformationTwoRoundViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChooseNewCarInformationTwoRoundAdapter.ChooseNewCarInformationTwoRoundViewHolder holder, int position) {
        holder.tvChooseCarInformationTwoRoundModle.setText(chooseCarBeanTwoRoundList.get(position).getModel());
        holder.tvChooseCarInformationTwoRoundTitle.setText(chooseCarBeanTwoRoundList.get(position).getTitle());
        Glide.with(context).load(chooseCarBeanTwoRoundList.get(position).getIcon()).into(holder.ivChooseCarInformationTwoRound);
    }

    @Override
    public int getItemCount() {
        return chooseCarBeanTwoRoundList.size();
    }


    public class ChooseNewCarInformationTwoRoundViewHolder extends RecyclerView.ViewHolder {

        TextView tvChooseCarInformationTwoRoundModle;
        TextView tvChooseCarInformationTwoRoundTitle;
        ImageView ivChooseCarInformationTwoRound;

        public ChooseNewCarInformationTwoRoundViewHolder(@NonNull View itemView) {
            super(itemView);
            tvChooseCarInformationTwoRoundModle = itemView.findViewById(R.id.tv_choose_car_information_two_round_modle);
            tvChooseCarInformationTwoRoundTitle = itemView.findViewById(R.id.tv_choose_car_information_two_round_title);
            ivChooseCarInformationTwoRound = itemView.findViewById(R.id.iv_choose_car_information_two_round);
        }
    }
}
