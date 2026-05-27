package com.project.code.Model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonManageReference;

@Entity
public class Store {

    // 1. Add 'id' field:
    // - Type: private long
    // - This field will be auto-incremented.
    // - Use @Id to mark it as the primary key.
    // - Use @GeneratedValue(strategy = GenerationType.IDENTITY) to auto-increment
    // it.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Add 'name' field:
    // - Type: private String
    @NotNull(message = "Name cannot be null")
    private String name;

    // Add 'address' field:
    // - Type: private String
    @NotNull(message = "Address cannot be null")
    private String address;

    // Add relationships:
    // - **Inventory**: A store can have multiple inventory entries.
    //
    // - Use @OneToMany(mappedBy = "store") to reflect the one-to-many relati
    // nship with Inventory.
    @OneToMany(mappedBy = "store")
    @JsonBackReference("store-inventory")
    private List<Inventory> inventories;

    // Add constructor:
    //
    public Store(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Add @Entity annotation:

    // Add Getters and Setters:
    // - Add getter and setter methods for all fields (id, name, address).

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

}
