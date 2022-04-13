package com.example.myspringdatajpa.controller;

import com.example.myspringdatajpa.common.SpringSecurityAuditorAware;
import com.example.myspringdatajpa.entity.Address;
import com.example.myspringdatajpa.entity.User;
import com.example.myspringdatajpa.entity.UserAddress;
import com.example.myspringdatajpa.repository.AddresssRep;
import com.example.myspringdatajpa.repository.AllAddressRep;
import com.example.myspringdatajpa.repository.UserCrudRep;
import com.example.myspringdatajpa.repository.UserRep;
import com.example.myspringdatajpa.repository.model.NamesOnly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserCrudRep userCrudRep;
    @Autowired
    private FormatterRegistry genericConversionService;

    @Autowired
    private SpringSecurityAuditorAware springSecurityAuditorAware;

    @Autowired
    private AddresssRep addresssRep;

    @Autowired
    private AllAddressRep allAddressRep;

    @Autowired
    private UserRep userRep;

    @GetMapping("findbyId")
    public User findById() {
        return userCrudRep.findById(1L).orElse(null);
    }

    @GetMapping("findByAddressId")
    public UserAddress findByAddressId() {
        return userCrudRep.findByAddressId(1L);
    }

    @GetMapping("getAddAddress")
    public Object getAddAddress() {
        Sort.TypedSort<Address> address = Sort.sort(Address.class);
        Sort descending = address.by((Address::getId)).descending();
        return addresssRep.findAll(descending);
    }

    @GetMapping("findAllAddress")
    public Object findAllAddress() {
        return allAddressRep.findAll().and(allAddressRep.findAll()).toList();
    }

    @GetMapping("findAllById")
    public Object findAllById() {
        return allAddressRep.findAllById(3L);
    }

    @GetMapping("findAddressById")
    public Object findAddressById() {
        Address byId = allAddressRep.findById(3L);
        if (null == byId) {
            System.out.println("isNULL");
        }
        return allAddressRep.findById(3L);
    }

    @GetMapping("saveAddress")
    public Object saveAddress() {
        return addresssRep.save(new Address());
    }

    @GetMapping("getByMVNId/{id}")
    public Object getByMVNId(@PathVariable("id")Address address) {
        return address;
    }

    @GetMapping("myfindAll")
    public Object myfindAll() {
        return allAddressRep.myfindAll();
    }

    @GetMapping("myFindById")
    public Object myFindById() {
        return allAddressRep.myFindById(1L);
    }
    @GetMapping("findByName")
    public Object findByName() {
        return allAddressRep.findByName("tetaddress", PageRequest.of(1,10));
    }

    @GetMapping("findAllById2")
    public Object findAllById2() {
        return userRep.findProjectedById(1L, NamesOnly.class);
    }


}
