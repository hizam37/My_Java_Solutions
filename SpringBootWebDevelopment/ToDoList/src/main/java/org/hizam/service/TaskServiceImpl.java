package org.hizam.service;
import org.hizam.entity.Task;
import org.hizam.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;


    @Override
    public List<Task> getTaskList() {
        List<Task> taskList = (List<Task>) taskRepository.findAll();
        return Collections.synchronizedList(taskList);
    }

    @Override
    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public Optional<Task> getTaskById(Long taskId) {
        return taskRepository.findById(taskId);
    }

    @Override
    public Task updateTaskById(Task task, Long taskId) {

        Task taskData = taskRepository.findById(taskId).get();

        taskData.setDone(task.isDone());

        if(Objects.nonNull(task.getDescription()))
        {

            taskData.setDescription(task.getDescription());

        }

        if(Objects.nonNull(task.getTitle()))
        {

            taskData.setTitle(task.getTitle());

        }

        return taskRepository.save(taskData);
    }

    @Override
    public void deleteTaskById(Long taskId) {
        taskRepository.deleteById(taskId);
    }

}
