package com.project.code.Service;

import org.springframework.stereotype.Service;

import com.project.code.Model.Inventory;
import com.project.code.Model.Product;
import com.project.code.Repo.InventoryRepository;
import com.project.code.Repo.ProductRepository;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ServiceClass {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    // 1. **validateInventory Method**:
    // - Checks if an inventory record exists for a given product and store
    // combination.
    // - Parameters: `Inventory inventory`
    // - Return Type: `boolean` (Returns `false` if inventory exists, otherwise
    // `true`)
    public boolean validateInventory(Inventory inventory) {

        Inventory validInventory = inventoryRepository.findByProductIdandStoreId(inventory.getProduct().getId(),
                inventory.getStore().getId());

        if (Objects.isNull(validInventory)) {
            return true;
        }
        return false;

    }

    // 2. **validateProduct Method**:
    // - Checks if a product exists by its name.
    // - Parameters: `Product product`
    // - Return Type: `boolean` (Returns `false` if a product with the same name
    // exists, otherwise `true`)
    public boolean validateProduct(Product product){
        Product validateProduct = productRepository.findByName(product.getName());
        if(Objects.isNull(validateProduct)){
            return true;
        }

        return false;
    }

    // 3. **ValidateProductId Method**:
    // - Checks if a product exists by its ID.
    // - Parameters: `long id`
    // - Return Type: `boolean` (Returns `false` if the product does not exist with
    // the given ID, otherwise `true`)
    public boolean validateProductId(Long id){
        Product product = productRepository.findById(id).orElse(null);
        if(Objects.isNull(product)){
            return false;
        }
        return true;
    }

    // 4. **getInventoryId Method**:
    // - Fetches the inventory record for a given product and store combination.
    // - Parameters: `Inventory inventory`
    // - Return Type: `Inventory` (Returns the inventory record for the
    // product-store combination)

    public Inventory getInventoryId(Inventory inventory){

        return inventoryRepository.findByProductIdandStoreId(inventory.getProduct().getId(), inventory.getStore().getId());
    }

}
