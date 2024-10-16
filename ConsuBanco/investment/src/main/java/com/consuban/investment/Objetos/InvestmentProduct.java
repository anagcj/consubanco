package com.consuban.investment.Objetos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="InvestmentProduct", schema="targetSchemaName")
public class InvestmentProduct {

    @Id
    @Column(name="idProduct", unique=true, nullable=true)
    private String idProduct;

    @Column(name="productDescription", nullable=false)
    private String productDescription;

    @Column(name="productCommercialName", nullable=false)
    private String productCommercialName;

    @Column(name="term",unique = false ,nullable = false)
    private String term;

    @Column(name="investmentProfile",unique = true,nullable = false)
    private String investmentProfile;

    @Column(name="periodsInterest",unique = false ,nullable = false)
    private int periodsInterest;

    @Column(name="factor",unique = false ,nullable = false)
    private int factor;

    @Column(name="interestAnnualBase",unique = false ,nullable = false)
    private int interestAnnualBase;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Isr_idIsr", referencedColumnName = "idIsr",nullable = false)
    private Isr isr;

    
}
