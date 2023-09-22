package com.example.task.dtos;

import jakarta.validation.constraints.NotBlank;

public record TaskDto(@NotBlank String tasks, @NotBlank String responsible, @NotBlank String observation) {
}
