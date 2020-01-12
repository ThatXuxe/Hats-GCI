package com.xuxe.hats;

import com.xuxe.hats.cli.CLI;
import com.xuxe.hats.pojos.Person;

import java.util.Scanner;

public class Hats {
    public static boolean run;
    public static Person person;
    public static void main(String[] args) {
        person = new Person();
        CLI.initializeCLI();
        run = true;
        while (run) {
            CLI.runMenu();
        }
    }
}

