package uk.co.techblue.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The Class ProvidentFundAccount.
 */
@Entity
@Table(name = "pf_account")
public class ProvidentFundAccount {

    /** The pf account id. */
    @Column(name = "pf_account_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pfAccountId;

    /** The fund amount. */
    @Column(name = "amount")
    private Double fundAmount;

    /** The account on. */
    @Column(name = "account_on")
    private Date accountOn;

    /** The employee. */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "providentFundAccount", cascade = CascadeType.ALL)
    private Employee employee;

    /**
     * Gets the pf account id.
     * 
     * @return the pf account id
     */
    public Long getPfAccountId() {
        return pfAccountId;
    }

    /**
     * Sets the pf account id.
     * 
     * @param pfAccountId the new pf account id
     */
    public void setPfAccountId(Long pfAccountId) {
        this.pfAccountId = pfAccountId;
    }

    /**
     * Gets the fund amount.
     * 
     * @return the fund amount
     */
    public Double getFundAmount() {
        return fundAmount;
    }

    /**
     * Sets the fund amount.
     * 
     * @param fundAmount the new fund amount
     */
    public void setFundAmount(Double fundAmount) {
        this.fundAmount = fundAmount;
    }

    /**
     * Gets the account on.
     * 
     * @return the account on
     */
    public Date getAccountOn() {
        return accountOn;
    }

    /**
     * Sets the account on.
     * 
     * @param accountOn the new account on
     */
    public void setAccountOn(Date accountOn) {
        this.accountOn = accountOn;
    }

    /**
     * Gets the employee.
     * 
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Sets the employee.
     * 
     * @param employee the new employee
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
