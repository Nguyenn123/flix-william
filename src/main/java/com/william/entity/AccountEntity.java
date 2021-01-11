package com.william.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "account", schema = "flix_william", catalog = "")
public class AccountEntity {
    private int id;
    private String username;
    private String password;
    private String email;
    private Integer phoneNumber;
    private Integer role;
    private Integer statusAccount;
    private Integer statusMember;
    private Timestamp createTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone_number")
    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "role")
    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Basic
    @Column(name = "status_account")
    public Integer getStatusAccount() {
        return statusAccount;
    }

    public void setStatusAccount(Integer statusAccount) {
        this.statusAccount = statusAccount;
    }

    @Basic
    @Column(name = "status_member")
    public Integer getStatusMember() {
        return statusMember;
    }

    public void setStatusMember(Integer statusMember) {
        this.statusMember = statusMember;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountEntity that = (AccountEntity) o;
        return id == that.id && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(email, that.email) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(role, that.role) && Objects.equals(statusAccount, that.statusAccount) && Objects.equals(statusMember, that.statusMember) && Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, phoneNumber, role, statusAccount, statusMember, createTime);
    }
}
