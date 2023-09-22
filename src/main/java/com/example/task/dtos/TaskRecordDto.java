package com.example.task.dtos;

import jakarta.validation.constraints.NotBlank;

public record TaskRecordDto(@NotBlank String tasks, @NotBlank String responsible, @NotBlank String observation) {
}
