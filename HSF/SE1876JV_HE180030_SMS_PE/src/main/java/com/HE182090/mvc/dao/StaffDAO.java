package com.HE182090.mvc.dao;

import com.HE182090.mvc.entity.Staff;

import java.util.List;

public interface StaffDAO {
    Staff create(Staff staff);
    Staff findById(Long id);
    Staff deleteById(Long id);
    List<Staff> getAll();
}
