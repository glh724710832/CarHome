package com.yalemang.carhome.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yalemang.carhome.R;
import com.yalemang.carhome.bean.CarBrandBean;
import com.yalemang.carhome.bean.ChooseCarBean;

import java.util.List;

public class ChooseNewCarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<CarBrandBean> carBrandBeanList;
    private List<ChooseCarBean> chooseCarBeanList, chooseCarBeanTextList, chooseCarNavigationAdvertisingList, chooseCarBeanTwoRoundList;
    ;
    private List<String> firstLetterList;

    private int INFORMATION = 0;
    private int LIST = 1;

    public ChooseNewCarAdapter(Context context, List<CarBrandBean> carBrandBeanList, List<ChooseCarBean> chooseCarBeanList, List<ChooseCarBean> chooseCarBeanTextList, List<ChooseCarBean> chooseCarNavigationAdvertisingList, List<ChooseCarBean> chooseCarBeanTwoRoundList, List<String> firstLetterList) {
        this.context = context;
        this.carBrandBeanList = carBrandBeanList;
        this.chooseCarBeanList = chooseCarBeanList;
        this.chooseCarBeanTextList = chooseCarBeanTextList;
        this.chooseCarNavigationAdvertisingList = chooseCarNavigationAdvertisingList;
        this.chooseCarBeanTwoRoundList = chooseCarBeanTwoRoundList;
        this.firstLetterList = firstLetterList;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return INFORMATION;
        }
        return LIST;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == INFORMATION) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_choose_new_car_information, parent, false);
            TypeChooseNewCarInformationViewHolder typeChooseNewCarInformationViewHolder = new TypeChooseNewCarInformationViewHolder(view);
            return typeChooseNewCarInformationViewHolder;
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_choose_new_car_brand_list, parent, false);
            TypeChooseNewCarBrandListViewHolder typeChooseNewCarBrandListViewHolder = new TypeChooseNewCarBrandListViewHolder(view);
            return typeChooseNewCarBrandListViewHolder;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TypeChooseNewCarInformationViewHolder) {
            TypeChooseNewCarInformationViewHolder typeChooseNewCarInformationViewHolder = (TypeChooseNewCarInformationViewHolder) holder;

            LinearLayoutManager chooseNewCarInformationLinearLayoutManager = new LinearLayoutManager(context);
            chooseNewCarInformationLinearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            typeChooseNewCarInformationViewHolder.chooseNewCarInformationRecyclerView.setLayoutManager(chooseNewCarInformationLinearLayoutManager);
            typeChooseNewCarInformationViewHolder.chooseNewCarInformationRecyclerView.setAdapter(new ChooseNewCarInformationAdapter(context, carBrandBeanList, chooseCarBeanList, chooseCarBeanTextList, chooseCarNavigationAdvertisingList, chooseCarBeanTwoRoundList, firstLetterList));
        } else if (holder instanceof TypeChooseNewCarBrandListViewHolder) {
            TypeChooseNewCarBrandListViewHolder typeChooseNewCarBrandListViewHolder = (TypeChooseNewCarBrandListViewHolder) holder;

            LinearLayoutManager chooseNewCarInformationLinearLayoutManager = new LinearLayoutManager(context);
            chooseNewCarInformationLinearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            typeChooseNewCarBrandListViewHolder.recyclerViewChooseNewCarBrandList.setLayoutManager(chooseNewCarInformationLinearLayoutManager);
            typeChooseNewCarBrandListViewHolder.recyclerViewChooseNewCarBrandList.setAdapter(new ChooseNewCarBrandListAdapter(context, carBrandBeanList));
            typeChooseNewCarBrandListViewHolder.tvChooseNewCarBrandListFirstLetter.setText(firstLetterList.get(position));
        }

    }


    @Override
    public int getItemCount() {
        return firstLetterList.size();
    }

    public class TypeChooseNewCarInformationViewHolder extends RecyclerView.ViewHolder {

        RecyclerView chooseNewCarInformationRecyclerView;

        public TypeChooseNewCarInformationViewHolder(@NonNull View itemView) {
            super(itemView);
            chooseNewCarInformationRecyclerView = itemView.findViewById(R.id.recycler_view_choose_new_car_information);
        }
    }

    public class TypeChooseNewCarBrandListViewHolder extends RecyclerView.ViewHolder {
        TextView tvChooseNewCarBrandListFirstLetter;
        Switch switchChooseNewCarBrandList;
        RecyclerView recyclerViewChooseNewCarBrandList;

        public TypeChooseNewCarBrandListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvChooseNewCarBrandListFirstLetter = itemView.findViewById(R.id.tv_choose_new_car_brand_list_firstletter);
            switchChooseNewCarBrandList = itemView.findViewById(R.id.switch_choose_new_car_brand_list);
            recyclerViewChooseNewCarBrandList = itemView.findViewById(R.id.recycler_view_choose_new_car_brand_list);
        }
    }


}
