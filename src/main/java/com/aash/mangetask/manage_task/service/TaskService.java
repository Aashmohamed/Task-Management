package com.aash.mangetask.manage_task.service;

import com.aash.mangetask.manage_task.dto.RegisterTaskDTO;
import com.aash.mangetask.manage_task.dto.UpdateTaskDTO;
import org.springframework.http.ResponseEntity;

public interface TaskService{
    ResponseEntity<?> save(RegisterTaskDTO registerTaskDTO);

    ResponseEntity<?> loadTasks();

    ResponseEntity<?> update(Long id, UpdateTaskDTO updateTaskDTO);

    ResponseEntity<?> delete(Long id);
}
