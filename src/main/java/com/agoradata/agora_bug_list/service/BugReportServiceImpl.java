package com.agoradata.agora_bug_list.service;

import com.agoradata.agora_bug_list.model.entity.Bug;
import com.agoradata.agora_bug_list.model.repository.BugRepository;
import com.agoradata.agora_bug_list.utils.*;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * BUG REPORT SERVICE TO HANDLE THE BUSINESS LOGIC AROUND CREATING BUGS,
 * PARSING THE CSV FILE, AND GETTING ALL THE BUGS IN THE SYSTEM FOR DISPLAYING
 **/

@Service
public class BugReportServiceImpl implements BugReportService{


    private static final Logger log = LoggerFactory.getLogger(BugReportService.class);
    private final SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
    private final BugRepository bugRepository;
    private final Set<String>  SORT_PARAMS;

    @Autowired
    public BugReportServiceImpl(BugRepository bugRepository) {
        this.bugRepository = bugRepository;
        this.SORT_PARAMS = new HashSet<>();
    }

    // initialize the sort_params set with data after bean construction
    @PostConstruct
    public void init() {
        this.SORT_PARAMS.add("id");
        this.SORT_PARAMS.add("title");
        this.SORT_PARAMS.add("date");
        this.SORT_PARAMS.add("severity");
        this.SORT_PARAMS.add("priority");
    }

    @Override
    public void parseCsvFile(MultipartFile file) {
        // HANDLE FORM SUBMISSION

        try {
            Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));

            CsvToBean<Bug> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Bug.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Bug> bugs = csvToBean.parse();

            bugs.forEach(bug -> {
                try {
                    bug.setCreatedDate(formatter.parse(bug.getCreatedDateString()));
                    bugRepository.save(bug);
                    log.info(bug.toString());
                } catch (ParseException pe) {
                    pe.printStackTrace();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Bug> getAllBugs() {
        List<Bug> bugs = new ArrayList<>();
        Iterable<Bug> bugIterable = bugRepository.findAll();

        bugIterable.forEach(bug -> {
            bugs.add(bug);
        });

        return bugs;
    }

    @Override
    public List<Bug> getBugsSorted(String sortValue) {
        List<Bug> bugs = new ArrayList<>();
        if(this.SORT_PARAMS.contains(sortValue)) {
            Iterable<Bug> bugIterable = bugRepository.findAll();
            bugIterable.forEach(bug -> {
                bugs.add(bug);
            });
            switch (sortValue) {
                case "id":
                    bugs.sort(new IdSorter());
                    break;
                case "title":
                    bugs.sort(new TitleSorter());
                    break;
                case "date":
                    bugs.sort(new DateSorter());
                    break;
                case "severity":
                    bugs.sort(new SeveritySorter());
                    break;
                case "priority":
                    bugs.sort(new PrioritySorter());
                    break;
                default:
                    break;
            }
        }

        return bugs;
    }

}
