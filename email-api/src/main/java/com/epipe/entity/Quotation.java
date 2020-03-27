package com.epipe.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Quotation implements Serializable {

    private static final long serialVersionUID = 1L;

    private String customerName;

    private String quotationNo;

    private BigDecimal totalAmount;

    private List<QuotationInfo> list;

    public List<QuotationInfo> getList() {
        return list;
    }

    public void setList(List<QuotationInfo> list) {
        this.list = list;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getQuotationNo() {
        return quotationNo;
    }

    public void setQuotationNo(String quotationNo) {
        this.quotationNo = quotationNo;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
