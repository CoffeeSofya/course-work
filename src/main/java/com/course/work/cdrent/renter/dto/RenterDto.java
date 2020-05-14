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
    @Positive
//    @Size(max = 10)
    private Integer numRenter;
    @NotNull
    @NotBlank(message = "Введите ФИО")
    private String fullName;
    @NotNull
    @Pattern(regexp = "\\+7[0-9]{10}", message = "Телефонный номер должен начинаться с +7, затем - 10 цифр")
    private String tel;
    @Email
    private String email;

}
