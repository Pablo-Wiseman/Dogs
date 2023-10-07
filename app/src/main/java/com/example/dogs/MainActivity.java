package com.example.dogs;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    private MainViewModel viewModel;
    private static final String TAG = "MainActivity";
    private ImageView imageViewDogImage;
    private Button buttonChangeImage;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

      viewModel = new ViewModelProvider(this).get(MainViewModel.class);
      viewModel.loadDogImage();
      viewModel.getDogImage().observe(this, new Observer<DogImage>() {
          @Override
          public void onChanged(DogImage dogImage) {
              Log.d(TAG, dogImage.toString());
          }
      });

    }

    private void initViews(){
        imageViewDogImage = findViewById(R.id.imageViewDogImage);
        buttonChangeImage = findViewById(R.id.buttonChangeImage);
        progressBar = findViewById(R.id.progressBar);
    }



}