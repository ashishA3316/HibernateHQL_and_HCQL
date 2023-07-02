package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="product_info")
public class Product {
    public Product() {
    }

    public Product(int productID, String productName, double productPrice, String productCategory) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
    }

    @Id
    @Column(name = "product_id")
    private int productID;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_price")
    private double productPrice;
    @Column(name = "category")
    private String productCategory;

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public String toString() {
        return productID+"\t"+productName+"\t"+productPrice+"\t"+productCategory;
    }
}
