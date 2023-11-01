package com.aash.mangetask.manage_task.service;

import com.aash.mangetask.manage_task.dto.UpdateRequestDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> update(UpdateRequestDTO updateRequestDTO);

    ResponseEntity<?> delete();

    ResponseEntity<?> loadUsers();
}
