package com.azkar.azkarelmuslim.azkartypespackage.Views.adapters;

import com.azkar.azkarelmuslim.R;
import com.azkar.azkarelmuslim.azkartypespackage.models.AzkarTypeModel;
import com.azkar.azkarelmuslim.base.OnItemClickListener;

import java.util.ArrayList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AzkarSpecificTypeAdapter extends RecyclerView.Adapter<AzkarSpecificTypeAdapter.ItemViewHolder> {

    private Context Context;
    private ArrayList<AzkarTypeModel> sbahModelArrayList;
    private OnItemClickListener<AzkarTypeModel> onItemClick;

    public AzkarSpecificTypeAdapter(Context mContext, ArrayList<AzkarTypeModel> modelArrayList) {
        this.Context = mContext;
        sbahModelArrayList = modelArrayList;
    }

    public void setOnItemClickListener(OnItemClickListener<AzkarTypeModel> clickListener) {
        this.onItemClick = clickListener;
    }

    @NonNull
    @Override
    public AzkarSpecificTypeAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(Context);
        View view = layoutInflater.inflate(R.layout.azkar_row_layout, parent, false);
        return new AzkarSpecificTypeAdapter.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AzkarSpecificTypeAdapter.ItemViewHolder holder, int position) {

        AzkarTypeModel azkarTypeModel = sbahModelArrayList.get(position);
        holder.azkarSbahText.setText(azkarTypeModel.getAzkarSbahText());
        holder.azkarSbahPeriodText.setText(azkarTypeModel.getPeriodAzkarSbah());
        holder.azkarSbahText.setTextSize(azkarTypeModel.getAzkarSbahFont());
        holder.azkarSbahPeriodText.setTextSize(azkarTypeModel.getAzkarSbahFont());

    }

    @Override
    public int getItemCount() {
        return sbahModelArrayList.size();
    }


    class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.azkarsbaht_tv)
        TextView azkarSbahText;

        @BindView(R.id.period_azkar_tv)
        TextView azkarSbahPeriodText;

        ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.increase_line_btn)
        void onIncreaseBtnClicked() {
            AzkarTypeModel azkarTypeModel = sbahModelArrayList.get(getAdapterPosition());
            azkarTypeModel.setIncreaseOrDecrease("IN");
            onItemClick.onItemClick(azkarTypeModel);
        }

        @OnClick(R.id.decrease_line_btn)
        void onDecreaseBtnClicked() {
            AzkarTypeModel azkarTypeModel = sbahModelArrayList.get(getAdapterPosition());
            azkarTypeModel.setIncreaseOrDecrease("DE");
            azkarTypeModel.setIndexOfAzkarNow(getAdapterPosition());
            onItemClick.onItemClick(azkarTypeModel);
        }
    }
}
