package com.aash.mangetask.manage_task.service;

import com.aash.mangetask.manage_task.dto.LoginDTO;
import com.aash.mangetask.manage_task.dto.RegisterDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    public ResponseEntity<?> register(RegisterDTO registerDTO);

    public ResponseEntity<?> login(LoginDTO loginDTO);
}
