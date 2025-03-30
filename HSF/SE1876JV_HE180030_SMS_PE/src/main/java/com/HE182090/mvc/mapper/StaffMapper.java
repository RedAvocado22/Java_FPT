package com.HE182090.mvc.mapper;

import com.HE182090.mvc.dto.StaffDTO;
import com.HE182090.mvc.entity.Staff;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StaffMapper {

    public Staff toStaff(StaffDTO staffDto){
        if (staffDto == null) {
            return null;
        }
        return Staff.builder()
                .id(staffDto.getId())
                .name(staffDto.getName())
                .address(staffDto.getAddress())
                .age(staffDto.getAge())
                .department(staffDto.getDepartment())
                .build();
    }

    public StaffDTO toStaffDto(Staff staff){
        if (staff == null) {
            return null;
        }
        return StaffDTO.builder()
                .id(staff.getId())
                .name(staff.getName())
                .address(staff.getAddress())
                .department(staff.getDepartment())
                .age(staff.getAge())
                .build();
    }
}
