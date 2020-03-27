package com.epipe.entity;


import java.io.Serializable;
import java.math.BigDecimal;

public class QuotationInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal taxRate;

    private BigDecimal discount;

    private BigDecimal quotaPrice;

    private BigDecimal totalAmount;

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getQuotaPrice() {
        return quotaPrice;
    }

    public void setQuotaPrice(BigDecimal quotaPrice) {
        this.quotaPrice = quotaPrice;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
