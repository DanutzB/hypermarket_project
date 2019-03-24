package ro.sda.hypermarket.core.entity;

import ro.sda.hypermarket.core.base.BaseEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employees", schema = "hypermarket")
public class Employee extends BaseEntity {

    @Column(name = "first_name", length = 40, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 40, nullable = false)
    private String lastName;

    @Column(name = "salary", length = 20)
    private Integer salary;

    @Column(name = "job_title", length = 40, nullable = false)
    private String jobTitle;

    @OneToOne
    @JoinColumn (name = "dept_id")
    private Employee manager;

    @Column(name = "city", length = 40, nullable = false)
    private String city;

    @OneToMany(mappedBy = "manager")
    private List<ProductCategory> productCategories;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getId()==(employee.getId()) &&
                firstName.equals(employee.firstName) &&
                lastName.equals(employee.lastName) &&
                salary.equals(employee.salary) &&
                jobTitle.equals(employee.jobTitle) &&
                manager.equals(employee.manager) &&
                city.equals(employee.city) &&
                productCategories.equals(employee.productCategories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), firstName, lastName, salary, jobTitle, manager, city, productCategories);
    }
}
