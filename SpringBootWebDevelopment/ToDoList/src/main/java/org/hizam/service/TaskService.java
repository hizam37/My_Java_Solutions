package org.hizam.service;

import org.hizam.entity.Task;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentSkipListSet;

public interface TaskService {

    void saveTask(Task task);

    Optional<Task> getTaskById(Long taskId);

    List<Task> getTaskList();

    Task updateTaskById(Task task,Long taskId);

    void deleteTaskById(Long taskId);

}
