package com.example.myspringdatajpa.entity;

import javax.persistence.*;

@Entity
@DiscriminatorColumn
public class UserAddress extends User{

    @JoinColumn(name = "address_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
