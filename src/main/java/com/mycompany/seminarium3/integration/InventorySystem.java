/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seminarium3.integration;
import com.mycompany.seminarium3.controller.*;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.seminarium3.model.*;
/**
 * Represents an inventory system for managing items.
 */
public class InventorySystem {
    private List<Integer> identifiers = new ArrayList<>();
    private List<ItemDTO> items = new ArrayList<>();
    private List<Integer> quantities = new ArrayList<>();
    /**
    * Constructs a new InventorySystem object and initializes it with hardcoded items.
    */
    public InventorySystem(){
        addItem(new ItemDTO(2990, 12345, 6, "BigWheel Oatmeal 500 ml, whole grain oats, high fiber, gluten free", "BigWheel Oatmeal"), 10);
        addItem(new ItemDTO(1490, 456, 6, "YouGoGo Blueberry 240 g, low sugar yogurt, blueberry flavour", "YouGoGo Blueberry"), 10);
    }
    /**
    * Adds an item with the specified quantity to the inventory.
    *
    * @param item The item to add.
    * @param quantity The quantity of the item to add.
    */
    private void addItem(ItemDTO item, int quantity) {
        identifiers.add(item.getItemIdentifier());
        items.add(item);
        quantities.add(quantity);
    }

    /**
    * Checks the status of an item in the inventory.
    *
    * @param item The item to check.
    * @return true if the item is in the inventory, false otherwise.
    */   
    public boolean checkItemStatus (ItemDTO item){
        int ID = item.getItemIdentifier();
        boolean status = false;
        if(identifiers.contains(ID)){
            status = true;
        }
        
        return status;
    }
    /**
    * Updates the inventory based on items sold in a sale.
    *
    * @param saleDTO The SaleDTO object containing sale information.
    */
    public void updateInventory(SaleDTO saleDTO){
        List<ItemDTO> boughtItems = saleDTO.getItems();
        List<Integer> boughtQuantities = saleDTO.getQuantities();
        
        for (int i = 0; i < boughtItems.size(); i++) {
            ItemDTO boughtItem = boughtItems.get(i);
            int boughtQuantity = boughtQuantities.get(i);

            int index = -1;
            for (int j = 0; j < items.size(); j++) {
                if (boughtItem.equals(items.get(j))) {
                    index = j;
                    break; 
                }
            }

            if (index != -1) {

                int currentQuantity = quantities.get(index);
                quantities.set(index, currentQuantity - boughtQuantity);
            }
        }        
    }

}


