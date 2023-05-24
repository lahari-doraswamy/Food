package com.example.evaluationtask;

import androidx.cardview.widget.CardView;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceholder {
    @GET("php")
    Call<List<Php>> getPhp();


}
