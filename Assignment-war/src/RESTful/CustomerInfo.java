package RESTful;

import javax.ejb.EJB;
import javax.el.ELContext;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;

import fit5042.tutex.mbeans.CustomerContactManagedBean;
import fit5042.tutex.repository.ContactAndCustomerRepository;

@Path("greeting")
public class CustomerInfo {
    @SuppressWarnings("unused")
    @Context
    private UriInfo context;

    @EJB
    ContactAndCustomerRepository contactAndCustomerRepository;
    
    /**
     * Default constructor. 
     */
    public CustomerInfo() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retrieves representation of an instance of CustomerInfo
     * @return an instance of String
     */
    @GET
    @Path("findCustomerById/{cId}")
    @Produces("text/html")
    public String getHtml(@PathParam ("cId") Integer cId) {
        // TODO return proper representation object
    	String scale;
    	String name;
    	String purchasedProductName;
    	String country;
    	String city;
    	String industry;
    	String address;
		String[] resultList = {};
		try {
			String result = contactAndCustomerRepository.searchCustomerById(cId).toString(); 
			resultList = result.split("\\-");
            scale = resultList[1].trim();
            name = resultList[2].trim();
            purchasedProductName = resultList[3].trim();
            country = resultList[4].trim();
            city = resultList[5].trim();
            industry = resultList[6].trim();
            address = resultList[7].trim();
    		
    	return "<html><title>GET Result</title> <body><h1>GET Result </h1><p> </p><h3> Customer Id: " + cId + "<br>Company Scale: " + scale + "<br> Name: " + name + "<br> Purchased Product Name: "           
    	       + purchasedProductName + "<br> Country: " + country + "<br> City: " + city + "<br> Industry: " + industry + "<br> Address: " + address
    	        + "</h3></body></html>";
    	
    	}catch(Exception e) {
    		
    	}
    	return "<html><body><h1>Hello " + " No Result" + "!</h1></body></html>";
    }

    /**
     * PUT method for updating or creating an instance of CustomerInfo
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
	/*
	 * @PUT
	 * 
	 * @Consumes("text/html") public void putHtml(String content) { }
	 */

}