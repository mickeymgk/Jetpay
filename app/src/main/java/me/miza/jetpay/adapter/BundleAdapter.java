package me.miza.jetpay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import me.miza.jetpay.R;
import me.miza.jetpay.model.Bundle;

public class BundleAdapter extends RecyclerView.Adapter<BundleAdapter.PackageViewHolder> {
    private Context context;
    private ArrayList<Bundle> data;
    private static final double constant = 0.2;

    public BundleAdapter(Context context, ArrayList<Bundle> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public BundleAdapter.PackageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_bundle, parent, false);
        return new PackageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BundleAdapter.PackageViewHolder holder, int position) {
        holder.mTextSave.setText(context.getResources().getString(R.string.saved_money,
                String.valueOf(data.get(position).amount*constant-data.get(position).cost)));
        holder.mTextAmount.setText(context.getResources().getString(R.string.mb, data.get(position).amount));
        holder.mTextCost.setText(context.getResources().getString(R.string.birr,data.get(position).cost));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class PackageViewHolder extends RecyclerView.ViewHolder {

        TextView mTextAmount;
        TextView mTextCost;
        TextView mTextSave;
        TextView mTextDuration;


        PackageViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setClickable(true);
            mTextAmount = itemView.findViewById(R.id.text_amount);
            mTextCost = itemView.findViewById(R.id.text_cost);
            mTextSave = itemView.findViewById(R.id.text_save);
            mTextDuration = itemView.findViewById(R.id.text_duration);

        }
    }
}

