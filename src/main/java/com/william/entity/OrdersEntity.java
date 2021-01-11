package com.william.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "orders", schema = "flix_william", catalog = "")
public class OrdersEntity {
    private int id;
    private int accountId;
    private int productId;
    private Timestamp dateOrdered;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "accountId")
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "productId")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "date_Ordered")
    public Timestamp getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(Timestamp dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return id == that.id && accountId == that.accountId && productId == that.productId && Objects.equals(dateOrdered, that.dateOrdered);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, productId, dateOrdered);
    }
}
