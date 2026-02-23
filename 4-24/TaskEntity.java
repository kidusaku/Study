package com.example.demo.entity;

import java.util.Date;

import lombok.Data;



/**
 * タスク情報
 */
@Data
public class TaskEntity {

    private Integer taskId;
    private String taskName;
    private String taskStatus;
    private Date startDate;
    private Date endDate;

}