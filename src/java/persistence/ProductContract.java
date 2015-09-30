package persistence;

import java.util.List;
import model.entities.Product;

public class ProductContract {
    
    public static void main(String[] args){
        
       
        List<Product> products = ProductDao.findAll();
        
        for(Product p : products){
            System.out.println(p.getName());
        }
             
        
    }
    
}
