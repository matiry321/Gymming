package com.example.gymming;

import android.os.Parcel;
import android.os.Parcelable;

public class Modelclass implements Parcelable {
    protected Modelclass(Parcel in) {
        id = in.readInt();
        name = in.readString();
        shortdescp = in.readString();
        longdescp = in.readString();
        imageUrl = in.readString();
    }

    public static final Creator<Modelclass> CREATOR = new Creator<Modelclass>() {
        @Override
        public Modelclass createFromParcel(Parcel in) {
            return new Modelclass(in);
        }

        @Override
        public Modelclass[] newArray(int size) {
            return new Modelclass[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(shortdescp);
        dest.writeString(longdescp);
        dest.writeString(imageUrl);
    }

    private int id;
    private String name;
    private String shortdescp;
    private String longdescp;
    private String imageUrl;

    public Modelclass(int id, String name, String shortdescp, String longdescp, String imageUrl) {
        this.id = id;
        this.name = name;
        this.shortdescp = shortdescp;
        this.longdescp = longdescp;
        this.imageUrl = imageUrl;
    }

    public static Modelclass get(int position) {
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortdescp() {
        return shortdescp;
    }

    public void setShortdescp(String shortdescp) {
        this.shortdescp = shortdescp;
    }

    public String getLongdescp() {
        return longdescp;
    }

    public void setLongdescp(String longdescp) {
        this.longdescp = longdescp;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Modelclass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortdescp='" + shortdescp + '\'' +
                ", longdescp='" + longdescp + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
