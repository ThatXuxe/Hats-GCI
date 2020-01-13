package com.xuxe.hats.pojos;

/**
 * Person is a class containing the current user's "hats and stats"
 * such as name, hat and wearing state.
 * Although the current Framework supports, one user. This class allows it to be
 * scaled to multiple users.
 */
public class Person {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hat getHat() {
        return hat;
    }

    public void setHat(Hat hat) {
        this.hat = hat;
    }

    public boolean isWearing() {
        return wearing;
    }

    public void setWearing(boolean wearing) {
        this.wearing = wearing;
    }

    private String name;
    private Hat hat = null;
    boolean wearing;

    public boolean wear(Hat hat) {
        wearing = hat != this.hat;
        this.hat = hat;
        return wearing;
    }
}
