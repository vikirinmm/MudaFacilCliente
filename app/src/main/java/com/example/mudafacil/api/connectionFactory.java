package com.example.mudafacil.api;

import com.example.mudafacil.api.model.LoginData;
import com.example.mudafacil.api.model.Usuario;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class connectionFactory {
    private static final OkHttpClient client = new OkHttpClient();
    private static final String BASE_URL="http://ec2-54-207-53-35.sa-east-1.compute.amazonaws.com:8080/api/v1/user/";

    private static final MediaType JSON=MediaType.get("application/json; charset=utf-8");

    public static void post(Usuario usuario, Callback callback) {
        String json=String.format("{\"name\":\"%s\", \"phone\":\"%s\", \"email\":\"%s\",\"password\":\"%s\"}",usuario.getNome(),usuario.getTelefone(),usuario.getEmail(),usuario.getSenha());
        RequestBody body=RequestBody.create(JSON, json);
        Request request=new Request.Builder().url(BASE_URL+"register").post(body).build();
        client.newCall(request).enqueue(callback);
    }
    public static void loginUser(LoginData loginData, Callback callback) {
        String json=String.format("{\"email\":\"%s\",\"password\":\"%s\"}",loginData.getEmail(),loginData.getSenha());
        RequestBody body=RequestBody.create(JSON, json);
        Request request=new Request.Builder().url(BASE_URL+"login").post(body).build();
        client.newCall(request).enqueue(callback);
    }

    public static void getUserByName(String userName,Callback callback){
        String json=String.format("{\"name\":\"%s\"}",userName);
        RequestBody body=RequestBody.create(JSON,json);
        Request request=new Request.Builder().url(BASE_URL+"name/"+userName).post(body).build();
        client.newCall(request).enqueue(callback);
    }
    public void delete(String id,Callback callback){
        String json=String.format(("{\"id\":\"%s\"}"),id);
        RequestBody body=RequestBody.create(JSON,json);
    }
    private static final String BASE_Veichle_URL = "http://ec2-54-207-53-35.sa-east-1.compute.amazonaws.com:8080/api/v1/vehicle/";

    public static void getAllVehicles(Callback callback) {
        Request request = new Request.Builder().url(BASE_Veichle_URL).get().build();
        client.newCall(request).enqueue(callback);
    }
}
