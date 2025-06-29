package com.dorado.service.model;

import java.time.LocalDateTime;
import java.util.List;

public class Sale {
    private Long id;
    private LocalDateTime date;
    private String customerName;
    private String customerPhone;
    private List<SaleItem> items;
    private Double subtotal;
    private Double igv;
    private Double total;
    private String paymentMethod;
    private Long employeeId;
    private Long branchId;

    public Sale() {}

    public Sale(Long id, LocalDateTime date, String customerName, String customerPhone, List<SaleItem> items, Double subtotal, Double igv, Double total, String paymentMethod, Long employeeId, Long branchId) {
        this.id = id;
        this.date = date;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.items = items;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
        this.paymentMethod = paymentMethod;
        this.employeeId = employeeId;
        this.branchId = branchId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public List<SaleItem> getItems() {
        return items;
    }

    public void setItems(List<SaleItem> items) {
        this.items = items;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }
}
