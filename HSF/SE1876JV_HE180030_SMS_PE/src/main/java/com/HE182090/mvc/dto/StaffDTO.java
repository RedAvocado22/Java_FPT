package com.HE182090.mvc.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StaffDTO {

    private Long id;
    @NotNull
    @Length(min = 1, max = 50)
    private String name;

    @Min(18)
    @Max(99)
    private int age;

    @Length(max = 100)
    private String address;

    private String department;
}
