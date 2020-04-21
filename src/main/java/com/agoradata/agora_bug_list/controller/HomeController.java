package com.agoradata.agora_bug_list.controller;

import com.agoradata.agora_bug_list.service.BugReportService;
import com.agoradata.agora_bug_list.service.BugReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * MAIN CONTROLLER OF THE PROJECT TO DISPLAY THE BUGS TO THE USER
 **/
@Controller
@RequestMapping("/")
public class HomeController {

    private final BugReportService bugReportService;

    @Autowired
    public HomeController(BugReportServiceImpl bugReportService) {
        this.bugReportService = bugReportService;
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        return "home";
    }
}
