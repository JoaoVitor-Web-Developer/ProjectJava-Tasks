package com.example.task.controllers;
import com.example.task.dtos.TaskDto;
import com.example.task.models.TaskModel;
import com.example.task.repositories.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("tasks")

public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @PostMapping("/save")
    public ResponseEntity<TaskModel> saveTask(@RequestBody @Valid TaskDto taskDto) {
        var taskModel = new TaskModel();
        BeanUtils.copyProperties(taskDto, taskModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskRepository.save(taskModel));
    }

    @GetMapping("/search")
    public ResponseEntity<List<TaskModel>> getAllTasks() {
        return ResponseEntity.status(HttpStatus.OK).body(taskRepository.findAll());
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Object> getOneTask(@PathVariable(value = "id") UUID id) {
        Optional<TaskModel> task0 = taskRepository.findById(id);
        if (task0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(task0.get());
    }

    @PutMapping("/task/{id}")
    public  ResponseEntity<Object> updateTask(@PathVariable(value = "id") UUID id,
                                              @RequestBody @Valid TaskDto TaskDto) {
        Optional<TaskModel> task0 = taskRepository.findById(id);
        if (task0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }
        var TaskModel = task0.get();
        BeanUtils.copyProperties(TaskDto, TaskModel);
        return ResponseEntity.status(HttpStatus.OK).body(taskRepository.save(TaskModel));
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable(value = "id") UUID id) {
        Optional<TaskModel> task0 = taskRepository.findById(id);
        if (task0.isEmpty()) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa não encontrada");
        }
        taskRepository.delete(task0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Tarefa deletada com sucesso!");
    }
}
