package com.consuban.investment.Objetos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name="InterestPlan",schema = "targetSchemaName")
public class InterestPlan {
  
    @Id
    @Column(name="idInterestPlan",unique = true,nullable = true)
    private String idInterestPlan;

    @Column(name="term",unique = false,nullable = false)
    private int term;

    @Column(name="amount",unique = false ,nullable = false)
    private int amount;

    @Column(name="interestRate",unique = false ,nullable = false)
    private float interestRate;


}