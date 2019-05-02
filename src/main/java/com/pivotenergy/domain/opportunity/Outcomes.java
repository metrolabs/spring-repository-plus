package com.pivotenergy.domain.opportunity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@SuppressWarnings("unused")
@Embeddable
@NoArgsConstructor
public class Outcomes {
    @Column(name = "gross_cost")
    private Double grossCost;

    @Column(name = "incentive_direct")
    private Double incentiveDirect;

    @Column(name = "incentive_percent")
    private Double incentivePercent;

    /**
     * Cost after incentives have been subtracted
     */
    @Column(name = "net_cost")
    private Double netCost;

    @Column(name = "energy_cost_reduction")
    private Double energyCostReduction;

    @Column(name = "energy_consumption_reduction")
    private Double energyConsumptionReduction;

    @Column(name = "peak_energy_consumption_reduction")
    private Double peakConsumptionReduction;

    @Column(name = "emissions_reduction")
    private Double emissionsReduction;

    @Column(name = "payback_years")
    private Integer paybackYears;

    @Column(name = "electric_price_kwh")
    private Double electricPriceKwh;

    @Column(name = "electric_co2_kwh")
    private Double electricEmissionsPerKwh;

    @Embedded
    private PerformanceImpactType performanceImpact;

    @Embedded
    private InfrastructureImpactType infrastructureImpact;

    @Embedded
    private TenantImpactType tenantImpact;

    @Embedded
    private HealthFactorType healthFactor;

    @Embedded
    private RiskMetrics riskMetrics;

    @Embedded
    private Financial financial;

    /**
     *
     * @param grossCost gross cost
     * @param incentiveDirect incentives
     * @param incentivePercent incentive percent
     * @param netCost new cost
     * @param energyCostReduction cost reduction
     * @param energyConsumptionReduction consumption reduction
     * @param peakConsumptionReduction peak consumption reduction
     * @param emissionsReduction emissions reduction
     * @param paybackYears simple pay back years
     * @param electricPriceKwh electric prince per kWh
     * @param electricEmissionsPerKwh electric emissions kg/kWh
     * @param performanceImpact performance impact
     * @param infrastructureImpact infrastructure impact
     * @param tenantImpact tenant impact
     * @param healthFactor health impact factors
     * @param riskMetrics building risk accounting for interactive effects
     * @param financial financial out comes
     */
    public Outcomes(Double grossCost, Double incentiveDirect, Double incentivePercent,
                    Double netCost, Double energyCostReduction, Double energyConsumptionReduction,
                    Double peakConsumptionReduction, Double emissionsReduction, Integer paybackYears,
                    Double electricPriceKwh, Double electricEmissionsPerKwh,
                    PerformanceImpactType performanceImpact, InfrastructureImpactType infrastructureImpact,
                    TenantImpactType tenantImpact, HealthFactorType healthFactor, RiskMetrics riskMetrics,
                    Financial financial) {
        this.grossCost = grossCost;
        this.incentiveDirect = incentiveDirect;
        this.incentivePercent = incentivePercent;
        this.netCost = netCost;
        this.energyCostReduction = energyCostReduction;
        this.energyConsumptionReduction = energyConsumptionReduction;
        this.peakConsumptionReduction = peakConsumptionReduction;
        this.emissionsReduction = emissionsReduction;
        this.paybackYears = paybackYears;
        this.electricPriceKwh = electricPriceKwh;
        this.electricEmissionsPerKwh = electricEmissionsPerKwh;
        this.performanceImpact = performanceImpact;
        this.infrastructureImpact = infrastructureImpact;
        this.tenantImpact = tenantImpact;
        this.healthFactor = healthFactor;
        this.riskMetrics = riskMetrics;
        this.financial = financial;
    }
}
