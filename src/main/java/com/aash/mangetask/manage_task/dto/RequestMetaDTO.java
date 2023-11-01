package com.aash.mangetask.manage_task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestMetaDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
