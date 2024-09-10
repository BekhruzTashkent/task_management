package management.system.task_management.features.dto;


import lombok.Data;
import management.system.task_management.features.model.Status;

import java.time.LocalDateTime;

@Data
public class TaskDto {

    private String title;
    private String description;
    private LocalDateTime dueDate;
    private Status status;


}
