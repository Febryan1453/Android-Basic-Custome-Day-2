package com.febryan.multimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;

import com.febryan.multimedia.databinding.ActivityVideoStreamingBinding;

public class VideoStreamingActivity extends AppCompatActivity {

    private ActivityVideoStreamingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVideoStreamingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        String urlVideo = "https://s.id/EMdZV";

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(binding.videoViewStreaming);
        binding.videoViewStreaming.setMediaController(mediaController);

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading...");
        progressDialog.show();

        binding.videoViewStreaming.setVideoURI(Uri.parse(urlVideo));
        binding.videoViewStreaming.requestFocus();
        binding.videoViewStreaming.setOnPreparedListener(mp -> {
            progressDialog.dismiss();
            mp.start();
        });

    }
}