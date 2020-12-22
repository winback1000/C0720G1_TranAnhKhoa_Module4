package com.codegym.entity;

import com.codegym.common.CheckDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.text.DecimalFormat;
import java.text.NumberFormat;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Purchasing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "purchase_date", columnDefinition = "DATE")
    @NotEmpty
    @CheckDate
    String purchaseDate;
    @Column(name = "service_type")
    @NotEmpty
    String serviceType;

    @Min(500000)
    long price;

    @Min(20)
    int area;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    Customer customer;

    public String getPurchasingCode() {
        NumberFormat nf = new DecimalFormat("0000");
        return  "MGD-"+nf.format(this.id);
    }
}
