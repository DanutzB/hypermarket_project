package ro.sda.hypermarket.core.entity;

import ro.sda.hypermarket.core.base.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "suppliers", schema = "hypermarket")
public class Supplier extends BaseEntity {

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @Column(name = "contact_no", length = 20, nullable = false)
    private String contactNo;

    @Column(name = "city", length = 30)
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(getId(), supplier.getId()) &&
                Objects.equals(name, supplier.name) &&
                Objects.equals(contactNo, supplier.contactNo) &&
                Objects.equals(city, supplier.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name, contactNo, city);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Supplier{");
        sb.append("id=").append(getId());
        sb.append(", products=").append(products);
        sb.append(", name='").append(name).append('\'');
        sb.append(", contactNo='").append(contactNo).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
