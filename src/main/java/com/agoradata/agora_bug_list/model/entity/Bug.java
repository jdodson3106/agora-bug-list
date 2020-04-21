package com.agoradata.agora_bug_list.model.entity;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * BASIC POJO ENTITY FOR CREATING THE BUGS
 **/

@Entity
public class Bug {
    @Transient
    private final SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");

    @CsvBindByName(column = "Id")
    @Id
    private Long id;

    @CsvBindByName(column = "Title")
    private String title;

    @CsvBindByName(column = "Created")
    private String createdDateString;
    private Date createdDate;

    @CsvBindByName(column = "Severity")
    private Integer severity;

    @CsvBindByName(column = "Priority")
    private String priority;

    public Bug() {
    }

    public Bug(Long id, String title, String createdDate, Integer severity, String priority) throws ParseException {
        this.id = id;
        this.title = title;
        this.createdDateString = createdDate;
        this.severity = severity;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedDateString() {
        return createdDateString;
    }

    public void setCreatedDateString(String createdDateString) {
        this.createdDateString = createdDateString;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getSeverity() {
        return severity;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Bug{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createdDateSting= '" + createdDateString + '\''+
                ", createdDate= '" + formatter.format(createdDate) + '\''+
                ", severity=" + severity +
                ", priority='" + priority + '\'' +
                '}';
    }
}
