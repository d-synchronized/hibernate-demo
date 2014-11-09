package uk.co.techblue.util;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.event.spi.SaveOrUpdateEventListener;

import uk.co.techblue.entity.Employee;

/**
 * The listener interface for receiving saveUpdateEvent events. The class that is interested in processing a saveUpdateEvent
 * event implements this interface, and the object created with that class is registered with a component using the component's
 * <code>addSaveUpdateEventListener<code> method. When
 * the saveUpdateEvent event occurs, that object's appropriate
 * method is invoked.
 * 
 * @see SaveUpdateEventEvent
 */
public class SaveUpdateEventListener implements SaveOrUpdateEventListener {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2878497336541029931L;

    /*
     * (non-Javadoc)
     * 
     * @see org.hibernate.event.spi.SaveOrUpdateEventListener#onSaveOrUpdate(org.hibernate.event.spi.SaveOrUpdateEvent)
     */
    @Override
    public void onSaveOrUpdate(SaveOrUpdateEvent saveOrUpdateEvent) throws HibernateException {
        System.out.println("demo");
        if (saveOrUpdateEvent.getEntity() instanceof Employee) {
            final Employee employee = (Employee) saveOrUpdateEvent.getEntity();
            final String employeeUuid = "Demo";
            employee.setEmployeeUuid(employeeUuid);
        }
    }

}
