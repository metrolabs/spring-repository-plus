package com.pivotenergy.domain.opportunity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import java.util.List;

@SuppressWarnings("unused")
@Embeddable
@NoArgsConstructor
public class RiskMetrics {
    @Column(name = "opportunity_risk_name", nullable = false)
    private String name;

    @Convert(converter = DoubleListConverter.class)
    @Column(name = "opportunity_risk_cdf", nullable = false, columnDefinition="TEXT")
    private List<Double> cdf;

    @Convert(converter = DoubleListConverter.class)
    @Column(name = "opportunity_risk_pdf", nullable = false, columnDefinition="TEXT")
    private List<Double> pdf;

    @Convert(converter = DoubleListConverter.class)
    @Column(name = "opportunity_risk_bins", nullable = false, columnDefinition="TEXT")
    private List<Double> bins;

    @Column(name = "opportunity_risk_stdev", nullable = false, precision = 4)
    private Double standardDeviation;

    @Column(name = "opportunity_risk_under_performance", nullable = false, precision = 4)
    private Double underPerformanceRiskPercent;

    @Column(name = "opportunity_risk_var", nullable = false, precision = 4)
    private Double valueAtRisk;

    @Column(name = "opportunity_risk_pvar_kwh", nullable = false, precision = 4)
    private Double performanceAtRiskKwh;

    @Convert(converter = DoubleListConverter.class)
    @Column(name = "opportunity_confidence_interval", nullable = false, precision = 4)
    private List<Double> confidenceInterval;

    @Column(name = "opportunity_expected_energy_reduction", nullable = false, precision = 4)
    private Double expectedEnergyReduction;

    @Column(name = "opportunity_expect_cost_reduction", nullable = false, precision = 4)
    private Double expectCostReduction;

    @Column(name = "opportunity_worst_case_energy_reduction", nullable = false, precision = 4)
    private Double worstCaseEnergyReduction;

    @Column(name = "opportunity_most_likely_energy_reduction", nullable = false, precision = 4)
    private Double mostLikelyEnergyReduction;

    @Column(name = "opportunity_best_case_energy_reduction", nullable = false, precision = 4)
    private Double bestCaseEnergyReduction;

    @Column(name = "opportunity_risk_rating", nullable = false)
    private String riskRating;

    @Column(name = "opportunity_model_certainty", nullable = false)
    private String modelCertainty;

    public RiskMetrics(String name, List<Double> cdf, List<Double> pdf, List<Double> bins,
                       Double standardDeviation, Double underPerformanceRiskPercent, Double valueAtRisk,
                       Double performanceAtRiskKwh, List<Double> confidenceInterval, Double expectedEnergyReduction,
                       Double expectCostReduction, Double worstCaseEnergyReduction, Double mostLikelyEnergyReduction,
                       Double bestCaseEnergyReduction, String riskRating, String modelCertainty) {
        this.name = name;
        this.cdf = cdf;
        this.pdf = pdf;
        this.bins = bins;
        this.standardDeviation = standardDeviation;
        this.underPerformanceRiskPercent = underPerformanceRiskPercent;
        this.valueAtRisk = valueAtRisk;
        this.performanceAtRiskKwh = performanceAtRiskKwh;
        this.confidenceInterval = confidenceInterval;
        this.expectedEnergyReduction = expectedEnergyReduction;
        this.expectCostReduction = expectCostReduction;
        this.worstCaseEnergyReduction = worstCaseEnergyReduction;
        this.mostLikelyEnergyReduction = mostLikelyEnergyReduction;
        this.bestCaseEnergyReduction = bestCaseEnergyReduction;
        this.riskRating = riskRating;
        this.modelCertainty = modelCertainty;
    }

    public String getName() {
        return name;
    }

    public RiskMetrics setName(String name) {
        this.name = name;
        return this;
    }

    public List<Double> getCdf() {
        return cdf;
    }

    public RiskMetrics setCdf(List<Double> cdf) {
        this.cdf = cdf;
        return this;
    }

    public List<Double> getPdf() {
        return pdf;
    }

    public RiskMetrics setPdf(List<Double> pdf) {
        this.pdf = pdf;
        return this;
    }

    public List<Double> getBins() {
        return bins;
    }

    public RiskMetrics setBins(List<Double> bins) {
        this.bins = bins;
        return this;
    }

    public Double getStandardDeviation() {
        return standardDeviation;
    }

    public RiskMetrics setStandardDeviation(Double standardDeviation) {
        this.standardDeviation = standardDeviation;
        return this;
    }

    public Double getUnderPerformanceRiskPercent() {
        return underPerformanceRiskPercent;
    }

    public RiskMetrics setUnderPerformanceRiskPercent(Double underPerformanceRiskPercent) {
        this.underPerformanceRiskPercent = underPerformanceRiskPercent;
        return this;
    }

    public Double getValueAtRisk() {
        return valueAtRisk;
    }

    public RiskMetrics setValueAtRisk(Double valueAtRisk) {
        this.valueAtRisk = valueAtRisk;
        return this;
    }

    public Double getPerformanceAtRiskKwh() {
        return performanceAtRiskKwh;
    }

    public RiskMetrics setPerformanceAtRiskKwh(Double performanceAtRiskKwh) {
        this.performanceAtRiskKwh = performanceAtRiskKwh;
        return this;
    }

    public List<Double> getConfidenceInterval() {
        return confidenceInterval;
    }

    public RiskMetrics setConfidenceInterval(List<Double> confidenceInterval) {
        this.confidenceInterval = confidenceInterval;
        return this;
    }

    public Double getExpectedEnergyReduction() {
        return expectedEnergyReduction;
    }

    public RiskMetrics setExpectedEnergyReduction(Double expectedEnergyReduction) {
        this.expectedEnergyReduction = expectedEnergyReduction;
        return this;
    }

    public Double getExpectCostReduction() {
        return expectCostReduction;
    }

    public RiskMetrics setExpectCostReduction(Double expectCostReduction) {
        this.expectCostReduction = expectCostReduction;
        return this;
    }

    public Double getWorstCaseEnergyReduction() {
        return worstCaseEnergyReduction;
    }

    public RiskMetrics setWorstCaseEnergyReduction(Double worstCaseEnergyReduction) {
        this.worstCaseEnergyReduction = worstCaseEnergyReduction;
        return this;
    }

    public Double getMostLikelyEnergyReduction() {
        return mostLikelyEnergyReduction;
    }

    public RiskMetrics setMostLikelyEnergyReduction(Double mostLikelyEnergyReduction) {
        this.mostLikelyEnergyReduction = mostLikelyEnergyReduction;
        return this;
    }

    public Double getBestCaseEnergyReduction() {
        return bestCaseEnergyReduction;
    }

    public RiskMetrics setBestCaseEnergyReduction(Double bestCaseEnergyReduction) {
        this.bestCaseEnergyReduction = bestCaseEnergyReduction;
        return this;
    }

    public String getRiskRating() {
        return riskRating;
    }

    public RiskMetrics setRiskRating(String riskRating) {
        this.riskRating = riskRating;
        return this;
    }

    public String getModelCertainty() {
        return modelCertainty;
    }

    public RiskMetrics setModelCertainty(String modelCertainty) {
        this.modelCertainty = modelCertainty;
        return this;
    }
}
