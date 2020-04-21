package com.agoradata.agora_bug_list.model.entity;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * BASIC POJO ENTITY FOR CREATING THE BUGS
 **/

@Entity
public class Bug {
    @CsvBindByName(column = "Id")
    @Id
    private long id;

    @CsvBindByName(column = "Title")
    private String title;

    @CsvBindByName(column = "Created")
    private Date createdDate;

    @CsvBindByName(column = "Severity")
    private int severity;

    @CsvBindByName(column = "Priority")
    private String priority;

    public Bug() {
    }

    public Bug(long id, String title, Date createdDate, int severity, String priority) {
        this.id = id;
        this.title = title;
        this.createdDate = createdDate;
        this.severity = severity;
        this.priority = priority;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
