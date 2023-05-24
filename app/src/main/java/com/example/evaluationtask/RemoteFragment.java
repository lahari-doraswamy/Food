package com.example.evaluationtask;

import static android.widget.Toast.makeText;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;



import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RemoteFragment extends Fragment {

    private RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_remote2, container, false);


        recyclerView= view.findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create()).
                build();
        JSONPlaceholder jsonPlaceholder= retrofit.create(JSONPlaceholder.class);
        Call<Root> call =jsonPlaceholder.getRoot();
        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(@NonNull Call<Root> call, @NonNull Response<Root> response) {
                if (!response.isSuccessful()){
                   // Toast.makeText(requireContext(), response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<Category> RootList  = response.body().getCategories();
                PhpAdapter phpAdapter = new PhpAdapter(getContext(),RootList);
                recyclerView.setAdapter(phpAdapter);

            }

            @Override
            public void onFailure(@NonNull Call<Root> call, @NonNull Throwable t) {
                Toast.makeText(requireContext(),t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
        return view;

    }

}