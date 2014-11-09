package uk.co.techblue.util;

import java.util.Arrays;
import java.util.List;

import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.hibernate.id.uuid.CustomVersionOneStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.techblue.entity.Employee;

/**
 * The listener interface for receiving preInsert events. The class that is interested in processing a preInsert event
 * implements this interface, and the object created with that class is registered with a component using the component's
 * <code>addPreInsertListener<code> method. When
 * the preInsert event occurs, that object's appropriate
 * method is invoked.
 * 
 * @see PreInsertEvent
 */
public class PreInsertListener implements PreInsertEventListener {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 477236219207943908L;

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    /*
     * (non-Javadoc)
     * 
     * @see org.hibernate.event.spi.PreInsertEventListener#onPreInsert(org.hibernate.event.spi.PreInsertEvent)
     */
    @Override
    public boolean onPreInsert(PreInsertEvent preInsertEvent) {
        LOGGER.info("Hibernate Event Listener succesfully invoked");
        if (preInsertEvent.getEntity() instanceof Employee) {
            final Employee employee=(Employee)preInsertEvent.getEntity();
            final String[] propertyNames = preInsertEvent.getPersister().getEntityMetamodel().getPropertyNames();
            final List<String> propertiesList = Arrays.asList(propertyNames);
            if (propertiesList != null && propertiesList.size() > 0 && propertiesList.contains("employeeUuid")) {
                LOGGER.info("About to set the employee uuid for the entity type Employee");
                final CustomVersionOneStrategy versionOneStrategy = new CustomVersionOneStrategy();
                final String employeeUuid = versionOneStrategy.generateUUID(null).toString();
                employee.setEmployeeUuid(employeeUuid);
//                preInsertEvent.getState()[propertiesList.indexOf("employeeUuid")] = employeeUuid;
                System.out.println("Demo");
            }
        }
        return false;
    }

}