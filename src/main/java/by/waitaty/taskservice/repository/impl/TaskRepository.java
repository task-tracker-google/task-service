package by.waitaty.taskservice.repository.impl;

import by.waitaty.taskservice.dto.request.CreateTaskRequestDto;
import by.waitaty.taskservice.dto.request.UpdateTaskRequestDto;
import by.waitaty.taskservice.exception.EntityNotFoundException;
import by.waitaty.taskservice.model.domain.tables.Tasks;
import by.waitaty.taskservice.dto.response.TaskResponseDto;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TaskRepository {
    private final DSLContext dsl;

    public TaskResponseDto insert(CreateTaskRequestDto task) {
        return dsl.insertInto(Tasks.TASKS)
            .set(dsl.newRecord(Tasks.TASKS, task))
            .returning()
            .fetchOptional()
            .orElseThrow(() -> new DataAccessException("Ошибка вставки сущности: " + task))
            .into(TaskResponseDto.class);
    }

    public TaskResponseDto update(UpdateTaskRequestDto task) {
        return dsl.update(Tasks.TASKS)
            .set(dsl.newRecord(Tasks.TASKS, task))
            .where(Tasks.TASKS.ID.eq(task.id()))
            .returning()
            .fetchOptional()
            .orElseThrow(() -> new DataAccessException("Ошибка обновления сущности: " + task.id()))
            .into(TaskResponseDto.class);
    }

    public TaskResponseDto find(UUID id) {
        return dsl.selectFrom(Tasks.TASKS)
            .where(Tasks.TASKS.ID.eq(id))
            .fetchOptional()
            .orElseThrow(() -> new EntityNotFoundException("Задачи не найдена с id: " + id))
            .into(TaskResponseDto.class);
    }

    public List<TaskResponseDto> findAll(Condition condition) {
        return dsl.selectFrom(Tasks.TASKS)
            .where(condition)
            .fetch()
            .map(r -> r.into(TaskResponseDto.class));
    }

    public Boolean delete(UUID id) {
        return dsl.deleteFrom(Tasks.TASKS)
            .where(Tasks.TASKS.ID.eq(id))
            .execute() == 1;
    }
}
