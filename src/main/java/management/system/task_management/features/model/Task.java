package management.system.task_management.features.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "task")
public class Task {

    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "task_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;

    private String title;

    @Column
    private String description;

    private LocalDateTime dueDate;

    @Enumerated(EnumType.STRING)
    private Status status;


}
