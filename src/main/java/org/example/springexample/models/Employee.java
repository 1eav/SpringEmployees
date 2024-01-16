package org.example.springexample.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private String department;
    private BigDecimal salary;
}