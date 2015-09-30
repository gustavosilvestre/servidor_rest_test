/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import model.entities.Product;
import persistence.ProductDao;

/**
 * REST Web Service
 *
 * @author Gustavo
 */
@Path("product")
@RequestScoped
public class ProductWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductWS
     */
    public ProductWS() {
    }

    /**
     * Retrieves representation of an instance of ws.ProductWS
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        return "TESTE METODO GET";
    }

    @GET
    @Path("product")
    @Produces("application/json")
    public String getUsuario() {
        List<Product> lista = ProductDao.findAll();
        return new Gson().toJson(lista);

    }

    @GET
    @Path("product/deleteall")
    @Produces("application/json")
    public String deleteAll() {
        ProductDao.deleteAll();
        return "Produtos deletados com sucesso!";
    }

    @POST
    @Path("product/{name}/{description}/{image}/{stock}/{minunStock}/{unitaryValue}/{date}")
    @Produces("application/json")
    public String save(@PathParam("name") String name,@PathParam("description") String description, @PathParam("image") String image, @PathParam("stock") String stock, @PathParam("minimunStock") String minunStock, @PathParam("unitaryValue")String unitaryValue,@PathParam("date") String date) {
        
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setStock(Long.parseLong(stock));
        product.setMinimunStock(Long.parseLong(minunStock));
        product.setUnityPrice(Double.parseDouble(unitaryValue));
        product.setImage(image);
        product.setDate(Long.parseLong(date));
        
        
        ProductDao.save(product);
       
        return "save";

    }

    /**
     * PUT method for updating or creating an instance of ProductWS
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
