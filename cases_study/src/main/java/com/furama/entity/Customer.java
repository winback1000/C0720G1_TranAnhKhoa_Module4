package com.furama.entity;

import com.furama.common.Adult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    CustomerType customerType;

    @NotBlank(message = "The name can not be blank")
    String name;

    @Column(name = "date_of_birth", columnDefinition = "DATE")
    @Adult(min = 18, max = 100, message = "The age must be between 18 and 100")
    String dateOfBirth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gender_id", referencedColumnName = "id")
    Gender gender;

    @Column(name = "id_card")
    @Pattern(regexp = "\\d{9}", message = "The ID card must contains 9 digitals")
    String idCard;

    @Pattern(regexp = "(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}", message = "The phone number must be started with 090, 091, (84)+90, (84)+91 and 7 digits")
    String phone;
    @Email
    String email;
    String address;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<Contract> contractList;
    public String getCustomerCode() {
        NumberFormat nf = new DecimalFormat("0000");
        return  "EP-"+nf.format(this.id);
    }
}
