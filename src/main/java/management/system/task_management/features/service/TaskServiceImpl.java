package management.system.task_management.features.service;


import jakarta.transaction.Transactional;
import management.system.task_management.base.exception.NotFoundException;
import management.system.task_management.features.dto.TaskDto;
import management.system.task_management.features.model.Status;
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
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    @Override
    @Transactional
    public Task createTask(TaskDto taskDto){
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setDueDate(taskDto.getDueDate());
        task.setStatus(Status.OPEN);
        return taskRepository.save(task);
    }


    @Override
    public Task updateTask(Integer taskId, TaskDto taskDto){
        Task task = taskRepository.findById(taskId).orElseThrow(
                () -> new NotFoundException("no such task with this id: "+ taskId)
        );

        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setDueDate(taskDto.getDueDate());
        task.setStatus(taskDto.getStatus());

        return taskRepository.save(task);

    }

    public void convertWordToPDF() {

    }

    public void deleteTask(Integer taskId){
        taskRepository.deleteById(taskId);
    }

}
