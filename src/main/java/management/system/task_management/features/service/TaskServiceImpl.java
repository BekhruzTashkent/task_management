package management.system.task_management.features.service;


import management.system.task_management.base.exception.NotFoundException;
import management.system.task_management.features.model.Task;
import management.system.task_management.features.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{


    private final TaskRepository taskRepository;

    public TaskServiceImpl(
            TaskRepository taskRepository
    ) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task getTask(Integer taskId){
        return taskRepository.findById(taskId).orElseThrow(
                () -> new NotFoundException("no task with such id: " + taskId)
        );
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

}
