package com.example.demo.dto;
import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class TaskUpdateRequest implements Serializable {
    /**
     * タスク名
     * 本来ならばTaskRequestを継承すればOK。
     * public class TaskUpdateRequest extends TaskRequest implements Serializable {
     * でいい。
     * 今回は試しにもう一回書いてみる
     */
    
    /*
     * タスクID
     */
    @NotNull(message="IDを入れてください")
    private Integer taskId;
    
    /*
     * タスク名
     */
    @NotBlank(message = "タスク名を入力してください")
    @Size(max = 20, message = "タスク名は20文字以内で入力してください")
    private String taskName;
    /**
     * タスクの状況
     */
    @NotBlank(message = "タスクの状況を入力して下さい")
    @Size(max = 255, message = "タスク状況は20文字以内で入力してください")
    private String taskStatus;

  }
