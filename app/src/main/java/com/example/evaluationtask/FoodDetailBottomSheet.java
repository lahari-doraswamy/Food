package com.example.evaluationtask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class FoodDetailBottomSheet extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bottomsheet_food_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() == null) {
            return;
        }
        Category foodDetails = (Category) getArguments().getSerializable("foodItem");
        boolean isFromRemoteFragment = getArguments().getBoolean("isFromRemoteFragment");
        FoodItem foodItem = new FoodItem();
        foodItem.setFoodId(foodDetails.getIdCategory());
        foodItem.setIdCategory(foodDetails.getIdCategory());
        foodItem.setStrCategory(foodDetails.getStrCategory());
        foodItem.setStrCategoryThumb(foodDetails.getStrCategoryThumb());
        foodItem.setStrCategoryDescription(foodDetails.getStrCategoryDescription());

        ((TextView) view.findViewById(R.id.tvFoodDesc)).setText(foodDetails.getStrCategoryDescription());

        Button addButton = (Button) view.findViewById(R.id.btAdd);
        if (isFromRemoteFragment) {
            addButton.setText("Add");
            addButton.setOnClickListener(view1 -> {
                FoodDatabase.getInstance(getContext()).foodDao().insert(foodItem);
                dismiss();
            });
        } else {
            addButton.setText("Remove");
            addButton.setOnClickListener(view12 -> {
                FoodDatabase.getInstance(getContext()).foodDao().delete(foodItem);
                SavedFragment savedFragment = new SavedFragment();
                ((AppCompatActivity) getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.container, savedFragment).commit();
                dismiss();
            });
        }


    }
}
