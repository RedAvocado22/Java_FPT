package com.he187382.mvc.dto;

public class StaffDTO {

    private Long id;

    private String name;

    private int age;

    private String address;

    private String department;

    public StaffDTO() {
    }

    public StaffDTO(Long id, String name, int age, String address, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.department = department;
    }

    // Private constructor for builder
    private StaffDTO(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
        this.department = builder.department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Static method to create a new Builder instance
    public static Builder builder() {
        return new Builder();
    }

    // Builder class
    public static class Builder {
        private Long id;
        private String name;
        private int age;
        private String address;
        private String department;

        private Builder() {
            // Private constructor to enforce the use of the static builder() method
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        public StaffDTO build() {
            return new StaffDTO(this);
        }
    }
}