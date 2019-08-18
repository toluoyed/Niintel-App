package com.example.android.projectnetintel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MenuActivityAdapter extends RecyclerView.Adapter<MenuActivityAdapter.MenuActivityViewHolder> {

    Context mContext;
    List<MenuItems> mList;

    public MenuActivityAdapter(Context mContext, List<MenuItems> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MenuActivityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View layout;
        layout = LayoutInflater.from(mContext).inflate(R.layout.menu_list,viewGroup,false);

        return new MenuActivityViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuActivityViewHolder menuActivityViewHolder, final int i) {

        menuActivityViewHolder.foodName.setText(mList.get(i).getFoodName());
        menuActivityViewHolder.foodDesc.setText(mList.get(i).getFoodDescription());
        menuActivityViewHolder.foodImg.setImageResource(mList.get(i).getFoodImage());

        menuActivityViewHolder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(mContext,PurchaseActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("foodName",mList.get(i).getFoodName());
                bundle.putString("foodDesc",mList.get(i).getFoodDescription());
                bundle.putInt("foodImg",mList.get(i).getFoodImage());
                bundle.putDouble("foodPrice",mList.get(i).getPrice());
                b.putExtras(bundle);
                mContext.startActivity(b);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class MenuActivityViewHolder extends RecyclerView.ViewHolder{

        TextView foodName;
        TextView foodDesc;
        ImageView foodImg;
        ConstraintLayout constraintLayout;

        public MenuActivityViewHolder(@NonNull View itemView) {
            super(itemView);

            foodName = itemView.findViewById(R.id.foodName);
            foodDesc = itemView.findViewById(R.id.foodDesc);
            foodImg = itemView.findViewById(R.id.foodImage);
            constraintLayout = itemView.findViewById(R.id.parentLayout);
        }
    }
}
