package com.example.gymming;

public class Modelclass {
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
