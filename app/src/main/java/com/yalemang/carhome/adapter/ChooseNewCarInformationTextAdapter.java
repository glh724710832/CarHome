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
public class ChooseNewCarInformationTextAdapter extends RecyclerView.Adapter<ChooseNewCarInformationTextAdapter.ChooseNewCarInformationTextViewHolder> {

    private Context context;
    private List<ChooseCarBean> chooseCarBeanTextList;


    public ChooseNewCarInformationTextAdapter(Context context, List<ChooseCarBean> chooseCarBeanTextList) {
        this.context = context;
        this.chooseCarBeanTextList = chooseCarBeanTextList;

    }

    @NonNull

    @Override
    public ChooseNewCarInformationTextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_choose_car_information_text, parent, false);
        ChooseNewCarInformationTextViewHolder chooseNewCarInformationTextViewHolder = new ChooseNewCarInformationTextViewHolder(view);
        return chooseNewCarInformationTextViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChooseNewCarInformationTextAdapter.ChooseNewCarInformationTextViewHolder holder, int position) {

        holder.tvChooseNewCarInformationText.setText(chooseCarBeanTextList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return chooseCarBeanTextList.size();
    }


    public class ChooseNewCarInformationTextViewHolder extends RecyclerView.ViewHolder {

        TextView tvChooseNewCarInformationText;

        public ChooseNewCarInformationTextViewHolder(@NonNull View itemView) {
            super(itemView);

            tvChooseNewCarInformationText = itemView.findViewById(R.id.tv_choose_new_car_information_text);
        }
    }
}
