package com.company.util;

import com.company.database.Storage;
import com.company.model.Group;

import java.util.Scanner;


public class CreateGroup {
    private CreateGroup() {
    }

    public static Group createGroup(){
        int pId;
        Group group = new Group(AddVariables.setGroupName());
        System.out.println("Created group with Id - " + group.getId());

        String parentId = AddVariables.addGroupParentId();
        if (!parentId.isEmpty()) {
            pId = Integer.parseInt(parentId);
            group.setParentGroup(Storage.getGroup(pId));
        }
        Storage.newGroup(group);
        return group;
    }
    public static Group createGroup1(int c){
        Group group = new Group("G");
        return group;
    }
}
