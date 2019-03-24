package ro.sda.hypermarket.core.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.Department;
import ro.sda.hypermarket.core.entity.Employee;
@Repository
@Transactional
public class DepartmentDAOImpl implements DepartmentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Department createDepartment(Department department) {
        sessionFactory.getCurrentSession().save(department);
        return department;
    }

    @Override
    public Department readDepartment(Long departmentId) {
        Department department = (Department) sessionFactory.getCurrentSession().get(Department.class, departmentId);
        return department;
    }

    @Override
    public Department updateDepartment(Department department) {

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Department depToBeUpdated = (Department) session.get(Department.class, department.getId());
            depToBeUpdated.setId(department.getId());
            depToBeUpdated.setName(department.getName());
            depToBeUpdated.setManager(department.getManager());
            tx.commit();
        }catch (HibernateException e){
            if(tx!=null)tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return  department;
    }

    @Override
    public void deleteDepartment(Long id) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Department found = (Department) sessionFactory.getCurrentSession().get(Department.class, id);
        sessionFactory.getCurrentSession().delete(found);
        sessionFactory.getCurrentSession().flush();
        tr.commit();

    }




}
