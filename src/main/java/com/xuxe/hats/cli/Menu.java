package com.xuxe.hats.cli;

import javax.swing.tree.TreeNode;
import java.util.HashMap;

public class Menu {
    private static HashMap<String, MenuItem> menu;

    public static void show() {
        System.out.println("-==/ Menu \\==-");
        Menu.menu.forEach((s, menuItem) -> System.out.println("_/\\_ "+menuItem.name));
    }
    public static void addMenuItem(MenuItem item) {
        menu.put(item.name,item);
    }
    public static void addMenuItem(String name, Runnable task) {
        addMenuItem(new MenuItem(name,task));
    }

    public static void run(String name) {
        menu.get(name).task.run();
    }

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
