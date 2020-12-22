package com.furama.entity;

import com.furama.common.Adult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotBlank(message = "The name can not be blank")
    String name;

    @Column(name = "date_of_birth", columnDefinition = "DATE")
    @Adult(min = 18, max = 100, message = "The age must be between 18 and 100")
    @DateTimeFormat(pattern = "DD/MM/YYYY")
    String dateOfBirth;

    @Column(name = "id_card")
            @Pattern(regexp = "\\d{9}", message = "The ID card must contains 9 digitals")
    String idCard;
    @Positive( message = "The salary must be positive")
    double salary;
    @Pattern(regexp = "(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}", message = "The phone number must be started with 090, 091, (84)+90, (84)+91")
    String phone;
    @Email
    String email;
    String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    Position position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "education_degree_id")
    EducationDegree educationDegree;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "division_id")
    Division division;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    Account account;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    List<Contract> contractList;

    public String getEmployeeCode() {
        NumberFormat nf = new DecimalFormat("0000");
        return  "EP-"+nf.format(this.id);
    }
}
