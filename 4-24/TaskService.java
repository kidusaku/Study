package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TaskMapper;
import com.example.demo.dto.TaskRequest;
import com.example.demo.dto.TaskUpdateRequest;
import com.example.demo.entity.TaskEntity;

/**
 * タスク情報 Service
 */
@Service

public class TaskService {

    @Autowired
    private TaskMapper taskMapper;

    // タスク一覧//
    public List<TaskEntity> searchAll() {
        return taskMapper.findAll();
    }

    // タスク詳細//
    public TaskEntity findById(Integer taskId) {
        return taskMapper.getOne(taskId);
    }

    // タスク登録//
    public void create(TaskRequest taskRequest) {
        Date now = new Date();
        TaskEntity task = new TaskEntity();
        task.setTaskName(taskRequest.getTaskName());
        task.setTaskStatus(taskRequest.getTaskStatus());
        task.setStartDate(now);
        taskMapper.taskSave(task);
    }

    //タスク更新//
    public void update(TaskUpdateRequest taskupdateRequest) {

        System.out.println("update id = " + taskupdateRequest.getTaskId());

        TaskEntity task = findById(taskupdateRequest.getTaskId());
        System.out.println("entity = " + task);

        task.setTaskName(taskupdateRequest.getTaskName());
        task.setTaskStatus(taskupdateRequest.getTaskStatus());
        taskMapper.taskUpdate(task);
    }

    //タスク消去//
    public void delete(Integer Id) {
        TaskEntity task = findById(Id);
        taskMapper.taskDelete(task);
    }

    //タスク終了//
    public void end(Integer Id) {
        TaskEntity task = findById(Id);
        Date now = new Date();
        task.setEndDate(now);
        taskMapper.taskEnd(task);
    }
}