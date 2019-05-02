package com.pivotenergy.domain.opportunity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import java.util.List;

@SuppressWarnings("unused")
@Embeddable
@NoArgsConstructor
public class Financial {
    @Column(name = "financial_dr")
    private Double discountRate;
    @Column(name = "financial_npv")
    private Double netPresentValue;
    @Column(name = "financial_irr")
    private Double internalRateOfReturn;
    @Column(name = "financial_crr")
    private Double costReductionRatio;
    @Column(name = "financial_roi")
    private Double returnOnInvestment;
    @Column(name = "financial_uly")
    private Integer usefulLifeYears;
    @Column(name = "financial_payback_years")
    private Integer paybackYears;

    /**
     * Sum total of emissions reduction over the life of the measure minus reoccurring costs
     * unit is in kg
     */
    @Column(name = "financial_total_emission_reduction_kg")
    private Double totalEmissionsReduction;

    /**
     * Sum total of cost reduction over the life of the measure minus reoccurring costs
     */
    @Column(name = "financial_cost_reduction")
    private Double costReduction;

    /**
     * Sum total of reoccurring costs over the life of the measure
     */
    @Column(name = "financial_reoccurring_cost")
    private Double reoccurringCost;

    /**
     *  Present Value, Net Present Value (NPV) or Discounted Cash Flow (DCF) metric.
     *  Net Present Value (NPV) is the difference between the present value of cash inflows and the present
     *  value of cash outflows. NPV is used in capital budgeting to analyze the profitability of a projected
     *  investment or project.
     */
    @Convert(converter = DoubleListConverter.class)
    @Column(name = "financial_npv_array")
    private List<Double> presentValue;

    @Convert(converter = DoubleListConverter.class)
    @Column(name = "financial_cumulative_npv_array")
    private List<Double> cumulativePresentValue;

    /**
     * Net Cash Flow or Future Value:
     * futureValue[i] = (measure.getProjectedCostReduction()) - (measure.getReoccurringCost())
     *
     * The future value (FV) measures the nominal future sum of money that a given sum of money is “worth” at a
     * specified time in the future assuming a certain interest rate, or more generally, rate of return.
     * The FV is calculated by multiplying the present value by the accumulation function.
     */
    @Convert(converter = DoubleListConverter.class)
    @Column(name = "financial_fv_array")
    private List<Double> futureValue;

    @Convert(converter = DoubleListConverter.class)
    @Column(name = "financial_cumulative_fv_array")
    private List<Double> cumulativeFutureValue;

    public Financial(Double discountRate, Double netPresentValue, Double internalRateOfReturn,
                     Double costReductionRatio, Double returnOnInvestment, Integer usefulLifeYears,
                     Integer paybackYears, Double totalEmissionsReduction, Double costReduction,
                     Double reoccurringCost, List<Double> presentValue, List<Double> cumulativePresentValue,
                     List<Double> futureValue, List<Double> cumulativeFutureValue) {
        this.discountRate = discountRate;
        this.netPresentValue = netPresentValue;
        this.internalRateOfReturn = internalRateOfReturn;
        this.costReductionRatio = costReductionRatio;
        this.returnOnInvestment = returnOnInvestment;
        this.usefulLifeYears = usefulLifeYears;
        this.paybackYears = paybackYears;
        this.totalEmissionsReduction = totalEmissionsReduction;
        this.costReduction = costReduction;
        this.reoccurringCost = reoccurringCost;
        this.presentValue = presentValue;
        this.cumulativePresentValue = cumulativePresentValue;
        this.futureValue = futureValue;
        this.cumulativeFutureValue = cumulativeFutureValue;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public Financial setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
        return this;
    }

    public Double getNetPresentValue() {
        return netPresentValue;
    }

    public Financial setNetPresentValue(Double netPresentValue) {
        this.netPresentValue = netPresentValue;
        return this;
    }

    public Double getInternalRateOfReturn() {
        return internalRateOfReturn;
    }

    public Financial setInternalRateOfReturn(Double internalRateOfReturn) {
        this.internalRateOfReturn = internalRateOfReturn;
        return this;
    }

    public Double getCostReductionRatio() {
        return costReductionRatio;
    }

    public Financial setCostReductionRatio(Double costReductionRatio) {
        this.costReductionRatio = costReductionRatio;
        return this;
    }

    public Double getReturnOnInvestment() {
        return returnOnInvestment;
    }

    public Financial setReturnOnInvestment(Double returnOnInvestment) {
        this.returnOnInvestment = returnOnInvestment;
        return this;
    }

    public Integer getUsefulLifeYears() {
        return usefulLifeYears;
    }

    public Financial setUsefulLifeYears(Integer usefulLifeYears) {
        this.usefulLifeYears = usefulLifeYears;
        return this;
    }

    public Integer getPaybackYears() {
        return paybackYears;
    }

    public Financial setPaybackYears(Integer paybackYears) {
        this.paybackYears = paybackYears;
        return this;
    }

    public Double getTotalEmissionsReduction() {
        return totalEmissionsReduction;
    }

    public Financial setTotalEmissionsReduction(Double totalEmissionsReduction) {
        this.totalEmissionsReduction = totalEmissionsReduction;
        return this;
    }

    public Double getCostReduction() {
        return costReduction;
    }

    public Financial setCostReduction(Double costReduction) {
        this.costReduction = costReduction;
        return this;
    }

    public Double getReoccurringCost() {
        return reoccurringCost;
    }

    public Financial setReoccurringCost(Double reoccurringCost) {
        this.reoccurringCost = reoccurringCost;
        return this;
    }

    public List<Double> getPresentValue() {
        return presentValue;
    }

    public Financial setPresentValue(List<Double> presentValue) {
        this.presentValue = presentValue;
        return this;
    }

    public List<Double> getCumulativePresentValue() {
        return cumulativePresentValue;
    }

    public Financial setCumulativePresentValue(List<Double> cumulativePresentValue) {
        this.cumulativePresentValue = cumulativePresentValue;
        return this;
    }

    public List<Double> getFutureValue() {
        return futureValue;
    }

    public Financial setFutureValue(List<Double> futureValue) {
        this.futureValue = futureValue;
        return this;
    }

    public List<Double> getCumulativeFutureValue() {
        return cumulativeFutureValue;
    }

    public Financial setCumulativeFutureValue(List<Double> cumulativeFutureValue) {
        this.cumulativeFutureValue = cumulativeFutureValue;
        return this;
    }
}
