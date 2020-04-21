package com.agoradata.agora_bug_list.service;

import org.springframework.web.multipart.MultipartFile;

public interface BugReportService {
    void parseCsvFile(MultipartFile file);
}
