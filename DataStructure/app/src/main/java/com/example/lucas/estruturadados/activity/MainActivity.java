package com.example.lucas.estruturadados.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lucas.estruturadados.R;
import com.example.lucas.estruturadados.adapter.RoomAdapter;
import com.example.lucas.estruturadados.config.RetrofitConfig;
import com.example.lucas.estruturadados.model.Room;
import com.example.lucas.estruturadados.presenter.MainPresenter;
import com.example.lucas.estruturadados.services.RoomService;
import com.example.lucas.estruturadados.view.MainView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements MainView {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RoomService roomService = new RetrofitConfig().createService(RoomService.class);
        MainPresenter presenter = new MainPresenter(this, roomService);
        presenter.initialize();
    }

    @Override
    public void fillRecycler(List<Room> rooms, Map<Integer, ArrayList<Room>> subCategory) {
        recyclerView.setAdapter(new RoomAdapter(rooms, subCategory));
    }
}
