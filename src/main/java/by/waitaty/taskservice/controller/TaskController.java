package by.waitaty.taskservice.controller;

import by.waitaty.taskservice.dto.request.CreateTaskRequestDto;
import by.waitaty.taskservice.dto.request.UpdateTaskRequestDto;
import by.waitaty.taskservice.dto.response.TaskResponseDto;
import by.waitaty.taskservice.service.TaskService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public final TaskResponseDto create(@RequestBody CreateTaskRequestDto dto) {
        return taskService.createTask(dto);
    }

    @GetMapping("/{id}")
    public final TaskResponseDto find(@PathVariable UUID id) {
        return taskService.find(id);
    }

    @PutMapping
    public final TaskResponseDto update(@RequestBody UpdateTaskRequestDto dto) {
        return taskService.update(dto);
    }

    @DeleteMapping("/{id}")
    public final boolean delete(@PathVariable UUID id) {
        return taskService.delete(id);
    }

    @GetMapping
    public final List<TaskResponseDto> findAll() {
        return taskService.findAll();
    }

}
