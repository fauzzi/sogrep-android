package com.skripsisogrep.models;

<<<<<<< HEAD
=======
import android.support.annotation.Nullable;

import org.parceler.Parcel;

>>>>>>> 145538146323b1263bfe98bb1829263ed6a24cfc
/**
 * Created by Akhmad Fauzi Hasibuan on 9/30/2017
 * akhmadfauzihasibuan@gmail.com
 * https://github.com/fauzzi
 */
<<<<<<< HEAD
=======

@Parcel(Parcel.Serialization.BEAN)
>>>>>>> 145538146323b1263bfe98bb1829263ed6a24cfc
public class Optik {

    private String name;
    private String address;
    private String open_time;
    private String close_time;
    private String phone;
    private String rating;
    private int picture;

<<<<<<< HEAD
=======
    public Optik() {
    }

>>>>>>> 145538146323b1263bfe98bb1829263ed6a24cfc
    public Optik(String name, String address, String open_time, String close_time, String phone, String rating, int picture) {
        this.name = name;
        this.address = address;
        this.open_time = open_time;
        this.close_time = close_time;
        this.phone = phone;
        this.rating = rating;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpen_time() {
        return open_time;
    }

    public void setOpen_time(String open_time) {
        this.open_time = open_time;
    }

    public String getClose_time() {
        return close_time;
    }

    public void setClose_time(String close_time) {
        this.close_time = close_time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
