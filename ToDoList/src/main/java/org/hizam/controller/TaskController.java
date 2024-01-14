package org.hizam.controller;

import org.hizam.entity.Task;
import org.hizam.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;


    @PostMapping(path = "/tasks")
    public ResponseEntity<Task> saveTask(Task task) {

        taskService.saveTask(task);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(path = "/tasks")
    public List<Task> getAllTasks() {

        return taskService.getTaskList();
    }

    @GetMapping(path = "/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long taskId) {

        Optional<Task> task = taskService.getTaskById(taskId);

        return task.map(value -> ResponseEntity.ok((Task) value)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PatchMapping(path = "/tasks/{id}")
    public ResponseEntity<Task> updateTaskById(@RequestBody Task task,
                                               @PathVariable("id") Long taskId) {
        try {

            Task tableExit = taskService.updateTaskById(task, taskId);

            return ResponseEntity.ok(tableExit);

        } catch (NoSuchElementException e) {

            return ResponseEntity.notFound().build();

        }
    }

    @DeleteMapping(path = "/tasks/{id}")
    public ResponseEntity<Task> deleteTaskById(@PathVariable("id") Long taskId) {

        Optional<Task> task = taskService.getTaskById(taskId);

        if (task.isPresent()) {

            taskService.deleteTaskById(taskId);

        } else {

            return ResponseEntity.notFound().build();

        }
        return null;
    }

}
