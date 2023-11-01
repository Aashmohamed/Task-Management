package com.aash.mangetask.manage_task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterTaskDTO {
    private String title;
    private String description;
    private LocalDate dueAt;
}
