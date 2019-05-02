package com.pivotenergy.domain.simulation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pivotenergy.domain.opportunity.RiskMetrics;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Set;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeasureSimulationResults {

    protected String groupId;
    protected String packageId;
    protected Set<String> systems;
    protected Set<String> components;
    protected String measureName;
    protected String measureDescription;
    protected PerformanceImpactType performanceImpact;
    protected PerformanceImpactType isolatedPerformanceImpact;
    protected InfrastructureImpactType infrastructureImpact;
    protected TenantImpactType tenantImpact;
    protected Double procurementCost;
    protected Double installCost;
    protected Double installTime;
    protected Double annualMaintenanceCost;
    protected Double totalLifeTimeCost;
    protected Integer effectiveLife;
    protected String healthFactors;
    protected String inclusionCondition;
    protected Boolean included;

    protected Map<String, RetrofitInput> buildingChanges;
    protected Map<String, Map<String, RetrofitInput>> roofChanges;
    protected Map<String, Map<String, RetrofitInput>> wallChanges;
    protected Map<String, Map<String, RetrofitInput>> windowChanges;
    protected Map<String, Map<String, RetrofitInput>> zoneChanges;

    protected SimulationResults baselineResults;
    protected SimulationResults retrofitLowerResults;
    protected SimulationResults retrofitMeanResults;
    protected SimulationResults retrofitUpperResults;
    protected RiskMetrics riskMetrics;
    protected RiskMetrics isolatedMeasureRiskMetrics;
    protected Acceptance acceptance;
    protected Double expectedCostReduction;
    protected Double expectedEnergyReduction;
    protected Double expectedEmissionsReduction;

}
