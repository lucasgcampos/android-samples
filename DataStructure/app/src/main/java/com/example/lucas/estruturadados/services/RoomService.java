package com.example.lucas.estruturadados.services;

import com.example.lucas.estruturadados.model.Room;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * @author Lucas Campos
 * @since 1.0.0
 */
public interface RoomService {

    @GET(value = "api/1/rooms")
    Observable<List<Room>> list();
}
