package uk.co.techblue.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import uk.co.techblue.entity.Address;
import uk.co.techblue.entity.Employee;
import uk.co.techblue.entity.ProvidentFundAccount;
import uk.co.techblue.exception.CustomException;
import uk.co.techblue.manager.EmployeeManager;

/**
 * The Class HibernateTestApplication.
 */
public class HibernateTestApplication {

    /**
     * The main method.
     * 
     * @param args the arguments
     */
    public static void main(final String args[]) {
        final Employee employee = new Employee();
        employee.setFirstName("Dishant");
        employee.setLastName("Anand");
        employee.setDateOfBirth(new Date());

        final Address address = new Address();
        address.setEmployee(employee);
        address.setHouseName("St Andrews Street");
        address.setHouseNumber("70");
        address.setPostcode("LN57UG");
        
        final Set<Address> addresses = new HashSet<Address>();
        addresses.add(address);
        employee.setAddresses(addresses);
        
        final ProvidentFundAccount providentFundAccount=new ProvidentFundAccount();
        providentFundAccount.setEmployee(employee);
        providentFundAccount.setAccountOn(new Date());
        providentFundAccount.setFundAmount(2000D);
        
        employee.setProvidentFundAccount(providentFundAccount);

        try {
            // saves the employer details
            EmployeeManager.saveEmployeeDetails(employee);

            // gets the employer details
            final Employee employeeData = EmployeeManager.getEmployeeById(employee.getEmployeeId());
            System.out.println(employeeData.getFirstName());

            // gets the employer details
            final String employeeFirstName = EmployeeManager.getEmployeeNameById(employee.getEmployeeId());
            System.out.println(employeeFirstName);
        } catch (final CustomException customException) {
            customException.printStackTrace();
        }

    }

}
