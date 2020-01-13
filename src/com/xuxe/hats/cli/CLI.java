package com.xuxe.hats.cli;

import com.xuxe.hats.HatKeeper;
import com.xuxe.hats.HatManager;
import com.xuxe.hats.Hats;
import com.xuxe.hats.pojos.Hat;

import java.util.HashMap;
import java.util.Scanner;

/**
 * CLI class for command line related methods.
 */
public class CLI {
    /**
     * Shows the menu, accepts the input and runs the appropriate Runnable
     */
    public static void runMenu() {
        Menu.show();
        //Accept inputs for menu
        Scanner sc = new Scanner(System.in);
        Menu.run(sc.nextLine().trim().toLowerCase());
    }

    /**
     * Initialize menu options.
     * static since it caters to the static Menu variable and runs once.
     */
    public static void initializeCLI() {
        //Add Menu items using Menu#addMenuItem(String name, Runnable task)
        Menu.addMenuItem("info",()->{
            if(Hats.person.isWearing()) {
                Hat hat = Hats.person.getHat();
                System.out.println("You are wearing: " + hat.getName()+ "\n" +
                        hat.getName() +" is from " + hat.getOrigin());
                System.out.print("\nIt is used in: ");
                hat.getTypes().forEach(hatType -> System.out.print(hatType.toString().toLowerCase()+" "));
                System.out.println("settings.");
                System.out.println(hat.getInformation());
            }
            else
                System.out.println("You are not currently wearing a hat.");
        });
        Menu.addMenuItem("wear", ()->{
            Scanner sc = new Scanner(System.in);
            System.out.println("Which hat do you want to wear?");
            String hat = sc.nextLine().trim().toLowerCase();
            if(HatKeeper.getHats().containsKey(hat)) {
                Hats.person.wear(HatKeeper.getHats().get(hat));
                System.out.println("You are now wearing "+hat);
            }
            else System.out.println(hat+" is not available!");
        });
        Menu.addMenuItem("remove", ()->{
            Hats.person.setHat(null);
            Hats.person.setWearing(false);
            System.out.println("You removed your hat");
        });
        Menu.addMenuItem("exit", ()->Hats.run=false);
        Menu.addMenuItem("create", ()->{
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome to HatMaker!");
            new HatManager().makeHat();
        });
        Menu.addMenuItem("remove", ()->{
            Scanner sc = new Scanner(System.in);
            System.out.println("Which hat do you want to get rid of?");
            String hat = sc.nextLine();
            new HatManager().deleteHat(hat);
        });
        Menu.addMenuItem("list", ()->{
            System.out.println("Available hats");
            final int[] i = {0};
            HatKeeper.getHats().forEach((s, hat) -> {
                i[0]++;
                System.out.println(i[0]+". "+s);
            });
        });
    }
}
