package com.xuxe.hats;

import com.xuxe.hats.attributes.HatType;
import com.xuxe.hats.cli.CLI;
import com.xuxe.hats.pojos.Hat;
import com.xuxe.hats.pojos.Person;

import java.util.ArrayList;
import java.util.List;

public class Hats {
    public static boolean run;
    public static Person person;
    public static void main(String[] args) {
        person = new Person();
        CLI.initializeCLI();
        addDefaultHats();
        run = true;
        while (run) {
            CLI.runMenu();
        }
        System.out.println("You have exited hats.");
    }

    private static void addDefaultHats() {
        Hat hat = new Hat();
        hat.setName("fedora");
        hat.setOrigin("United States");
        hat.setInformation("A fedora is a hat with a soft brim and indented crown.");
        List<HatType> types = new ArrayList<>();
        types.add(HatType.CASUAL);
        hat.setTypes(types);
        HatKeeper.addHat("fedora", hat);
    }
}

