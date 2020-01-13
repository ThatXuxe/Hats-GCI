package com.xuxe.hats;

import com.xuxe.hats.attributes.HatType;
import com.xuxe.hats.pojos.Hat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * This class is responsible for the creation, deletion and management of hats.
 */
public class HatManager {
    public void makeHat() {
        try {
            // get attributes from user
            Hat hat = getHatInputs();
            // add hat to keeper
            HatKeeper.addHat(hat.getName(),hat);
            System.out.println("New hat created!");
        } catch (Exception e) {
            System.err.println("An error has occured: "+e.getLocalizedMessage());
        }
    }
    public void deleteHat(String name) {
        HatKeeper.removeHat(name);
        System.out.println("Your hat has been deleted.");
    }
    public void deleteHat(Hat hat) {
        deleteHat(hat.getName());
    }

    /**
     * Gets user inputs through scanner to initialize a Hat object
     * @return Initialized Hat object
     */
    private Hat getHatInputs() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your hat's name:");
        String name = sc.nextLine();
        Hat hat = new Hat();
        hat.setName(name);
        System.out.println("Enter "+name+"'s attributes separated by commas: " +
                Arrays.toString(HatType.values()));
        List<HatType> types = new ArrayList<>();
        for (String s : sc.nextLine().split(",")) {
            s = s.trim();
            if(s.isEmpty()) continue;
            types.add(HatType.valueOf(s));
        }
        hat.setTypes(types);
        System.out.println("Enter some information about "+name+":");
        hat.setInformation(sc.nextLine());
        System.out.println("Where is "+name+ " from?");
        hat.setOrigin(sc.nextLine());
        System.out.println("If you have a link to "+name+"'s picture, give it here:");
        hat.setPictureURL(sc.nextLine());
        return hat;
    }
}
