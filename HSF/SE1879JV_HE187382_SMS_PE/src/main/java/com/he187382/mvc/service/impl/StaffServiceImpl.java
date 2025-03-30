package com.he187382.mvc.service.impl;

import com.he187382.mvc.dao.StaffDAO;
import com.he187382.mvc.dto.StaffDTO;
import com.he187382.mvc.entity.Staff;
import com.he187382.mvc.mapper.StaffMapper;
import com.he187382.mvc.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffServiceImpl implements StaffService {

    private final StaffDAO staffDAO;
    private final StaffMapper staffMapper;

    @Autowired
    public StaffServiceImpl(StaffDAO staffDAO, StaffMapper staffMapper) {
        this.staffDAO = staffDAO;
        this.staffMapper = staffMapper;
    }

    @Override
    public boolean addStaff(StaffDTO staffDTO) {
        try {
            Staff staff = staffMapper.toStaff(staffDTO);
            Staff savedStaff = staffDAO.create(staff);
            return savedStaff != null && savedStaff.getId() != null;
        } catch (Exception e) {
            // Consider logging the exception here
            return false;
        }
    }

    @Override
    public StaffDTO getStaffById(Long id) {
        Staff staff = staffDAO.findById(id);
        return staff != null ? staffMapper.toStaffDto(staff) : null;
    }

    @Override
    public boolean deleteStaffById(Long id) {
        try {
            Staff deletedStaff = staffDAO.deleteById(id);
            return deletedStaff != null;
        } catch (Exception e) {
            // Consider logging the exception here
            return false;
        }
    }

    @Override
    public List<StaffDTO> getAllStaff() {
        List<Staff> staffList = staffDAO.getAll();
        return staffList.stream()
                .map(staffMapper::toStaffDto)
                .collect(Collectors.toList());
    }
}
