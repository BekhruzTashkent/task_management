package management.system.task_management.features.service;


import management.system.task_management.features.model.Task;

import java.util.List;


public interface TaskService {

     Task getTask(Integer taskId);

     List<Task> getAllTasks();


}
