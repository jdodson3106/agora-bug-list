package com.agoradata.agora_bug_list.controller;

import com.agoradata.agora_bug_list.model.entity.Bug;
import com.agoradata.agora_bug_list.service.BugReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BugsRestController {

    private final BugReportService bugReportService;

    @Autowired
    public BugsRestController(BugReportService bugReportService) {
        this.bugReportService = bugReportService;
    }

    @GetMapping("/bugs")
    public List<Bug> allBugs(@RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy) {
        return bugReportService.getBugsSorted(sortBy);
    }

}
