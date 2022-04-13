package com.example.myspringdatajpa.repository;

import com.example.myspringdatajpa.common.R;
import com.example.myspringdatajpa.entity.User;
import com.example.myspringdatajpa.entity.UserAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserCrudRep extends MyPageRep<UserAddress,Long> {
    UserAddress findByAddressId(Long id);
}
