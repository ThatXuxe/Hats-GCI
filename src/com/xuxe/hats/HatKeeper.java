package com.xuxe.hats;

import com.xuxe.hats.pojos.Hat;
import com.xuxe.hats.pojos.Person;

import java.util.HashMap;

public class HatKeeper {
    public static HashMap<String, Hat> hats = new HashMap<>();
    public static Person person;

    public static void addHat(String name, Hat hat) {
        hats.put(name, hat);
    }
    public static void removeHat(String name) {
        hats.remove(name);
    }
    public static HashMap<String, Hat>  getHats() {
        return hats;
    }
}
