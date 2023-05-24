package com.example.evaluationtask;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

   public class PhpAdapter extends RecyclerView.Adapter<com.example.evaluationtask.PhpAdapter.PhpViewHolder> {
        List<Php> phpList;
        Context context;
        public PhpAdapter(Context context,List<Php> php){
            this.context= context;
            phpList=php;

        }

        @NonNull
        @Override
        public PhpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
            return new PhpViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PhpViewHolder holder, int position) {
            Php php = phpList.get(position);
            holder.strCategory.setText(php.getStrCategory());
            holder.strCategoryThumb.setText(php.getStrCategoryThumb());
            holder.strCategoryDescription.setText(php.getStrCategoryDescription());

        }

        @Override
        public int getItemCount() {
            return phpList.size();
        }

        public static class PhpViewHolder extends RecyclerView.ViewHolder{
            TextView strCategory,strCategoryThumb,strCategoryDescription;
            @SuppressLint("CutPasteId")
            public PhpViewHolder(@NonNull View itemView) {
                super(itemView);
                strCategory = itemView.findViewById(R.id.strCategory_tv);
                strCategoryThumb=itemView.findViewById(R.id.strCategorythumb_tv);
                strCategoryDescription=itemView.findViewById(R.id.strCategorythumb_tv);

            }
        }
    }


