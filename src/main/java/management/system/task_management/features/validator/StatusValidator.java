package management.system.task_management.features.validator;

import management.system.task_management.base.exception.NotFoundException;
import management.system.task_management.features.dto.TaskDto;
import management.system.task_management.features.model.Status;

public class StatusValidator implements TaskValidator {
    @Override
    public void validator(TaskDto taskDto) {
        if (!isStatusValid(taskDto.getStatus())) {
            throw new NotFoundException("Status is not valid");
        }
    }

    private boolean isStatusValid(Status status) {
        return switch (status) {
            case OPEN, IN_PROGRESS, COMPLETED -> true;
            default -> false;
        };
    }

}