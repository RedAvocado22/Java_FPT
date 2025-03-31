package com.he187382.mvc.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Coffee")
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Coffee_ID")
    private Integer id;

    @Column(name = "Coffee_Name", unique = true, nullable = false)
    private String name;

    @Column(name = "Price")
    private double price;

    @Column(name = "Manufacturer")
    private String manufacturer;

    @Column(name = "Type")
    private Type type;

    public Coffee() {
    }

    public Coffee(Integer id, String name, double price, String manufacturer, Type type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.type = type;
    }

    private Coffee(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
        this.manufacturer = builder.manufacturer;
        this.type = builder.type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private String name;
        private double price;
        private String manufacturer;
        private Type type;

        private Builder() {
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder manufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public Builder type(Type type) {
            this.type = type;
            return this;
        }

        public Coffee build() {
            return new Coffee(this);
        }
    }
}
