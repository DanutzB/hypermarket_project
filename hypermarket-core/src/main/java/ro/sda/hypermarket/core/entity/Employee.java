package ro.sda.hypermarket.core.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employees", schema = "hypermarket")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 40, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 40, nullable = false)
    private String lastName;

    @Column(name = "salary", length = 20)
    private Integer salary;

    @Column(name = "job_title", length = 40, nullable = false)
    private String jobTitle;

    @ManyToOne
    @JoinColumn (name = "dept_id")
    private Department department;

    @Column(name = "city", length = 40, nullable = false)
    private String city;

    @OneToOne
    @JoinColumn (name = "manager_id")
    private Employee employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee1 = (Employee) o;
        return id.equals(employee1.id) &&
                firstName.equals(employee1.firstName) &&
                lastName.equals(employee1.lastName) &&
                salary.equals(employee1.salary) &&
                jobTitle.equals(employee1.jobTitle) &&
                department.equals(employee1.department) &&
                city.equals(employee1.city) &&
                employee.equals(employee1.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, salary, jobTitle, department, city, employee);
    }
}
