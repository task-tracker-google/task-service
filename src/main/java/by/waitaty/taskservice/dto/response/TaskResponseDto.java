package by.waitaty.taskservice.dto.response;

import by.waitaty.taskservice.model.enums.TaskPriority;
import by.waitaty.taskservice.model.enums.TaskStatus;
import java.time.OffsetDateTime;
import java.util.UUID;

public record TaskResponseDto(
    UUID id,
    UUID userId,
    String title,
    String description,
    OffsetDateTime dueDate,
    TaskStatus status,
    TaskPriority priority,
    String googleEventId,
    OffsetDateTime createdAt,
    OffsetDateTime updatedAt
) {     }
