package com.consuban.investment.Objetos;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @Column(name="idProduct", unique=true, nullable=false)
    private String idProduct;

    @Column(name="productDescription", unique = false, nullable=true)
    private String productDescription;

    @Column(name="productCommercialName", unique = false, nullable=true)
    private String productCommercialName;

    @Column(name="term", unique = false, nullable = true)
    private String term;

    @Column(name="investmentProfile", unique = false, nullable = true)
    private String investmentProfile;

    @Column(name="periodsInterest", unique = false, nullable = true)
    private int periodsInterest;

    @Column(name="factor", unique = false, nullable = true)
    private int factor;

    @Column(name="interestAnnualBase", unique = false, nullable = true)
    private int interestAnnualBase;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "Isr_idIsr", referencedColumnName = "idIsr", nullable = false)
    private Isr isr;
    
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "InterestPlan_idInterestPlan", referencedColumnName = "idInterestPlan", nullable = false)
    private InterestPlan interestPlan;

    
}
