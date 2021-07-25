package com.yalemang.carhome.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yalemang.carhome.R;
import com.yalemang.carhome.bean.CarBrandBean;
import com.yalemang.carhome.bean.ChooseCarBean;
import com.yalemang.carhome.until.SpacesItemDecoration;

import java.util.List;

/**
 * @author Administrator
 */
public class ChooseNewCarInformationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<CarBrandBean> carBrandBeanList;
    private List<ChooseCarBean> chooseCarBeanList, chooseCarBeanTextList, chooseCarNavigationAdvertisingList, chooseCarBeanTwoRoundList;
    ;
    private List<String> firstLetterList;

    private int NAVIGATION = 0;
    private int BRAND = 1;
    private int TEXT = 2;
    private int ADVERTISE = 3;
    private int TWO_ROUND = 4;

    public ChooseNewCarInformationAdapter(Context context, List<CarBrandBean> carBrandBeanList, List<ChooseCarBean> chooseCarBeanList, List<ChooseCarBean> chooseCarBeanTextList, List<ChooseCarBean> chooseCarNavigationAdvertisingList, List<ChooseCarBean> chooseCarBeanTwoRoundList, List<String> firstLetterList) {
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
            return NAVIGATION;
        } else if (position == 1) {
            return BRAND;
        } else if (position == 2) {
            return TEXT;
        } else if (position == 3) {
            return ADVERTISE;
        } else {
            return TWO_ROUND;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == NAVIGATION) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_choose_new_car_information_navigation, parent, false);
            TypeChooseNewCarInformationNavigationViewHolder typeChooseNewCarInformationViewHolder = new TypeChooseNewCarInformationNavigationViewHolder(view);
            return typeChooseNewCarInformationViewHolder;
        } else if (viewType == BRAND) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_choose_new_car_information_brand, parent, false);
            TypeChooseNewCarInformationBrandViewHolder typeChooseNewCarInformationBrandViewHolder = new TypeChooseNewCarInformationBrandViewHolder(view);
            return typeChooseNewCarInformationBrandViewHolder;
        } else if (viewType == TEXT) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_choose_new_car_information_text, parent, false);
            TypeChooseNewCarInformationTextViewHolder typeChooseNewCarInformationTextViewHolder = new TypeChooseNewCarInformationTextViewHolder(view);
            return typeChooseNewCarInformationTextViewHolder;
        } else if (viewType == ADVERTISE) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_choose_new_car_information_advertise, parent, false);
            TypeChooseNewCarInformationAdvertiseViewHolder typeChooseNewCarInformationAdvertiseViewHolder = new TypeChooseNewCarInformationAdvertiseViewHolder(view);
            return typeChooseNewCarInformationAdvertiseViewHolder;
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_choose_new_car_information_two_round, parent, false);
            TypeChooseNewCarInformationTwoRoundViewHolder typeChooseNewCarInformationTwoRoundViewHolder = new TypeChooseNewCarInformationTwoRoundViewHolder(view);
            return typeChooseNewCarInformationTwoRoundViewHolder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TypeChooseNewCarInformationNavigationViewHolder) {
            TypeChooseNewCarInformationNavigationViewHolder typeChooseNewCarInformationViewHolder = (TypeChooseNewCarInformationNavigationViewHolder) holder;

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            typeChooseNewCarInformationViewHolder.chooseNewCarInformationNavigationRecyclerView.setLayoutManager(linearLayoutManager);
            typeChooseNewCarInformationViewHolder.chooseNewCarInformationNavigationRecyclerView.setAdapter(new ChooseNewCarInformationNavigationAdapter(context, carBrandBeanList, chooseCarBeanList));
            int space = 10;
            typeChooseNewCarInformationViewHolder.chooseNewCarInformationNavigationRecyclerView.addItemDecoration(new SpacesItemDecoration(space));
        } else if (holder instanceof TypeChooseNewCarInformationBrandViewHolder) {
            TypeChooseNewCarInformationBrandViewHolder typeChooseNewCarInformationBrandViewHolder = (TypeChooseNewCarInformationBrandViewHolder) holder;

            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 5);
            gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
            typeChooseNewCarInformationBrandViewHolder.recyclerViewChooseNewCarInformationBrand.setLayoutManager(gridLayoutManager);
            typeChooseNewCarInformationBrandViewHolder.recyclerViewChooseNewCarInformationBrand.setAdapter(new ChooseNewCarInformationBrandAdapter(context, carBrandBeanList));
        } else if (holder instanceof TypeChooseNewCarInformationTextViewHolder) {
            TypeChooseNewCarInformationTextViewHolder typeChooseNewCarInformationTextViewHolder = (TypeChooseNewCarInformationTextViewHolder) holder;

            GridLayoutManager gridLayoutManagerT = new GridLayoutManager(context, 5);
            gridLayoutManagerT.setOrientation(RecyclerView.VERTICAL);
            typeChooseNewCarInformationTextViewHolder.recyclerViewChooseNewCarInformationText.setLayoutManager(gridLayoutManagerT);
            typeChooseNewCarInformationTextViewHolder.recyclerViewChooseNewCarInformationText.setAdapter(new ChooseNewCarInformationTextAdapter(context, chooseCarBeanTextList));
        } else if (holder instanceof TypeChooseNewCarInformationAdvertiseViewHolder) {
            TypeChooseNewCarInformationAdvertiseViewHolder typeChooseNewCarInformationAdvertiseViewHolder = (TypeChooseNewCarInformationAdvertiseViewHolder) holder;

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            typeChooseNewCarInformationAdvertiseViewHolder.recyclerViewChooseNewCarInformationAdvertise.setLayoutManager(linearLayoutManager);
            typeChooseNewCarInformationAdvertiseViewHolder.recyclerViewChooseNewCarInformationAdvertise.setAdapter(new ChooseNewCarInformationAdvertiseAdapter(context, chooseCarNavigationAdvertisingList));
            int space = 30;
            typeChooseNewCarInformationAdvertiseViewHolder.recyclerViewChooseNewCarInformationAdvertise.addItemDecoration(new SpacesItemDecoration(space));
        } else if (holder instanceof TypeChooseNewCarInformationTwoRoundViewHolder) {
            TypeChooseNewCarInformationTwoRoundViewHolder typeChooseNewCarInformationTwoRoundViewHolder = (TypeChooseNewCarInformationTwoRoundViewHolder) holder;

            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, chooseCarBeanTwoRoundList.size());
            gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
            typeChooseNewCarInformationTwoRoundViewHolder.recyclerViewChooseNewCarInformationTwoRound.setLayoutManager(gridLayoutManager);
            typeChooseNewCarInformationTwoRoundViewHolder.recyclerViewChooseNewCarInformationTwoRound.setAdapter(new ChooseNewCarInformationTwoRoundAdapter(context, chooseCarBeanTwoRoundList));
        }


    }


    @Override
    public int getItemCount() {
        return 5;
    }

    //第一个  改成viewpager
    public class TypeChooseNewCarInformationNavigationViewHolder extends RecyclerView.ViewHolder {

        RecyclerView chooseNewCarInformationNavigationRecyclerView;

        public TypeChooseNewCarInformationNavigationViewHolder(@NonNull View itemView) {
            super(itemView);
            chooseNewCarInformationNavigationRecyclerView = itemView.findViewById(R.id.recycler_view_choose_new_car_information_navigation);
        }
    }

    public class TypeChooseNewCarInformationBrandViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerViewChooseNewCarInformationBrand;

        public TypeChooseNewCarInformationBrandViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerViewChooseNewCarInformationBrand = itemView.findViewById(R.id.recycler_view_choose_new_car_information_brand);
        }
    }

    public class TypeChooseNewCarInformationTextViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerViewChooseNewCarInformationText;

        public TypeChooseNewCarInformationTextViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerViewChooseNewCarInformationText = itemView.findViewById(R.id.recycler_view_choose_new_car_information_text);
        }
    }


    public class TypeChooseNewCarInformationAdvertiseViewHolder extends RecyclerView.ViewHolder {

        TextView tvChooseCarInformationAdvertise;
        RecyclerView recyclerViewChooseNewCarInformationAdvertise;

        public TypeChooseNewCarInformationAdvertiseViewHolder(@NonNull View itemView) {
            super(itemView);
            tvChooseCarInformationAdvertise = itemView.findViewById(R.id.tv_choose_car_information_advertise);
            recyclerViewChooseNewCarInformationAdvertise = itemView.findViewById(R.id.recycler_view_choose_new_car_information_advertise);
        }
    }

    public class TypeChooseNewCarInformationTwoRoundViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerViewChooseNewCarInformationTwoRound;

        public TypeChooseNewCarInformationTwoRoundViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerViewChooseNewCarInformationTwoRound = itemView.findViewById(R.id.recycler_view_choose_new_car_information_two_round);
        }
    }

}
