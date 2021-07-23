package com.company.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir
 * Date: 17.07.2021.
 * Time: 12:19.
 */
public class Group {
    private static int idGeneration = 0;
    private static int space = 0;

    private int id;
    private String name;
    private Group parentGroup;
    private List<Group> subGroups;
    private List<Item> items;


    public Group(String name) {
        id = ++idGeneration;
        this.name = name;
        this.parentGroup = null;
        subGroups = new ArrayList<Group>();
        items = new ArrayList<Item>();
    }

    public void addSubGroup(Group child) {
        subGroups.add(child);
        child.setParentGroup(this);
    }
    public void addItem(Item item){
        items.add(item);
        item.setGroup(this);
    }

    public void printContent() {
        System.out.println(name);
        if (subGroups.size() == 0 && items.size() == 0) {
            return;
        }
        space++;
        for (int i = 0; i < items.size(); i++) {
            printSpace();
            System.out.println(items.get(i).getName() + "  " + items.get(i).getFinalPrice() + "  " + items.get(i).getComplexity() );
        }
        for (int i = 0; i < subGroups.size(); i++) {
            printSpace();
            Group group = subGroups.get(i);
            group.printContent();
            space--;
        }
    }

    private static void printSpace() {
        for (int i = 0; i <= space; i++) {
            System.out.print(" ");
        }
        System.out.print("-");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getParentGroup() {
        return parentGroup;
    }

    public void setParentGroup(Group parentGroup) {
        this.parentGroup = parentGroup;
    }

    public List<Group> getsubGroups() {
        return subGroups;
    }

    public void setsubGroups(List<Group> subGroups) {
        this.subGroups = subGroups;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
