package management.system.task_management.features.validator;

import management.system.task_management.features.dto.TaskDto;

@FunctionalInterface
public interface TaskValidator {

    void validator(TaskDto taskDto);

}