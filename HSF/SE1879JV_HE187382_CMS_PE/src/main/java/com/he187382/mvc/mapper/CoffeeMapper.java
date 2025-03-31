package com.he187382.mvc.mapper;

import com.he187382.mvc.dto.CoffeeDTO;
import com.he187382.mvc.entity.Coffee;
import org.springframework.stereotype.Component;

@Component
public class CoffeeMapper {
    public Coffee toCoffee(CoffeeDTO coffeeDto) {
        if (coffeeDto == null) {
            return null;
        }
        return Coffee.builder()
                .id(coffeeDto.getId())
                .name(coffeeDto.getName())
                .manufacturer(coffeeDto.getManufacturer())
                .price(coffeeDto.getPrice())
                .type(coffeeDto.getType())
                .build();
    }

    public CoffeeDTO toCoffeeDto(Coffee coffee) {
        if (coffee == null) {
            return null;
        }
        return CoffeeDTO.builder()
                .id(coffee.getId())
                .name(coffee.getName())
                .manufacturer(coffee.getManufacturer())
                .price(coffee.getPrice())
                .type(coffee.getType())
                .build();
    }
}
