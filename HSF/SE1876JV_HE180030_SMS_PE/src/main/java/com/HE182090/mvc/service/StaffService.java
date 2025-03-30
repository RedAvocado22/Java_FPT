package com.HE182090.mvc.service;

import com.HE182090.mvc.dto.StaffDTO;

import java.util.List;

public interface StaffService {
    boolean addStaff(StaffDTO staffDTO);
    StaffDTO getStaffById(Long id);
    boolean deleteStaffById(Long id);
    List<StaffDTO> getAllStaff();
}
