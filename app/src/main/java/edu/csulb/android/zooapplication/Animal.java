package edu.csulb.android.zooapplication;

/**
 * Created by Charvoz on 19/02/2017.
 */

public class Animal {
    private String name;
    private String img;
    private String description;
    private int drawableID;



    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", description='" + description + '\'' +
                ", drawableID=" + drawableID +
                '}';
    }

    public Animal(String name, String img, int drawableID, String description) {
        this.name = name;
        this.img = img;
        this.description = description;
        this.drawableID = drawableID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public int getDrawableID() {
        return drawableID;
    }

    public void setDrawableID(int drawableID) {
        this.drawableID = drawableID;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
