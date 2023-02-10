package com.example.pet_store;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface api {
    @GET("pet/{petId}")
    Call<Pet> getPetId(
            @Path("petId") String petId);

    @POST("pet")
    Call<Pet> createPet(@Body Pet pet);

}