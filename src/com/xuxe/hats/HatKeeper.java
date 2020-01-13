package com.xuxe.hats;

import com.xuxe.hats.pojos.Hat;
import com.xuxe.hats.pojos.Person;

import java.util.HashMap;

/**
 * As the name suggests, HatKeeper keeps record of all the available hats,
 * conveniently storing them in a HashMap for fast access.
 */
public class HatKeeper {
    public static HashMap<String, Hat> hats = new HashMap<>();

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
