package com.agoradata.agora_bug_list.controller;

import com.agoradata.agora_bug_list.service.BugReportService;
import com.agoradata.agora_bug_list.service.BugReportServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * MAIN CONTROLLER OF THE PROJECT TO DISPLAY THE BUGS TO THE USER
 **/
@Controller
@RequestMapping("/")
public class HomeController {
    public static final Logger log = LoggerFactory.getLogger(HomeController.class);

    private final BugReportService bugReportService;

    @Autowired
    public HomeController(BugReportServiceImpl bugReportService) {
        this.bugReportService = bugReportService;
    }

    @GetMapping("/")
    public String getIndex(Model model, HttpServletRequest request) {
        Map<String, ?> inputMessages = RequestContextUtils.getInputFlashMap(request);
        if(inputMessages != null) {
            model.addAttribute("error", inputMessages.get("ERROR"));
        }

        model.addAttribute("bugs", bugReportService.getAllBugs());
        return "home";
    }

    @PostMapping("/processFileUpload")
    public String processFileUpload(@RequestParam("file") MultipartFile file, Model model, RedirectAttributes attributes) {
        if(file.isEmpty()) {
            log.error("No file uploaded");
            attributes.addFlashAttribute("ERROR", "Please select a CSV file to upload");
        } else {
            bugReportService.parseCsvFile(file);
        }

        return "redirect:/";
    }
}
