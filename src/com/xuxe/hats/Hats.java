package com.xuxe.hats;

import com.xuxe.hats.attributes.HatType;
import com.xuxe.hats.cli.CLI;
import com.xuxe.hats.pojos.Hat;
import com.xuxe.hats.pojos.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class for Hats-GCI
 * Initializes the CLI, Person and adds Default hats
 */
public class Hats {
    public static boolean run;
    public static Person person;
    public static void main(String[] args) {
        // Create our person object
        person = new Person();
        // Initialize the Command Line Interface (CLI)
        CLI.initializeCLI();
        // Add a default hat
        addDefaultHats();
        run = true;
        // keep running our CLI menu till exit
        while (run) {
            CLI.runMenu(); // run our CLI
        }
        System.out.println("You have exited hats.");
    }

    /**
     * Adds default hats.
     * At the time of writing, default hat is fedora.
     */
    private static void addDefaultHats() {
        //Create a new hat object
        Hat hat = new Hat();
        //Initialize members of our hat object (polymorphism)
        hat.setName("fedora");
        hat.setOrigin("United States");
        hat.setInformation("A fedora is a hat with a soft brim and indented crown.");
        List<HatType> types = new ArrayList<>();
        types.add(HatType.CASUAL);
        hat.setTypes(types);
        //Add hat to our hat list
        HatKeeper.addHat("fedora", hat);
    }
}

