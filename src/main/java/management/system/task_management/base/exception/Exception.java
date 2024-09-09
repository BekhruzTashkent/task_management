package management.system.task_management.base.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class Exception extends RuntimeException{
    public void Forbidden(String message) {
    }
}
