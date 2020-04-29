package com.hasan.trainingjdbc.entity;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

    private Long employeeId;

    @Size(min = 2, max = 15, message = "lastname minimum of 2 and max of 15 character")
    private String lastName;
    private String firstName;
    private String address;
    private String city;

}