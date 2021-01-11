package com.william.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "status", schema = "flix_william", catalog = "")
public class StatusEntity {
    private int id;
    private String nameStatus;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name_status")
    public String getNameStatus() {
        return nameStatus;
    }

    public void setNameStatus(String nameStatus) {
        this.nameStatus = nameStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusEntity that = (StatusEntity) o;
        return id == that.id && Objects.equals(nameStatus, that.nameStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameStatus);
    }
}
