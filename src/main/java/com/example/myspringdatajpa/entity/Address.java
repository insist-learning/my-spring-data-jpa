package com.example.myspringdatajpa.entity;

import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@NamedQuery(name = "Address.myfindAll",
        query = "select u from Address u")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name = "user_id")
    private Long userId;


    @DomainEvents
    Collection<String> domainEvents() {
        List<String> result = new ArrayList<String>();
        System.out.println("publish");
        result.add(this.id.toString());
        return result;
    }
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void event(String s) {
        System.err.println(s);
    }



    @AfterDomainEventPublication
    void callbackMethod() {
        System.out.println("DATA SAVED!\n"+"WELL DONE");
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
}
