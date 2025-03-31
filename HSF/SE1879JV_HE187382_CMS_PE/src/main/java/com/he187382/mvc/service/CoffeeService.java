package com.he187382.mvc.service;

import com.he187382.mvc.dto.CoffeeDTO;

import java.util.List;

public interface CoffeeService {
    boolean addCoffee(CoffeeDTO coffeeDTO);

    CoffeeDTO getCoffeeById(Integer id);

    boolean deleteCoffeeById(Integer id);

    List<CoffeeDTO> getAllCoffee();
}
