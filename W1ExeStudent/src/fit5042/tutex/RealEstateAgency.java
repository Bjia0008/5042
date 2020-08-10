package fit5042.tutex;

import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.PropertyRepositoryFactory;
import fit5042.tutex.repository.entities.Property;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Bohan
 */
public class RealEstateAgency {
    private String name;
    private final PropertyRepository propertyRepository;

    public RealEstateAgency(String name) throws Exception {
        this.name = name;
        this.propertyRepository = PropertyRepositoryFactory.getInstance();
    }
    
    // this method is for initializing the property objects
    // complete this method
    public void createProperty() throws Exception {
    	this.propertyRepository.addProperty(new Property(1, "24 Boston Ave, Malvern East VIC 3145, Australia", 2, 150, 420000));
        this.propertyRepository.addProperty(new Property(2, "11 Bettina St, Clayton VIC 3168, Australia", 3, 352, 360000));
        this.propertyRepository.addProperty(new Property(3, "3 Wattle Ave, Glen Huntly VIC 3163, Australia", 5, 800, 650000));
        this.propertyRepository.addProperty(new Property(4, "3 Hamilton St, Bentleigh VIC 3204, Australia", 2, 170, 435000));
        this.propertyRepository.addProperty(new Property(5, "82 Spring Rd, Hampton East VIC 3188, Australia", 1, 60, 820000));
    	System.out.println("5 properties added succeassfully");
    }
    
    // this method is for displaying all the properties
    // complete this method
    public void displayProperties() throws Exception {
    	List<Property> properties  = propertyRepository.getAllProperties();
    	for (Property p : properties) {
			System.out.println(p.getId() + " " + p.getAddress() +  " " + p.getNumberOfBedrooms() + "BR(s)" 
    	+ (double)p.getSize()+ "sqm" + " $" + p.getPrice());
		}
    }
    
    // this method is for searching the property by ID
    // complete this method
    public void searchPropertyById(int id) throws Exception {
    	Property p = propertyRepository.searchPropertyById(id);
    	System.out.println(p.getId() + " " + p.getAddress() +  " " + p.getNumberOfBedrooms() + "BR(s)" 
    	    	+ (double)p.getSize()+ "sqm" + " $" + p.getPrice());
    }
    
    public void run() throws Exception {
        createProperty();
        System.out.println("********************************************************************************");
        displayProperties();
        System.out.println("********************************************************************************");
        System.out.print("Enter the ID of the proprety you want to search:");
        Scanner sc = new Scanner(System.in);
        int id = Integer.parseInt(sc.nextLine());
        searchPropertyById(id);
    }
    
    public static void main(String[] args) {
        try {
            new RealEstateAgency("FIT5042 Real Estate Agency").run();
        } catch (Exception ex) {
            System.out.println("Application fail to run: " + ex.getMessage());
        }
    }
}
