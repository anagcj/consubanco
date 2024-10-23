package com.consuban.investment.Objetos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Isr",schema = "targetSchemaName")

public class Isr {

    @Id
    @Column(name="idIsr",unique = true,nullable = false)
    private String idIsr;

    @Column(name="rate",unique = false, nullable = true)
    private float rate;

    @Column(name="factor",unique = false ,nullable = true)
    private int factor;

    @Column(name="annualBase",unique = false, nullable = true)
    private int annualBase;

    @OneToOne(mappedBy = "isr")
    @JsonIgnore
    private InvestmentProduct investmentProduct;
}
