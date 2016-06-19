package com.example.lucas.estruturadados.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lucas.estruturadados.R;
import com.example.lucas.estruturadados.adapter.RoomAdapter;
import com.example.lucas.estruturadados.model.Room;

import java.util.ArrayList;
import java.util.List;

public class CategoryDetail extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);

        List<Room> subCategories = new ArrayList<>();
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("subcategories")) {
            subCategories = intent.getParcelableArrayListExtra("subcategories");
        }

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new RoomAdapter(subCategories));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
