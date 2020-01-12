package com.xuxe.hats.cli;

import com.xuxe.hats.HatKeeper;
import com.xuxe.hats.Hats;
import com.xuxe.hats.pojos.Hat;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

public class CLI {
    public static void runMenu() {
        Menu.show();
        Scanner sc = new Scanner(System.in);
        Menu.run(sc.nextLine().trim().toLowerCase());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void initializeCLI() {
        initMenu();
    }
    private static void initMenu() {
        Menu.addMenuItem("info",()->{
            if(Hats.person.isWearing())
                System.out.println(Hats.person.getHat());
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
    }
}
