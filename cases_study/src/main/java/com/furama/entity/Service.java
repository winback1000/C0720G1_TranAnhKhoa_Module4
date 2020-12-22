package com.furama.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotEmpty
    String name;
    @Positive
    int area;
    @Positive
    double cost;

    @Column(name = "max_people")
    @Positive
    int maxPeople;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "rent_type_id", referencedColumnName = "id")
    RentType rentType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_type_id", referencedColumnName = "id")
    ServiceType serviceType;

    String standard = "only available with villas and houses";

    @Column(name = "description_other_convenience")
    String descriptionOtherConvenience = "only available with villas and houses";

    @Column(name = "pool_area")
    @PositiveOrZero
    double poolArea = 0;

    @Column(name = "number_of_floor")
    @PositiveOrZero
    int numberOfFloor = 0;

    String image;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    List<Contract> contractList;

    public String getServiceCode() {
        NumberFormat nf = new DecimalFormat("0000");
        return  "DV-"+nf.format(this.id);
    }
}
