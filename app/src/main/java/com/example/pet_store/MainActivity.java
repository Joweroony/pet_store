package com.example.pet_store;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getPetId (View view) {
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editTextTextPersonName);
        imageView = findViewById(R.id.imageView);
        String path = String.valueOf(editText.getText());
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://petstore.swagger.io/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        api jsonapi = retrofit.create(api.class);
        Call<Pet> call = jsonapi.getPetId(path);
        call.enqueue(new Callback<Pet>() {
                @Override
                public void onResponse(Call<Pet> call, Response<Pet> response) {
                    if (!response.isSuccessful()) {
                        textView.setText(String.valueOf(response.code()));
                        return;
                    }
                    Pet pet = response.body();
                    Category category = pet.getName();
                    List<Tag> tagList = Tag.();
                    Tag tag = tagList.get(0);
                    String text = "";
                    text += "Pet name: " + String.valueOf(pet.getName()) +
                            "\nPet ID is: " + String.valueOf(pet.pe()) +
                            "\nPet type is: " + String.valueOf(category.getCategoryName()) +
                            "\nPet Status is: "+ String.valueOf(pet.getPetStatus());
                    textView.setText(text);
                    Picasso.with(MainActivity.this)
                            .load(pet.getPhotoUrl().get(0))
                            .resize(300,300)
                            .into(imageView);
                }

                @Override
                public void onFailure(Call<Pet> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Something wrong: " + t.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            });
    }
}

