package com.agoradata.agora_bug_list.service;

import com.agoradata.agora_bug_list.model.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * BUG REPORT SERVICE TO HANDLE THE BUSINESS LOGIC AROUND CREATING BUGS,
 * PARSING THE CSV FILE, AND GETTING ALL THE BUGS IN THE SYSTEM FOR DISPLAYING
 **/

@Service
public class BugReportServiceImpl implements BugReportService{
    private final BugRepository bugRepository;

    @Autowired
    public BugReportServiceImpl(BugRepository bugRepository) {
        this.bugRepository = bugRepository;
    }

    @Override
    public void parseCsvFile(MultipartFile file) {
        // HANDLE FORM SUBMISSION
    }
}
