package com.xuxe.hats.pojos;

import com.xuxe.hats.attributes.HatType;
import com.xuxe.hats.attributes.Wearable;

import java.util.ArrayList;
import java.util.List;

public class Hat implements Wearable {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HatType> getTypes() {
        return types;
    }

    public void setTypes(List<HatType> types) {
        this.types = types;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    private String name;
    private List<HatType> types = new ArrayList<>();
    private String information;
    private String origin;
    private String pictureURL;

    @Override
    public boolean wear(Person p) {
        return p.wear(this);
    }
}
