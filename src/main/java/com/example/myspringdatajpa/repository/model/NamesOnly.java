package com.example.myspringdatajpa.repository.model;

import com.example.myspringdatajpa.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public interface NamesOnly {
    @Value("#{target.name}")
    String getFullName();

}
