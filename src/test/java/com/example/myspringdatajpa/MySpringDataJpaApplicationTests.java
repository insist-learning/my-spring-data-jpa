package com.example.myspringdatajpa;

import com.example.myspringdatajpa.entity.AuditUser;
import com.example.myspringdatajpa.entity.User;
import com.example.myspringdatajpa.repository.AuditUserRep;
import com.example.myspringdatajpa.repository.UserRep;
import com.example.myspringdatajpa.repository.model.NamesOnly;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class MySpringDataJpaApplicationTests {


    @Autowired
    private UserRep userRep;
    @Autowired
    private AuditUserRep auditUserRep;

    public static Specification<User> isLongTermCustomer() {
        return (root, query, builder) -> {
            return builder.equal(root.get("name"), "9");
        };
    }
    @Test
    void contextLoads() {
        List<User> all = userRep.findAll(isLongTermCustomer());
        System.out.println(all);
//        userRep.findProjectedById(1L, NamesOnly.class);
    }

    @Test
    void contextLoads2() {
        User person = new User();
        person.setName("Dave");
        person.setId(1L);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("id");

        Example<User> example = Example.of(person,matcher);
        List<User> all = (List)userRep.findAll(example);
        System.out.println(all);
    }

    @Test
    void testSaveAudiUser() {
        AuditUser user = new AuditUser();
        user.setName("ttt");
        auditUserRep.save(user);
    }
}
