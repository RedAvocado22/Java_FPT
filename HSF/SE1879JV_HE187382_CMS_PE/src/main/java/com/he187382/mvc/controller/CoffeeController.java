package com.he187382.mvc.controller;

import com.he187382.mvc.dto.CoffeeDTO;
import com.he187382.mvc.entity.Type;
import com.he187382.mvc.service.CoffeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Comparator;
import java.util.List;

@Controller
public class CoffeeController {
    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        List<CoffeeDTO> coffeeDTOList = coffeeService.getAllCoffee();
        coffeeDTOList.sort(Comparator.comparing(CoffeeDTO::getName));

        model.addAttribute("coffeeDTOList", coffeeDTOList);
        model.addAttribute("typeList", Type.values());
        model.addAttribute("coffeeDTO", new CoffeeDTO());
        return "index";
    }

    @PostMapping("/postmethod")
    public String search(Model model,
                         @ModelAttribute("coffeeDTO") CoffeeDTO coffeeDTO,
                         BindingResult result,
                         HttpSession session) {

        if (coffeeDTO.getName() == null || coffeeDTO.getName().isEmpty() || coffeeDTO.getName().length() > 50) {
            result.rejectValue(
                    "name",
                    "error.name",
                    "Name must be between 1 and 50 characters and not empty."
            );
        }

        if (coffeeDTO.getPrice() <= 0 || coffeeDTO.getPrice() >= 100) {
            result.rejectValue(
                    "price",
                    "error.price",
                    "Price must be between 0 and 100."
            );
        }

        if (coffeeDTO.getType() == null) {
            result.rejectValue(
                    "type",
                    "error.type",
                    "Type must be specified."
            );
        }

        if (coffeeDTO.getManufacturer() == null || coffeeDTO.getManufacturer().isEmpty() || coffeeDTO.getManufacturer().length() > 100) {
            result.rejectValue(
                    "manufacturer",
                    "error.manufacturer",
                    "Manufacturer cannot be empty or exceed 100 characters."
            );
        }

        if (result.hasErrors()) {
            model.addAttribute("coffeeDTO", coffeeDTO);
            model.addAttribute("typeList", Type.values());

            List<CoffeeDTO> coffeeDTOList = coffeeService.getAllCoffee();
            coffeeDTOList.sort(Comparator.comparing(CoffeeDTO::getName));
            model.addAttribute("coffeeDTOList", coffeeDTOList);
            model.addAttribute("typeList", Type.values());

            return "index";
        }

        if (coffeeService.addCoffee(coffeeDTO))
            model.addAttribute("message", "Create new coffee successfully");
        else {
            model.addAttribute("error", "Coffee already exists");
        }

        List<CoffeeDTO> coffeeDTOList = coffeeService.getAllCoffee();
        coffeeDTOList.sort(Comparator.comparing(CoffeeDTO::getName));

        model.addAttribute("coffeeDTOList", coffeeDTOList);
        model.addAttribute("typeList", Type.values());
        model.addAttribute("coffeeDTO", new CoffeeDTO());

        return "index";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        model.addAttribute("coffeeDTO", new CoffeeDTO());

        if (coffeeService.deleteCoffeeById(id)) {
            model.addAttribute("message", "Deleted successfully!");
        } else {
            model.addAttribute("error", "Coffee could not be deleted!");
        }

        List<CoffeeDTO> coffeeDTOList = coffeeService.getAllCoffee();
        coffeeDTOList.sort(Comparator.comparing(CoffeeDTO::getName));
        model.addAttribute("coffeeDTOList", coffeeDTOList);
        model.addAttribute("typeList", Type.values());

        return "index";
    }
}
