package com.example.evaluationtask;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class SavedFragment extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_saved2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<FoodItem> foodItems = FoodDatabase.getInstance(getContext()).foodDao().getAllData();
        List<Category> categoryList = new ArrayList<>();
        for (int i = 0; i < foodItems.size(); i++) {
            Category category = new Category();
            category.setIdCategory(foodItems.get(i).getIdCategory());
            category.setStrCategory(foodItems.get(i).getStrCategory());
            category.setStrCategoryDescription(foodItems.get(i).getStrCategoryDescription());
            category.setStrCategoryThumb(foodItems.get(i).getStrCategoryThumb());
            categoryList.add(category);
        }
        PhpAdapter phpAdapter = new PhpAdapter(getContext(), categoryList, false);
        recyclerView.setAdapter(phpAdapter);
    }
}