package management.system.task_management.features.service;


import management.system.task_management.features.dto.TaskDto;
import management.system.task_management.features.model.Task;

import java.util.List;


public interface TaskService {

     List<Task> getAllTasks();

     Task createTask(TaskDto taskDto);

     Task updateTask(Integer taskId, TaskDto taskDto);


}
