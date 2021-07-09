package com.codepath.parstagram;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.codepath.parstagram.databinding.ActivityDetailsBinding;
import android.os.Bundle;
import android.view.View;

import org.parceler.Parcels;

public class DetailsActivity extends AppCompatActivity {

    Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailsBinding binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        post = (Post) Parcels.unwrap(getIntent().getParcelableExtra(Post.class.getSimpleName()));
        binding.tvUsername.setText(post.getUser().getUsername());
        binding.tvDescription.setText(post.getDescription());
        binding.tvCreatedAt.setText(Post.getRelativeTimeAgo(post.getCreatedAt()));
        Glide.with(this)
                .load(post.getImage().getUrl())
                .into(binding.ivImage);

    }

}