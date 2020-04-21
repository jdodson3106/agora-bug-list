package com.agoradata.agora_bug_list.utils;

import com.agoradata.agora_bug_list.model.entity.Bug;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created By Justin Dodson on Apr, 2020
 **/
public class PrioritySorter implements Comparator<Bug> {

    private final Map<String, Integer> priorities = new HashMap<>();

    public PrioritySorter() {
        priorities.put("LOW", 0);
        priorities.put("MEDIUM", 1);
        priorities.put("HIGH", 2);

    }

    @Override
    public int compare(Bug o1, Bug o2) {
        return priorities.get(o2.getPriority()).compareTo(priorities.get(o1.getPriority()));
    }
}
