/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.product;

/**
 *
 * @author pankajtiwana
 */
public class product {

    public product() {
        
    }
    
    public product(int id, String name, String description, int quantity){
        this.productId=id;
        this.productName=name;
        this.productDescription=description;
        this.quantity=quantity;
        
    }
    
    protected int productId;

    protected String productName;

    /**
     * Get the value of productName
     *
     * @return the value of productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Set the value of productName
     *
     * @param productName new value of productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    protected String productDescription;

    /**
     * Get the value of productDescription
     *
     * @return the value of productDescription
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * Set the value of productDescription
     *
     * @param productDescription new value of productDescription
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    protected int quantity;

    /**
     * Get the value of quantity
     *
     * @return the value of quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the value of quantity
     *
     * @param quantity new value of quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the value of productId
     *
     * @return the value of productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Set the value of productId
     *
     * @param productId new value of productId
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

}
