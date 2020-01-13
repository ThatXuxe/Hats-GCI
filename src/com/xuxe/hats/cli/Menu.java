package com.xuxe.hats.cli;

import java.util.HashMap;

/**
 * Main menu class used to access and manipulate the menu.
 */
public class Menu {
    /**
     * static menu variable which remains constant throughout the life
     */
    private static HashMap<String, MenuItem> menu = new HashMap<>();

    /**
     * Display Menu Items
     */
    public static void show() {
        System.out.println("-==/ Menu \\==-");
        Menu.menu.forEach((s, menuItem) -> System.out.println("_/\\_ "+menuItem.name));
    }

    /**
     * Adds a menu item to the list
     * @param item MenuItem object to be added
     */
    public static void addMenuItem(MenuItem item) {
        menu.put(item.name,item);
    }

    /**
     * Adds a menu item to the list
     * @param name Name of menu item
     * @param task Runnable task
     */
    public static void addMenuItem(String name, Runnable task) {
        addMenuItem(new MenuItem(name,task));
    }

    /**
     * Runs the specified task
     * @param name Menu Item name
     */
    public static void run(String name) {
        if(menu.containsKey(name))
            menu.get(name).task.run();
        else
            System.out.println("Incorrect option");
    }

    /**
     * MenuItem class containing a name, id and assigned Runnable task.
     * It is used to represent objects in the CLI Menu using polymorphism.
     */
    public static class MenuItem {
        String name;
        int id = menu.size()+1;
        Runnable task;
        public MenuItem setName(String name) {
            this.name = name;
            return this;
        }
        public MenuItem setTask(Runnable task) {
            this.task = task;
            return this;
        }
        public MenuItem(String name, Runnable task) {
            this.task = task;
            this.name = name;
        }

    }
}
