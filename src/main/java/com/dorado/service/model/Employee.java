package com.dorado.service.model;

public class Employee {
    private Long id;
    private String name;
    private String position;
    private String phone;
    private Long branchId;
    private Double commissionRate;

    public Employee() {}

    public Employee(Long id, String name, String position, String phone, Long branchId, Double commissionRate) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.phone = phone;
        this.branchId = branchId;
        this.commissionRate = commissionRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Double commissionRate) {
        this.commissionRate = commissionRate;
    }
}
