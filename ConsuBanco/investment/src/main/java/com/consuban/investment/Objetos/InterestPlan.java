package com.consuban.investment.Objetos;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name="InterestPlan",schema = "targetSchemaName")
public class InterestPlan {
  
    @Id
    @Column(name="idInterestPlan",unique = true, nullable = false)
    private String idInterestPlan;

    @Column(name="term", unique = false, nullable = true)
    private int term;

    @Column(name="amount", unique = false, nullable = true)
    private int amount;

    @Column(name="interestRate", unique = false, nullable = true)
    private float interestRate;

    @OneToMany(mappedBy = "interestPlan", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<InvestmentProduct> investmentProduct;


}