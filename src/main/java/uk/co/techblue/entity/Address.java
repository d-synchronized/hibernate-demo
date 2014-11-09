package uk.co.techblue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class Address.
 */
@Entity
@Table(name="address")
public class Address {

    /** The address id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private int addressId;

    /** The house number. */
    @Column(name = "house_number")
    private String houseNumber;

    /** The house name. */
    @Column(name = "house_namne")
    private String houseName;

    /** The postcode. */
    @Column(name = "postcode")
    private String postcode;

    /**
     * Join column is used to map the relationship
     * */
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    /**
     * Gets the address id.
     * 
     * @return the address id
     */
    public int getAddressId() {
        return addressId;
    }

    /**
     * Sets the address id.
     * 
     * @param addressId the new address id
     */
    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    /**
     * Gets the house number.
     * 
     * @return the house number
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * Sets the house number.
     * 
     * @param houseNumber the new house number
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * Gets the house name.
     * 
     * @return the house name
     */
    public String getHouseName() {
        return houseName;
    }

    /**
     * Sets the house name.
     * 
     * @param houseName the new house name
     */
    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    /**
     * Gets the postcode.
     * 
     * @return the postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Sets the postcode.
     * 
     * @param postcode the new postcode
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
