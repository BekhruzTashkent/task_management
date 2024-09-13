package management.system.task_management.base.controller;

import management.system.task_management.features.dto.TaskDto;
import management.system.task_management.features.service.TaskService;
import management.system.task_management.features.validator.TaskValidator;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;
    private final List<TaskValidator> taskValidator;

    public TaskController(
            TaskService taskService, List<TaskValidator> taskValidator
    ) {
        this.taskService = taskService;
        this.taskValidator = taskValidator;
    }

    @GetMapping
    public HttpEntity<?> getTasks(
    ) {
        try {
            return ResponseEntity.ok(taskService.getAllTasks());
        } catch (Exception e) {
            return ResponseEntity.status(
                    HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public HttpEntity<?> createTask(@RequestBody TaskDto taskDto) {
        try {
            taskValidator.forEach(taskValidator1 -> taskValidator1.validator(taskDto));
            return null;
        } catch (Exception e) {
            return ResponseEntity.status(
                    HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/{taskId}")
    public HttpEntity<?> updateTask(
            @PathVariable Integer id
    ){
        try {
            return null;
        }catch (Exception e){
            return ResponseEntity.status(
                    HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{taskId}")
    public HttpEntity<?> deleteTask(
            @PathVariable Integer id
    ){
        try {
            return null;
        }catch (Exception e){
            return ResponseEntity.status(
                    HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
