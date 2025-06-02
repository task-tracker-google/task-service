package by.waitaty.taskservice.dto.request;

import by.waitaty.taskservice.model.enums.TaskPriority;
import java.time.OffsetDateTime;
import java.util.UUID;

public record CreateTaskRequestDto(
    UUID userId,
    String title,
    String description,
    OffsetDateTime dueDate,
    TaskPriority priority
) {}
