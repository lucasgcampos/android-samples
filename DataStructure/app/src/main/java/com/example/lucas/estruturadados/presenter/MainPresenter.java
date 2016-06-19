package com.example.lucas.estruturadados.presenter;

import com.example.lucas.estruturadados.model.Room;
import com.example.lucas.estruturadados.services.RoomService;
import com.example.lucas.estruturadados.view.MainView;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

import static rx.schedulers.Schedulers.io;

/**
 * @author Lucas Campos
 * @since 1.0.0
 */
public class MainPresenter {

    private final MainView view;
    private final RoomService roomService;

    public MainPresenter(MainView view, RoomService roomService) {
        this.view = view;
        this.roomService = roomService;
    }

    public void initialize() {
        final Observable<List<Room>> response = roomService.list();
        response.subscribeOn(io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Room>>() {
            @Override
            public void call(List<Room> results) {

                List<Room> categories = getCategories(results);
                fillCategories(results, categories);

                view.fillRecycler(categories);
            }
        });

    }

    private List<Room> getCategories(List<Room> results) {
        List<Room> categories = new ArrayList<>();

        for (Room result : results) {
            if (result.getParent_room_id() == null) {
                categories.add(result);
            }
        }

        return categories;
    }

    private void fillCategories(List<Room> results, List<Room> categories) {
        for (Room result : results) {
            for (Room category : categories) {
                if (result.getParent_room_id() != null && result.getParent_room_id().equals(category.getId())) {
                    category.addSubCategory(result);
                    break;
                }
            }
        }
    }
}
