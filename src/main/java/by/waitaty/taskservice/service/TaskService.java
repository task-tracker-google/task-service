package by.waitaty.taskservice.service;

import by.waitaty.taskservice.dto.request.CreateTaskRequestDto;
import by.waitaty.taskservice.dto.request.UpdateTaskRequestDto;
import by.waitaty.taskservice.dto.response.TaskResponseDto;
import by.waitaty.taskservice.repository.impl.TaskRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.Condition;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskResponseDto createTask(CreateTaskRequestDto dto) {
        log.info("Добавление новой задачи {}", dto);

        return taskRepository.insert(dto);
    }

    public TaskResponseDto update(UpdateTaskRequestDto dto) {
        log.info("Обновление задачи {}", dto);

        return taskRepository.update(dto);
    }

    public TaskResponseDto find(UUID id) {
        log.info("Поиск задачи с id={}", id);

        return taskRepository.find(id);
    }

    public List<TaskResponseDto> findAll() {
        log.info("Поиск всех задач");

        Condition condition = DSL.trueCondition();
        return taskRepository.findAll(condition);
    }

    public boolean delete(UUID id) {
        log.info("Удаление задачи с id={}", id);

        return taskRepository.delete(id);
    }
}
