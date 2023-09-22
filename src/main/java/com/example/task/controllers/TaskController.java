package com.example.task.controllers;

import com.example.task.dtos.TaskRecordDto;
import com.example.task.models.TaskModel;
import com.example.task.repositories.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @PostMapping("/tasks")
    public ResponseEntity<TaskModel> saveTask(@RequestBody @Valid TaskRecordDto taskRecordDto) {
        var taskModel = new TaskModel();
        BeanUtils.copyProperties(taskRecordDto, taskModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskRepository.save(taskModel));
    }
}
