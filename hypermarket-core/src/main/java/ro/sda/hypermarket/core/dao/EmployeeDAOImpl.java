package ro.sda.hypermarket.core.dao;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.Employee;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createEmployee(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }
    @Override
    public Employee readEmployee(Long employeeId) {
        Employee employee = (Employee) sessionFactory.getCurrentSession().get(Employee.class, employeeId);
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Employee empToBeUpdated = (Employee) session.get(Employee.class, employee.getId());
            empToBeUpdated.setSalary(employee.getSalary());
            empToBeUpdated.setJobTitle(employee.getJobTitle());
            empToBeUpdated.setFirstName(employee.getFirstName());
            empToBeUpdated.setLastName(employee.getLastName());
            empToBeUpdated.setCity(employee.getCity());
            empToBeUpdated.setId(employee.getId());
            empToBeUpdated.setManager(employee.getManager());
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null)tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

   @Override
   public Employee deleteEmployee(Long id) {
       Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
       Employee found = (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
       sessionFactory.getCurrentSession().delete(found);
       sessionFactory.getCurrentSession().flush();
       tr.commit();
       return found;
   }


}
