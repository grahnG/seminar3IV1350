/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seminarium3.model;
import com.mycompany.seminarium3.integration.*;
import java.time.LocalTime;

/**
* Represents a sale transaction, managing sale details and generating receipts.
*/
public class Sale {
    private SaleDTO saleDTO;
    private Receipt receipt;
    private InventorySystem inventorySystem;
    private AccountingSystem accountingSystem;

    /**
    * Constructs a new Sale object with the specified InventorySystem and AccountingSystem.
    *
    * @param inventorySystem The inventory system to manage inventory.
    * @param accountingSystem The accounting system to manage accounting.
    */
    public Sale(InventorySystem inventorySystem, AccountingSystem accountingSystem) {
        this.inventorySystem = inventorySystem;
        this.accountingSystem = accountingSystem;
        this.saleDTO = new SaleDTO(); 
    }
    /**
    * Initializes a new sale by re-initializing the SaleDTO.
    */
    public void startNewSale() {
        this.saleDTO = new SaleDTO();
    }
    /**
    * Adds an item to the current sale.
    *
    * @param item The item to add.
    * @param quantity The quantity of the item to add.
    * @throws IllegalArgumentException If the item does not exist in the inventory.
    */
    public void addItemToSale(ItemDTO item, int quantity) {
        if (!inventorySystem.checkItemStatus(item)) {
            throw new IllegalArgumentException("Item does not exist in inventory");
        }

        int index = saleDTO.getItemIndex(item);
        if (index != -1) {
            saleDTO.updateItemQuantity(index, quantity);
        } else {
            saleDTO.addItem(item, quantity);
        }
        double itemTotalPrice = item.getPrice() * quantity;
        double itemTotalVAT = itemTotalPrice * item.getVAT() / 100;
        saleDTO.updateFinancialDetails(itemTotalPrice, itemTotalVAT);
    }
    /**
    * Finalizes the sale by generating a receipt, updating inventory, and accounting.
    */
    public void endSale() {
        this.receipt = new Receipt();
        String receiptString = receipt.generateReceipt(saleDTO);
        inventorySystem.updateInventory(saleDTO);
        accountingSystem.updateAccounting(saleDTO);
        System.out.println(receiptString);
    }
}
