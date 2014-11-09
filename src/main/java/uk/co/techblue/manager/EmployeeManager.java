package uk.co.techblue.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.techblue.dao.EmployeeDao;
import uk.co.techblue.entity.Address;
import uk.co.techblue.entity.Employee;
import uk.co.techblue.exception.CustomException;

/**
 * The Class EmployeeManager.
 */
public class EmployeeManager {

    /** The logger. */
    private static Logger LOGGER = LoggerFactory.getLogger(EmployeeManager.class);

    /**
     * Save address.
     * 
     * @param address the address
     * @return the boolean
     * @throws CustomException the custom exception
     */
    public static Boolean saveAddress(final Address address) throws CustomException {
        boolean addressSaved = false;
        try {
            addressSaved = EmployeeDao.saveAddress(address);
        } catch (final Exception exception) {
            LOGGER.error("Error occured while saving the address details for the employee", exception);
            throw new CustomException("Error occured while saving the address details for the employee, Error-"
                    + exception.getMessage());
        }
        return addressSaved;
    }

    /**
     * Save.
     * 
     * @param employee the employee
     * @return the boolean
     * @throws CustomException the custom exception
     */
    public static Boolean saveEmployeeDetails(final Employee employee) throws CustomException {
        boolean employeeDetailsSaved = false;
        try {
            employeeDetailsSaved = EmployeeDao.saveEmployeeDetails(employee);
            LOGGER.info("Employee details for user {} successfully saved.", employee.getFirstName());
        } catch (final Exception exception) {
            LOGGER.error("Error occured while saving the employee details", exception);
            throw new CustomException("Error occured while saving the employee details, Error-" + exception.getMessage());
        }
        return employeeDetailsSaved;
    }

    /**
     * Gets the employee name by id.
     * 
     * @param employeeId the employee id
     * @return the employee name by id
     * @throws CustomException the custom exception
     */
    public static String getEmployeeNameById(final Long employeeId) throws CustomException {
        LOGGER.info("About to obtain the emplyer first name from the database for the employer Id {}", employeeId);
        String employerName = null;
        try {
            employerName = EmployeeDao.getEmployeeNameById(employeeId);
            LOGGER.info("employer detail for the employerId {} has been obtained successfully", employeeId);
        } catch (final Exception exception) {
            LOGGER.error("Error occured while retriving the employer details for employee Id '{}'", employeeId, exception);
            throw new CustomException("rror occured while retriving the employer details for employee Id '" + employeeId
                    + "' , Error-" + exception.getMessage());
        }
        return employerName;
    }

    /**
     * Gets the employee by id.
     * 
     * @param employeeId the employee id
     * @return the employee by id
     * @throws CustomException the custom exception
     */
    public static Employee getEmployeeById(final Long employeeId) throws CustomException {
        Employee employee = null;
        try {
            employee = EmployeeDao.getEmployeeById(employeeId);
            LOGGER.info("Employer details againt the employer Id {} successfully obtained", employeeId);
        } catch (final Exception exception) {
            LOGGER.error("Error occured while retriving the employer details for employee Id '{}'", employeeId, exception);
            throw new CustomException("Error occured while retriving the employer details for employee Id '" + employeeId
                    + "' , Error-" + exception.getMessage());
        }
        return employee;
    }

}
