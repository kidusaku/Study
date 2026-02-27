package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.TaskEntity;

/**
 * タスク情報 Mapper
 */
@Mapper
public interface TaskMapper {
    
    //タスク情報の全検索//
    List<TaskEntity> findAll();
    
    /**
     *タスク情報 主キー検索
     * @param Taskid タスクID
     * @return
     */
     TaskEntity getOne (Integer taskId) ;
       
     //タスクの追加//
     void taskSave (TaskEntity task) ;
     
     //タスクの更新//
     void taskUpdate (TaskEntity task) ;
     
     // タスク削除//
      void taskDelete(TaskEntity task);
      
     // タスク終了//
      void taskEnd(TaskEntity task);   
}