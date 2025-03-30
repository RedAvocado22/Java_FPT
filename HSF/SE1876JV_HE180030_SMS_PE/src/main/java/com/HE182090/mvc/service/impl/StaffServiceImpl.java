package com.HE182090.mvc.service.impl;

import com.HE182090.mvc.dao.StaffDAO;
import com.HE182090.mvc.dto.StaffDTO;
import com.HE182090.mvc.entity.Staff;
import com.HE182090.mvc.mapper.StaffMapper;
import com.HE182090.mvc.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffDAO staffDAO;
    private final StaffMapper staffMapper;

    @Override
    public boolean addStaff (StaffDTO staffDTO) {
        Staff staff = staffMapper.toStaff(staffDTO);
        if (staff == null) {
            return false;
        }
        return staffDAO.create(staff) != null;
    }

    @Override
    public StaffDTO getStaffById(Long id) {
        return staffMapper.toStaffDto(staffDAO.findById(id));
    }


    @Override
    public boolean deleteStaffById(Long id) {
        return staffDAO.deleteById(id) != null;
    }

    @Override
    public List<StaffDTO> getAllStaff() {
        List<Staff> staffs = staffDAO.getAll();
        if (staffs == null) {
            return null;
        }
        return staffs.stream().map(staffMapper::toStaffDto).toList();
    }
}
