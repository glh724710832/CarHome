package com.yalemang.carhome.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yalemang.carhome.R;
import com.yalemang.carhome.bean.CarBrandBean;
import com.yalemang.carhome.bean.ChooseCarBean;

import java.util.List;

/**
 * @author Administrator
 */
public class ChooseNewCarFirstLetterAdapter extends RecyclerView.Adapter<ChooseNewCarFirstLetterAdapter.ChooseNewCarFirstLetterViewHolder> {

    private Context context;
    private List<String> firstLetterList;

    public ChooseNewCarFirstLetterAdapter(Context context, List<String> firstLetterList) {
        this.context = context;
        this.firstLetterList = firstLetterList;

    }

    @NonNull

    @Override
    public ChooseNewCarFirstLetterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_choose_new_car_first_letter, parent, false);
        ChooseNewCarFirstLetterViewHolder chooseNewCarFirstLetterViewHolder = new ChooseNewCarFirstLetterViewHolder(view);
        return chooseNewCarFirstLetterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChooseNewCarFirstLetterAdapter.ChooseNewCarFirstLetterViewHolder holder, int position) {

        holder.tvChooseNewCarFirstletter.setText(firstLetterList.get(position));

    }

    @Override
    public int getItemCount() {
        return firstLetterList.size();
    }


    public class ChooseNewCarFirstLetterViewHolder extends RecyclerView.ViewHolder {

        TextView tvChooseNewCarFirstletter;

        public ChooseNewCarFirstLetterViewHolder(@NonNull View itemView) {
            super(itemView);

            tvChooseNewCarFirstletter = itemView.findViewById(R.id.tv_choose_new_car_firstletter);
        }
    }
}
