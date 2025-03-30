package com.he187382.mvc.service;

import com.he187382.mvc.dto.StaffDTO;

import java.util.List;

public interface StaffService {
    boolean addStaff(StaffDTO staffDTO);
    StaffDTO getStaffById(Long id);
    boolean deleteStaffById(Long id);
    List<StaffDTO> getAllStaff();
}
