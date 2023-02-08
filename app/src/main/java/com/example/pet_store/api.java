package com.example.pet_store;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface api {
    @GET("/pet/{petId}")
    Call<Pet> getId(
            @Path("petId") String petId
    );

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://petstore.swagger.io/v2/pet/104")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @POST("/pet/{petId}/uploadImage")
    Call<Pet> createPet(@Body Pet pet);

    Retrofit retrofit2 = new Retrofit.Builder()
            .baseUrl("https://petstore.swagger.io/v2/pet/104/uploadImage")
            .build();
}