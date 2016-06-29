package com.example.lucas.estruturadados.view;

import com.example.lucas.estruturadados.model.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Lucas Campos
 * @since 1.0.0
 */
public interface MainView {
    void fillRecycler(List<Room> rooms, Map<Integer, ArrayList<Room>> subCategory);
}
