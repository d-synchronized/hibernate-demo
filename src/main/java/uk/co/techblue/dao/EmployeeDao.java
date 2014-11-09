package uk.co.techblue.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.techblue.entity.Address;
import uk.co.techblue.entity.Employee;
import uk.co.techblue.manager.EmployeeManager;
import uk.co.techblue.util.HibernateUtil;

public class EmployeeDao {

    /** The logger. */
    private static Logger LOGGER = LoggerFactory.getLogger(EmployeeManager.class);

    public static Boolean saveAddress(final Address address) {
        LOGGER.info("Saving the Address details into the database");
        Session session = null;
        Long addressId = null;
        try {
            session = HibernateUtil.getHibernateSession();
            final Transaction transaction = session.beginTransaction();
            addressId = (Long) session.save(address);
            transaction.commit();
        } finally {
            session.close();
        }
        if (addressId == null) {
            return false;
        }
        return true;
    }

    /**
     * Save.
     * 
     * @param employee the employee
     * @return the boolean
     */
    public static Boolean saveEmployeeDetails(final Employee employee) {
        LOGGER.info("Saving the employee details into the database");
        final Session session = HibernateUtil.getHibernateSession();
        Long employeeId = null;
        try {
            final Transaction transaction = session.beginTransaction();
            employeeId = (Long) session.save(employee);
            transaction.commit();
            LOGGER.info("Employee details for user {} successfully saved.", employee.getFirstName());
        } finally {
            session.close();
        }
        if (employeeId == null) {
            return false;
        }
        return true;
    }

    /**
     * Gets the employee name by id.
     * 
     * @param employeeId the employee id
     * @return the employee name by id
     */
    public static String getEmployeeNameById(final Long employeeId) {
        LOGGER.info("About to obtain the emplyer first name from the database for the employer Id {}", employeeId);
        final Session session = HibernateUtil.getHibernateSession();
        String employerName = null;
        try {
            final Criteria employeeRoot = session.createCriteria(Employee.class, "employee");
            // get the value of only a particular column
            final ProjectionList projections = Projections.projectionList();
            projections.add(Projections.property("employee.firstName"), "firstName");
            employeeRoot.setProjection(projections);
            // where clause
            employeeRoot.add(Restrictions.eq("employee.employeeId", employeeId));
            // shape the criteria query results to hibernate bean
            employerName = (String) employeeRoot.uniqueResult();
            LOGGER.info("employer detail for the employerId {} has been obtained successfully", employeeId);
        } finally {
            session.close();
        }
        return employerName;
    }

    /**
     * Gets the employee by id.
     * 
     * @param employeeId the employee id
     * @return the employee by id
     */
    public static Employee getEmployeeById(final Long employeeId) {
        LOGGER.info("About to obtain the emplyer details from the database for the employer Id {}", employeeId);
        final Session session = HibernateUtil.getHibernateSession();
        Employee employee = null;
        try {
            final String jpqlQuery = "From Employee employee where employee.employeeId=:employeeId";
            final Query query = session.createQuery(jpqlQuery);
            query.setParameter("employeeId", employeeId);
            employee = (Employee) query.uniqueResult();
            LOGGER.info("Employer details againt the employer Id {} successfully obtained", employeeId);
        } finally {
            session.close();
        }
        return employee;
    }

}
