package com.agoradata.agora_bug_list.service;

import com.agoradata.agora_bug_list.model.entity.Bug;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BugReportService {
    void parseCsvFile(MultipartFile file);
    List<Bug> getAllBugs();
    List<Bug> getBugsSorted(String sortValue);
}
