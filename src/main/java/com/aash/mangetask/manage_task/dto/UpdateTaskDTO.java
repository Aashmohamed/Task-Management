package com.aash.mangetask.manage_task.dto;

import com.aash.mangetask.manage_task.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTaskDTO {
    private String title;
    private String description;
    private LocalDate dueAt;
    private Status status;
}
