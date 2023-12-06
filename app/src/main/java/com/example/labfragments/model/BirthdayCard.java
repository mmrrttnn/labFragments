package com.example.labfragments.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class BirthdayCard implements Parcelable {
    private String name;
    private int age;
    private String wish;

    public BirthdayCard(String name, int age, String wish) {
        this.name = name;
        this.age = age;
        this.wish = wish;
    }

    protected BirthdayCard(Parcel in) {
        name = in.readString();
        age = in.readInt();
        wish = in.readString();
    }

    public static final Creator<BirthdayCard> CREATOR = new Creator<BirthdayCard>() {
        @Override
        public BirthdayCard createFromParcel(Parcel in) {
            return new BirthdayCard(in);
        }

        @Override
        public BirthdayCard[] newArray(int size) {
            return new BirthdayCard[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(age);
        parcel.writeString(wish);
    }

    @Override
    public String toString() {
        return "BirthdayCard{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", wish='" + wish + '\'' +
                '}';
    }
}
