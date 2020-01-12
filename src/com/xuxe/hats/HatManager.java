package com.xuxe.hats;

import com.xuxe.hats.attributes.HatType;
import com.xuxe.hats.pojos.Hat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HatManager {
    public boolean makeHat() {
        try {
            // get hattributes (pun intended) from user
            Hat hat = getHatInputs();
            // add hat to keeper
            HatKeeper.addHat(hat.getName(),hat);
            System.out.println("New hat created!");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void deleteHat(String name) {
        HatKeeper.removeHat(name);
        System.out.println("Your hat has been deleted.");
    }
    public void deleteHat(Hat hat) {
        deleteHat(hat.getName());
    }

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
