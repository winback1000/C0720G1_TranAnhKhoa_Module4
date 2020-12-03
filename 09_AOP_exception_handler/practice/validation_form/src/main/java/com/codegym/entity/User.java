package com.codegym.entity;

import com.codegym.common.Adult;
import com.codegym.common.Password;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "first_name")
            @NotNull(message = "First name can not be null")
            @Length(min = 5, max = 45, message = "First name is too short or too long")
    String firstName;

    @Column(name = "last_name")
    @NotNull(message = "Last name can not be null")
    @Length(min = 5, max = 45, message = "Last name is too short or too long")
    String lastName;

    @Column(name = "date_of_birth", columnDefinition = "DATE")
    @Adult(min = 18, max = 60, message = "You are not in the suitable age")
    String dateOfBirth;

    @NotBlank
    @Email(message = "Email must be in the right format")
    String email;

    @Password
    String password;
}
