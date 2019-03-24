package ro.sda.hypermarket.core.entity;

import ro.sda.hypermarket.core.base.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "departments", schema = "hypermarket")
public class Department extends BaseEntity {

    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return getId()==(that.getId()) &&
                getName().equals(that.getName()) &&
                manager.equals(that.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), manager);
    }



}
