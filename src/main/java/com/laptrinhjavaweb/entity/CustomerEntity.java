package com.laptrinhjavaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class CustomerEntity extends  BaseEntity{
    @Column(name = "fullname")
    private  String fullname;
    @Column(name = "email")
    private String email;
      @Column (name = "phone")
     private  String phone;

      @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
      private List<AssignmentCustomerEntity> customerEntityList = new ArrayList<>();

    public List<AssignmentCustomerEntity> getCustomerEntityList() {
        return customerEntityList;
    }

    public void setCustomerEntityList(List<AssignmentCustomerEntity> customerEntityList) {
        this.customerEntityList = customerEntityList;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
