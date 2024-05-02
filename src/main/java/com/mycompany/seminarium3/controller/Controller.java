/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package com.mycompany.seminarium3.controller;
import com.mycompany.seminarium3.model.*;
import com.mycompany.seminarium3.integration.*;

/**
* Controller class responsible for managing interactions between the system components.
*/
public class Controller {
    private SystemCreator systemCreator;
    private Sale sale;
    /**
    * Constructs a new Controller object with the specified SystemCreator.
    *
    * @param systemCreator The SystemCreator object used to create and access system components.
    */
    public Controller(SystemCreator systemCreator){
        this.systemCreator = systemCreator;
        this.sale = new Sale(systemCreator.getInventory(), systemCreator.getAccounting()); 
    }
    /**
    * Starts a new sale by delegating to the Sale object.
    */
    public void startNewSale(){
        sale.startNewSale();
    }
    /**
    * Ends the current sale by delegating to the Sale object.
    */
    public void endSale() {
        sale.endSale();
    }
    /**
    * Adds an item to the current sale by delegating to the Sale object.
    *
    * @param item The item to add to the sale.
    * @param quantity The quantity of the item to add.
    */
    public void addItemToSale(ItemDTO item, int quantity) {
        sale.addItemToSale(item, quantity);
    }
}
