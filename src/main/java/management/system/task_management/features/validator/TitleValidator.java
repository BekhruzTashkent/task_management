package management.system.task_management.features.validator;

import management.system.task_management.base.exception.NotFoundException;
import management.system.task_management.features.dto.TaskDto;
import org.apache.coyote.BadRequestException;

public class TitleValidator implements TaskValidator {
    @Override
    public void validator(TaskDto taskDto) {
        if (taskDto.getTitle().isEmpty() || taskDto.getTitle().isBlank()) {
            throw new NotFoundException("Title is not valid");
        }
    }
}