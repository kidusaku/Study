package com.example.demo.dto;
import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

//リクエストデータ//
@Data
public class TaskRequest implements Serializable {
    /**
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