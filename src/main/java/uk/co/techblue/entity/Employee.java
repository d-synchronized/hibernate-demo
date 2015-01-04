package uk.co.techblue.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.id.uuid.CustomVersionOneStrategy;

// TODO: Auto-generated Javadoc
/**
 * The Class Employee.
 */
@Entity
@Table(name = "employee")
// @EntityListeners({ PreInsertListener.class })
public class Employee {

    /** The employee id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id", unique = true)
    private long employeeId;

    /** The employee uuid. */
    @Column(name = "employee_uuid", nullable = false)
    private String employeeUuid;

    /** The first name. */
    @Column(name = "first_name", nullable = false, length = 10)
    private String firstName;

    /** The last name. */
    @Column(name = "last_name", nullable = false, length = 10)
    private String lastName;

    /** The date of birth. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dob", nullable = false)
    private Date dateOfBirth;

    /**
     * Mappeed by here signifies this class as the owner of the relation ship and all the update to that entity follows from
     * here.
     */
    @OneToMany(cascade = { CascadeType.ALL })
    @JoinColumn(name = "address_id")
    private Set<Address> addresses;
    
    /** The provident fund account. */
    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "pf_account_id")
    private ProvidentFundAccount providentFundAccount;


    /**
     * On create.
     */
    @PrePersist
    public void onCreate() {
        final CustomVersionOneStrategy versionOneStrategy = new CustomVersionOneStrategy();
        employeeUuid = versionOneStrategy.generateUUID(null).toString();
    }

    /**
     * Gets the employee id.
     * 
     * @return the employee id
     */
    public long getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the employee id.
     * 
     * @param employeeId the new employee id
     */
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Gets the first name.
     * 
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     * 
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     * 
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     * 
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the date of birth.
     * 
     * @return the date of birth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth.
     * 
     * @param dateOfBirth the new date of birth
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the employee uuid.
     * 
     * @return the employee uuid
     */
    public String getEmployeeUuid() {
        return employeeUuid;
    }

    /**
     * Sets the employee uuid.
     * 
     * @param employeeUuid the new employee uuid
     */
    public void setEmployeeUuid(String employeeUuid) {
        this.employeeUuid = employeeUuid;
    }

    /**
     * Gets the addresses.
     * 
     * @return the addresses
     */
    public Set<Address> getAddresses() {
        return addresses;
    }

    /**
     * Sets the addresses.
     * 
     * @param addresses the new addresses
     */
    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

	/**
	 * Gets the provident fund account.
	 *
	 * @return the provident fund account
	 */
	public ProvidentFundAccount getProvidentFundAccount() {
		return providentFundAccount;
	}

	/**
	 * Sets the provident fund account.
	 *
	 * @param providentFundAccount the new provident fund account
	 */
	public void setProvidentFundAccount(ProvidentFundAccount providentFundAccount) {
		this.providentFundAccount = providentFundAccount;
	}

}
