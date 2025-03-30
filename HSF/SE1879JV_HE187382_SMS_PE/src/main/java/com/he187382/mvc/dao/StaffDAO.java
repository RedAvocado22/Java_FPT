package com.he187382.mvc.dao;

import com.he187382.mvc.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StaffDAO {
    private final StaffRepository staffRepository;

    @Autowired
    public StaffDAO(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public Staff create(Staff staff) {
        return staffRepository.save(staff);
    }

    public Staff findById(Long id) {
        Optional<Staff> result = staffRepository.findById(id);
        return result.orElse(null);
    }

    public Staff update(Staff staff) {
        return staffRepository.save(staff);
    }

    public Staff deleteById(Long id) {
        Staff staff = findById(id);
        if (staff != null) {
            staffRepository.deleteById(id);
        }
        return staff;
    }

    public List<Staff> getAll() {
        return staffRepository.findAll();
    }
}