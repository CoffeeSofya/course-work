package com.course.work.cdrent.renter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RenterDto {
    @NotNull
    private Integer numRenter;

    @NotNull
//    @Min(5)
    @NotBlank(message = "Введите ФИО")
    private String fullName;
    @NotNull
    @NotBlank(message = "Введите номер телефона в формате\"8XXXXXXXXXX\"")
//    @Size(max = 11, min = 11)
    private String tel;
//    @Email
    private String email;

}
