/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pankaj;

import DataBaseCredentials.DatabaseConnection;
import com.product.product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author pankajtiwana
 */
@Path("/")
public class GenericResource {

    DatabaseConnection connections = new DatabaseConnection();
    product pro = new product();
    ArrayList<product> products = new ArrayList<>();
    Connection conn;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        conn = connections.getConnection();

    }

    /**
     * Retrieves representation of an instance of com.pankaj.GenericResource
     *
     * @return an instance of java.lang.String
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    @GET
    @Path("/product")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<product> getXml() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        Statement smt = conn.createStatement();
        ResultSet rs = smt.executeQuery("select * from product");

        ResultSetMetaData rsmd = rs.getMetaData();
        int col = rsmd.getColumnCount();
        while (rs.next()) {

            product pro = new product(rs.getInt("productid"), rs.getString("name"), rs.getString("description"), rs.getInt("quantity"));
            products.add(pro);
        }

        return products;
    }

    @GET
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<product> oneProduct(@QueryParam("id") int id) throws SQLException
    {
        Statement smt = conn.createStatement();
        ResultSet rs = smt.executeQuery("select * from product where productid="+id);

      
        while (rs.next()) {

            product pro = new product(rs.getInt("productid"), rs.getString("name"), rs.getString("description"), rs.getInt("quantity"));
            products.add(pro);
        }

        return products;
    }
    
    @POST
    @Path("/products")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
   
    public void createProduct(@QueryParam("id") int id,@QueryParam("name") String name, @QueryParam("description") String description, @QueryParam("quantity") int quantity) throws SQLException
    {
       Statement smt = conn.createStatement();
        ResultSet rs = smt.executeQuery("INSERT INTO product (productId,name,description,quantity) VALUES ("+id+","+name+","+description+","+quantity+")");
    }
    
    /**
     * PUT method for updating or creating an instance of GenericResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
   @PUT
    @Path("/products")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
   
    public void putProduct(@QueryParam("id") int id,@QueryParam("name") String name, @QueryParam("description") String description, @QueryParam("quantity") int quantity) throws SQLException
    {
       Statement smt = conn.createStatement();
        ResultSet rs = smt.executeQuery("update product set productid ="+id+", name ="+name+", description ="+description+", quantity ="+quantity+" where productid ="+id);
    }
    
}
