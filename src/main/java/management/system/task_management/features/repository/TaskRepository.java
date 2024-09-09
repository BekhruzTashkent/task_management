package management.system.task_management.features.repository;

import management.system.task_management.features.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer>{

}
