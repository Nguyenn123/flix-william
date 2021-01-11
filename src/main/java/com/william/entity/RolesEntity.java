package com.william.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "roles", schema = "flix_william", catalog = "")
public class RolesEntity {
    private int id;
    private String nameRole;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name_role")
    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolesEntity that = (RolesEntity) o;
        return id == that.id && Objects.equals(nameRole, that.nameRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameRole);
    }
}
