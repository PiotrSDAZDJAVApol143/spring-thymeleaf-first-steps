package com.example.thymeleafworkshop.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @NotEmpty(message = "Pole nie moze byc puste")
    private String title;
    @NotNull
    private String author;

}
