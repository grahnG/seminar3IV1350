/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seminarium3.view;

import com.mycompany.seminarium3.controller.*;
import com.mycompany.seminarium3.integration.*;

/**
 * This is a placeholder for the real view. It contains a hardcoded execution with calls to all
 * system operations in the controller.
 * @author gusta
 */
public class View {
    private Controller contr;

    /**
     * Creates a new instance, that uses the specified controller for all calls to other layers.
     * 
     * @param contr The controller to use for all calls to other layers. 
     */
    public View(Controller contr){
        this.contr = contr;
    }

    /**
     * Performs a fake sale, by calling all system operations in the controller. 
     */
    public void runFakeExecution(){
        contr.startNewSale();
        ItemDTO oatmeal = new ItemDTO(29.90, 12345, 6, "BigWheel Oatmeal 500 ml, whole grain oats,"
                + " high fiber, gluten free", "BigWheel Oatmeal");
        ItemDTO YouGoGo = new ItemDTO(14.90, 456, 6, "YouGoGo Blueberry 240 g, low sugar yogurt,"
                + " blueberry flavour", "YouGoGo Blueberry");


    contr.addItemToSale(oatmeal, 2);
    contr.addItemToSale(YouGoGo, 1);

        System.out.println("A new sale has been started.");
    }
    
    /**
     * Completes the current sale process by finalizing all transactions and triggering the receipt generation.
     */
    public void genReceipt(){
        contr.endSale();
    }

}
