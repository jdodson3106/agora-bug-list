package com.agoradata.agora_bug_list.utils;

import com.agoradata.agora_bug_list.model.entity.Bug;

import java.util.Comparator;

/**
 * Created By Justin Dodson on Apr, 2020
 **/
public class IdSorter implements Comparator<Bug> {
    @Override
    public int compare(Bug o1, Bug o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
