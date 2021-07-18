package com.company.database;

import com.company.model.Group;
import com.company.model.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir
 * Date: 18.07.2021.
 * Time: 10:48.
 */
public class Storage {
    private static final Map<Integer, Group> storageGroup = new HashMap<>();
    private static final Map<Integer, Item> storageItem = new HashMap<>();

    public static List<Group> getGroupList(){
        return storageGroup.values().stream().collect(Collectors.toList());
    }

    public static void addGroup(Group group){
        storageGroup.put(group.getId(),group);
    }
    public static void addItem(Item item){
        storageItem.put(item.getId(),item);
    }
    public static Group getGroup(Integer id){
        return storageGroup.get(id);
    }
    public static Item getItem(Integer id){
        return storageItem.get(id);
    }
}
