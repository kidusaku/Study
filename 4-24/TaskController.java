package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.TaskRequest;
import com.example.demo.dto.TaskUpdateRequest;
import com.example.demo.entity.TaskEntity;
import com.example.demo.service.TaskService;

//  タスク情報 Controller //
@Controller

public class TaskController {
    @Autowired
    TaskService taskService;

    // ==========================================
    /*
     * タスク一覧を表示 returnはViewに返すURL。これを表示してくれと頼む。中身入り
     */

    @GetMapping("/task/list")
    public String taskList(Model model) {
        List<TaskEntity> tasklist = taskService.searchAll();
        model.addAttribute("tasklist", tasklist);
        return "task/list";
    }

    // ==========================================
    /*
     * タスクの詳細 taskIdにちゃんとすること！
     */

    @GetMapping("/task/{taskId}")
    public String taskDate(@PathVariable Integer taskId, Model model) {
        TaskEntity task = taskService.findById(taskId);
        model.addAttribute("taskDate", task);
        return "task/view";
    }

    // ==========================================
    /**
     * 新規タスク登録画面を表示 登録処理じゃなくて登録画面の表示
     */
    @GetMapping("/task/add")
    public String taskRegister(Model model) {
        model.addAttribute("taskRequest", new TaskRequest());
        return "task/add";
    }

        /*
         * 実際にタスクを登録する処理のところ
         */
        @PostMapping("/task/create")
        public String taskCreate(@Validated @ModelAttribute TaskRequest taskRequest, BindingResult result, Model model) {
            if (result.hasErrors()) {
                List<String> errorList = new ArrayList<String>();
                for (ObjectError error : result.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
                }
                model.addAttribute("validationError", errorList);
                return "task/add";
            }
            // タスクの登録（ユーザーに返さなくていいところ）
            taskService.create(taskRequest);
            return "redirect:/task/list";
        }

    // ==========================================
    /**
     * タスク編集画面を表示（登録画面じゃない）
     */
    @GetMapping("/task/{id}/edit")
    public String taskEdit(@PathVariable Integer id, Model model) {
        /**
         * タスク情報を取得
         */
        TaskEntity task = taskService.findById(id);
        TaskUpdateRequest taskUpdateRequest = new TaskUpdateRequest();
        taskUpdateRequest.setTaskId(task.getTaskId());
        taskUpdateRequest.setTaskName(task.getTaskName());
        taskUpdateRequest.setTaskStatus(task.getTaskStatus());
        model.addAttribute("taskUpdateRequest", taskUpdateRequest);
        return "task/edit";
    }

        /**
         * タスク更新
         */
        @RequestMapping("/task/update")
        public String taskUpdate(@Validated @ModelAttribute TaskUpdateRequest taskUpdateRequest, BindingResult result,
                Model model) {
            if (result.hasErrors()) {
                List<String> errorList = new ArrayList<String>();
                for (ObjectError error : result.getAllErrors()) {
                    errorList.add(error.getDefaultMessage());
                }
                model.addAttribute("validationError", errorList);
                return "task/edit";
        }
        // タスクの更新（ユーザーに返さなくていいところ）
        taskService.update(taskUpdateRequest);
        return String.format("redirect:/task/%d", taskUpdateRequest.getTaskId());
    }

    // ==========================================
    /**
     * タスク削除
     */
    @GetMapping("/task/{id}/delete")
    public String taskDelete(@PathVariable Integer id, Model model) {
        // タスク情報の削除
        taskService.delete(id);
        return "redirect:/task/list";
    }

    // ==========================================
    /**
     * タスク終了
     */
    @GetMapping("/task/{id}/end")
    public String taskEnd(@PathVariable Integer id, Model model) {
        taskService.end(id);
        return "redirect:/task/list";
    }
}
