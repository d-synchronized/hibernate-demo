package uk.co.techblue.util;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import uk.co.techblue.entity.Employee;

/**
 * The Class HibernateInterceptor.
 */
public class HibernateInterceptor extends EmptyInterceptor {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -654036728280148873L;

    /*
     * (non-Javadoc)
     * 
     * @see org.hibernate.EmptyInterceptor#preFlush(java.util.Iterator)
     */
    @Override
    public void preFlush(@SuppressWarnings("rawtypes") Iterator entities) {
        System.out.println("demo");
        while (entities.hasNext()) {
            final Object object = entities.next();
            if (object instanceof Employee) {
                final Employee employee = (Employee) object;
                employee.onCreate();
            }
        }
    }

    @Override
    public boolean onSave(Object object, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (object instanceof Employee) {
            final Employee employee = (Employee) object;
            employee.onCreate();
        }
        return false;
    }

}
