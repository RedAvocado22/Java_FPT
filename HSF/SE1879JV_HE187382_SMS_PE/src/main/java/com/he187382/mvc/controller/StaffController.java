package com.he187382.mvc.controller;

import com.he187382.mvc.dto.StaffDTO;
import com.he187382.mvc.entity.Department;
import com.he187382.mvc.service.StaffService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StaffController {
    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        List<StaffDTO> staffDTOList = staffService.getAllStaff();
        model.addAttribute("staffDTOList", staffDTOList);
        model.addAttribute("departmentList", Department.values());
        model.addAttribute("staffDTO", new StaffDTO()); // Ensure the object is available for the form
        return "index";
    }

    @PostMapping("/postmethod")
    public String search(Model model,
                         @ModelAttribute("staffDTO") StaffDTO staffDTO,
                         BindingResult result,
                         HttpSession session) {

        // Validate the fields manually
        if (staffDTO.getName() == null || staffDTO.getName().isEmpty() || staffDTO.getName().length() > 50) {
            result.rejectValue("name", "error.name", "Name must be between 1 and 50 characters and not empty.");
        }

        if (staffDTO.getAge() < 18 || staffDTO.getAge() > 99) {
            result.rejectValue("age", "error.age", "Age must be between 18 and 99.");
        }

        if (staffDTO.getAddress() == null || staffDTO.getAddress().isEmpty() || staffDTO.getAddress().length() > 100) {
            result.rejectValue("address", "error.address", "Address cannot empty or exceed 100 characters.");
        }

        if (staffDTO.getDepartment() == null || staffDTO.getDepartment().isEmpty()) {
            result.rejectValue("department", "error.department", "Department cannot be empty.");
        }

        // If there are errors, add them to the model and return to the form
        if (result.hasErrors()) {
            model.addAttribute("message", "There are errors in the form!");
            model.addAttribute("staffDTO", staffDTO);
            model.addAttribute("departmentList", Department.values());
            List<StaffDTO> staffDTOList = staffService.getAllStaff();
            model.addAttribute("staffDTOList", staffDTOList);
            return "index";
        }

        // Proceed with saving the staff if there are no errors
        staffService.addStaff(staffDTO);
        return "redirect:/"; // or whatever success page you want
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        StaffDTO staffDTO = staffService.getStaffById(id);
        staffService.deleteStaffById(id);
        model.addAttribute("staffDTO", staffDTO);  // Pass the staffDTO to the view
        return "redirect:/"; // The template name for confirmation
    }
}
