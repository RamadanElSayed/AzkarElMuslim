package com.azkar.azkarelmuslim.addingazkarpackage.views.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.azkar.azkarelmuslim.R;
import com.azkar.azkarelmuslim.base.OnItemClickListener;
import com.azkar.azkarelmuslim.database.AzkarModelDB;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DisplayingFragmentAdapter extends RecyclerView.Adapter<DisplayingFragmentAdapter.ItemViewHolder> {

    private android.content.Context Context;
    private List<AzkarModelDB> azkarModelDBS;
    private OnItemClickListener<AzkarModelDB> onItemClick;

    public DisplayingFragmentAdapter(Context mContext, List<AzkarModelDB> modelArrayList) {
        this.Context = mContext;
        azkarModelDBS = modelArrayList;
    }

    public void setOnItemClickListener(OnItemClickListener<AzkarModelDB> clickListener) {
        this.onItemClick = clickListener;
    }

    @NonNull
    @Override
    public DisplayingFragmentAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(Context);
        View view = layoutInflater.inflate(R.layout.adding_azkar_row_layout, parent, false);
        return new DisplayingFragmentAdapter.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DisplayingFragmentAdapter.ItemViewHolder holder, int position) {
        AzkarModelDB azkarModelDB = azkarModelDBS.get(position);
        holder.azkarAddingText.setText(azkarModelDB.getAzkarContent());
    }

  @Override
    public int getItemCount() {
        return azkarModelDBS.size();
    }
    class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.azkar_adding_id)
        TextView azkarAddingText;

        ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.azkar_adding_id)
        void onAzkarBtnClicked() {
            AzkarModelDB azkarModelDB = azkarModelDBS.get(getAdapterPosition());
            onItemClick.onItemClick(azkarModelDB);
        }

    }
}
