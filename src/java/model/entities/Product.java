/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

/**
 *
 * @author Gustavo
 */
public class Product {
    
    private Integer id;
    private String name;
    private String description;
    private Long stock;
    private Long minimunStock;
    private Double unitaryValue;
    private Long date;
    private String image;

    public Product() {
        super();
        date = 123456l;
    }
    
    

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
  
    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getMinimunStock() {
        return minimunStock;
    }

    public void setMinimunStock(Long minimunStock) {
        this.minimunStock = minimunStock;
    }

    public Double getUnityPrice() {
        return unitaryValue;
    }

    public void setUnityPrice(Double unityPrice) {
        this.unitaryValue = unityPrice;
    }
    
    
   
}
