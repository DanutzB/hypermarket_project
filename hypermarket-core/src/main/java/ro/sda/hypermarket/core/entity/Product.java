package ro.sda.hypermarket.core.entity;

import ro.sda.hypermarket.core.base.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="products", schema = "hypermarket")
public class Product extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "supplier_price", nullable = false)
    private Integer supplierPrice;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn (name = "supplier_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn (name = "category_id")
    private ProductCategory productCategory;

    @Column(name = "vending_price", nullable = false)
    private Integer vendingPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSupplierPrice() {
        return supplierPrice;
    }

    public void setSupplierPrice(Integer supplierPrice) {
        this.supplierPrice = supplierPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Integer getVendingPrice() {
        return vendingPrice;
    }

    public void setVendingPrice(Integer vendingPrice) {
        this.vendingPrice = vendingPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getId() ==(product.getId()) &&
                name.equals(product.name) &&
                supplierPrice.equals(product.supplierPrice) &&
                stock.equals(product.stock) &&
                supplier.equals(product.supplier) &&
                productCategory.equals(product.productCategory) &&
                vendingPrice.equals(product.vendingPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name, supplierPrice, stock, supplier, productCategory, vendingPrice);
    }
}
