package com.HE182090.mvc.controller;

import com.HE182090.mvc.dto.StaffDTO;
import com.HE182090.mvc.entity.Department;
import com.HE182090.mvc.service.StaffService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        List<StaffDTO> staffDTOList = staffService.getAllStaff();
        model.addAttribute("staffDTOList", staffDTOList);
        model.addAttribute("departmentList", Department.values());
        model.addAttribute("staffDTO", new StaffDTO());
        return "index";
    }

    @PostMapping("/postmethod")
    public String search(Model model,
                         @ModelAttribute Object object,
                         BindingResult result,
                         HttpSession session) {
        if (result.hasErrors()) {
            model.addAttribute("message", result.getAllErrors().get(0).getDefaultMessage());
        }
        model.addAttribute("object", new Object());
        session.setAttribute("list", new ArrayList<>());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("object", new Object());
        return "delete";
    }

}
