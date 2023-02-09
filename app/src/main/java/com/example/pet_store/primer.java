package com.example.pet_store;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.petstore.swagger.Category;
import com.example.petstore.swagger.Pet;
import com.example.petstore.swagger.JSONApi;
import com.example.petstore.swagger.Tag;
import com.google.gson.Gson;import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class primer extends AppCompatActivity {
    TextView textView;
    EditText editText;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.);
    }
    public void getPetInfo (View view) {
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.edText);
        imageView = findViewById(R.id.imageView);
        String path = String.valueOf(editText.getText());
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://petstore.swagger.io/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        JSONApi jsonApi = retrofit.create(JSONApi.class);
                Call<Pet> call = jsonApi.getPet(path);
                call.enqueue(new Callback<Pet>() {
                    @Override
                    public void onResponse(Call<Pet> call, Response<Pet> response) {
                        if (!response.isSuccessful()) {
                            textView.setText(String.valueOf(response.code()));
                            return;
                        }
                        Pet pet = response.body();
                        Category category = pet.getCategory();
                        List<Tag> tagList = pet.getTags();
                        Tag tag = tagList.get(0);
                        String text = "";
                        text += "Вашего питомца зовут: " + String.valueOf(pet.getName()) +
                                "\nID вашего питомца: " + String.valueOf(pet.getId()) +
                                "\nВид вашего питомца: " + String.valueOf(category.getName()) +
                                "\nПол вашего питомца: " + String.valueOf(tag.getName()) +
                                "\nСтатус вашего питомца: " + String.valueOf(pet.getStatus());
                        textView.setText(text);
                        Picasso.with(MainActivity.this)
                                .load(pet.getPhotoUrls().get(0))
                                .resize(300,300)
                                .into(imageView);
                    }
                    @Override
                    public void onFailure(Call<Pet> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Что-то пошло не так: " + t.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
    public void onClick(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        finish();
    }
}