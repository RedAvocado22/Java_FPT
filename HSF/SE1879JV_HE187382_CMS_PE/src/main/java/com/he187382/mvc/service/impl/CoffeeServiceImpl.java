package com.he187382.mvc.service.impl;

import com.he187382.mvc.dto.CoffeeDTO;
import com.he187382.mvc.entity.Coffee;
import com.he187382.mvc.mapper.CoffeeMapper;
import com.he187382.mvc.repository.CoffeeRepository;
import com.he187382.mvc.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoffeeServiceImpl implements CoffeeService {
    private final CoffeeRepository coffeeRepository;
    private final CoffeeMapper coffeeMapper;

    @Autowired
    public CoffeeServiceImpl(CoffeeRepository coffeeRepository, CoffeeMapper coffeeMapper) {
        this.coffeeRepository = coffeeRepository;
        this.coffeeMapper = coffeeMapper;
    }

    @Override
    public boolean addCoffee(CoffeeDTO coffeeDTO) {
        try {
            Coffee coffee = coffeeMapper.toCoffee(coffeeDTO);
            Coffee existedCoffee = coffeeRepository.findByName(coffee.getName()).orElse(null);

            if (existedCoffee != null) {
                return false;
            }

            Coffee savedCoffee = coffeeRepository.save(coffee);
            return savedCoffee.getId() != null;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public CoffeeDTO getCoffeeById(Integer id) {
        Coffee coffee = coffeeRepository.findById(id).orElse(null);
        return coffee != null ? coffeeMapper.toCoffeeDto(coffee) : null;
    }

    @Override
    public boolean deleteCoffeeById(Integer id) {
        try {
            coffeeRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<CoffeeDTO> getAllCoffee() {
        List<Coffee> coffeeList = coffeeRepository.findAll();
        return coffeeList.stream()
                .map(coffeeMapper::toCoffeeDto)
                .collect(Collectors.toList());
    }
}
