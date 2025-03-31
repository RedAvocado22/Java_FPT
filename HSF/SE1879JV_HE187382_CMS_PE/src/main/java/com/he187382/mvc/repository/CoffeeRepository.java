package com.he187382.mvc.repository;

import com.he187382.mvc.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
    Optional<Coffee> findByName(String name);
}
