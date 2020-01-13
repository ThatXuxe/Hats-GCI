package com.xuxe.hats.attributes;

import com.xuxe.hats.pojos.Person;

/**
 * Wearable interface to implement Abstraction
 * Contains wear method
 */
public interface Wearable {

    /**
     * Gives Hats the property to be worn on people
     * @param p Person object to which hat is worn
     * @return whether wear was successful
     */
    boolean wear(Person p);
}
