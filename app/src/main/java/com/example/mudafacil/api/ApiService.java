package com.example.mudafacil.api;

import com.example.mudafacil.api.User;
import com.example.mudafacil.login.LoginRequest;
import com.example.mudafacil.login.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiService {
    @POST("register")
    Call<User> registerUser(@Body User user);

    @POST("login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @PUT("update-profile")
    Call<User> updateUser(@Body User user);
}
