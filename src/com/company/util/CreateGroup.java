package com.company.util;

import com.company.database.Storage;
import com.company.model.Group;


public class CreateGroup {
    private CreateGroup() {
    }

    public static Group createGroup() {
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

    public static Group createGroupWithParentId(String name, int parentId) {
        Group group = new Group(name);
        group.setParentGroup(Storage.getGroup(parentId));
        Storage.newGroup(group);
        return group;
    }
}
