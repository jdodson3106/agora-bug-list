package com.agoradata.agora_bug_list.utils;

import com.agoradata.agora_bug_list.model.entity.Bug;

import java.util.Comparator;

/**
 * Created By Justin Dodson on Apr, 2020
 **/
public class SeveritySorter implements Comparator<Bug> {

    @Override
    public int compare(Bug o1, Bug o2) {
        return o1.getSeverity().compareTo(o2.getSeverity());
    }

}
