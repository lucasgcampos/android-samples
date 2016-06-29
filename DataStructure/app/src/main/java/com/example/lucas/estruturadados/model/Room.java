package com.example.lucas.estruturadados.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * @author Lucas Campos
 * @since 1.0.0
 */
public class Room implements Parcelable {

    private Integer id;
    private Integer parent_room_id;
    private String name;
    private String meta_title;
    private String meta_description;
    private boolean show_on_home_page;
    private String slug;
    private ArrayList<Room> subCategories = new ArrayList<>();

    public Room(Integer id, Integer parent_room_id, String name, String meta_title, String meta_description, boolean show_on_home_page, String slug) {
        this.id = id;
        this.parent_room_id = parent_room_id;
        this.name = name;
        this.meta_title = meta_title;
        this.meta_description = meta_description;
        this.show_on_home_page = show_on_home_page;
        this.slug = slug;
    }

    public ArrayList<Room> getSubCategories() {
        return subCategories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParent_room_id() {
        return parent_room_id;
    }

    public void setParent_room_id(Integer parent_room_id) {
        this.parent_room_id = parent_room_id;
    }

    public void addSubCategory(Room sub) {
        if (subCategories == null) {
            subCategories = new ArrayList<>();
        }
        subCategories.add(sub);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeValue(this.parent_room_id);
        dest.writeString(this.name);
        dest.writeString(this.meta_title);
        dest.writeString(this.meta_description);
        dest.writeByte(this.show_on_home_page ? (byte) 1 : (byte) 0);
        dest.writeString(this.slug);
        dest.writeList(this.subCategories);
    }

    protected Room(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.parent_room_id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
        this.meta_title = in.readString();
        this.meta_description = in.readString();
        this.show_on_home_page = in.readByte() != 0;
        this.slug = in.readString();
        this.subCategories = new ArrayList<Room>();
        in.readList(this.subCategories, Room.class.getClassLoader());
    }

    public static final Parcelable.Creator<Room> CREATOR = new Parcelable.Creator<Room>() {
        @Override
        public Room createFromParcel(Parcel source) {
            return new Room(source);
        }

        @Override
        public Room[] newArray(int size) {
            return new Room[size];
        }
    };
}
