package management.system.task_management.base.controller;

import management.system.task_management.features.service.TaskService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(
            TaskService taskService
    ) {
        this.taskService = taskService;
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
    public HttpEntity<?> createTask() {
        try {
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
