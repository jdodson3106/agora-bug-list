package com.agoradata.agora_bug_list.service;

import com.agoradata.agora_bug_list.model.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BugReportServiceImpl implements BugReportService{
    private final BugRepository bugRepository;

    @Autowired
    public BugReportServiceImpl(BugRepository bugRepository) {
        this.bugRepository = bugRepository;
    }



}
