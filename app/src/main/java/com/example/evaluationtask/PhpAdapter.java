package com.example.evaluationtask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

   public class PhpAdapter extends RecyclerView.Adapter<com.example.evaluationtask.PhpAdapter.PhpViewHolder> {

        List<Category> RootList;
        Context context;
        public PhpAdapter(Context context,List<Category> Root){
            this.context= context;
            RootList=Root;

        }


        @NonNull
        @Override
        public PhpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
            return new PhpViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PhpViewHolder holder, int position) {
            Category root = RootList.get(position);
            holder.strCategory.setText(root.getStrCategory());
            Picasso.with(holder.itemView.getContext())
                    .load(RootList.get(position).getStrCategoryThumb())
                    .into(holder.strCategoryThumb);

        }


        @Override
        public int getItemCount() {
            return RootList.size();
        }

        public static class PhpViewHolder extends RecyclerView.ViewHolder{
            TextView strCategory;
                ImageView strCategoryThumb;

            public PhpViewHolder(@NonNull View itemView) {
                super(itemView);
                strCategory = itemView.findViewById(R.id.strCategory);
                strCategoryThumb=itemView.findViewById(R.id.strCategoryThumb_tv);

            }
        }
    }


