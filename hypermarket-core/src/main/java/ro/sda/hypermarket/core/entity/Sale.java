package ro.sda.hypermarket.core.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sales", schema = "hypermarket")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "purchase_number", nullable = false)
    private Long purchaseNumber;

    @Column(name = "purchase_value", nullable = false)
    private Long purchaseValue;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client clientId;

    @Column(name = "employee_id")
    private Long employeeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(Long purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public Long getPurchaseValue() {
        return purchaseValue;
    }

    public void setPurchaseValue(Long purchaseValue) {
        this.purchaseValue = purchaseValue;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return id.equals(sale.id) &&
                purchaseNumber.equals(sale.purchaseNumber) &&
                purchaseValue.equals(sale.purchaseValue) &&
                clientId.equals(sale.clientId) &&
                employeeId.equals(sale.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, purchaseNumber, purchaseValue, clientId, employeeId);
    }
}
