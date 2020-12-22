package com.furama.entity;

import com.furama.common.ValidDuration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ValidDuration
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "start_date", columnDefinition = "DATE")
//    @FutureOrPresent
    String startDate;
    @Column(name = "end_date", columnDefinition = "DATE")
//    @Future
    String endDate;

    @PositiveOrZero
    double deposit;
//    @Column(name = "total_money")
//    double totalMoney;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    Service service;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contract")
    List<ContractDetail> contractDetailList = new ArrayList<>();

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }

    public int getAttachServiceQuantity() {
        int count = 0;
        if (contractDetailList.size() == 0) {
            return count;
        } else {
            for (ContractDetail contractDetail : contractDetailList) {
                count = count + contractDetail.getQuantity();
            }
        }
        return count;
    }

    public double getTotalCost() {
        LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ISO_LOCAL_DATE);
        long days = DAYS.between(start, end);
        double attachServiceCost = 0;
        double serviceCost = 0;
        if (contractDetailList.size() == 0) {
            attachServiceCost = 0;
        } else {
            for (ContractDetail contractDetail : contractDetailList) {
                attachServiceCost = attachServiceCost + (contractDetail.getAttachService().getCost() * contractDetail.getQuantity());
            }
        }
        if (this.service == null) {
            serviceCost = 0;
        } else {
            serviceCost = this.service.getCost() * this.service.getRentType().getCost() * days;
        }
        return serviceCost + attachServiceCost;
    }
    public void addContractDetail ( ContractDetail contractDetail){
        this.contractDetailList.add(contractDetail);
    }
}
