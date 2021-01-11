package com.william.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "status_member", schema = "flix_william", catalog = "")
public class StatusMemberEntity {
    private int id;
    private String nameStatusMember;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name_status_member")
    public String getNameStatusMember() {
        return nameStatusMember;
    }

    public void setNameStatusMember(String nameStatusMember) {
        this.nameStatusMember = nameStatusMember;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusMemberEntity that = (StatusMemberEntity) o;
        return id == that.id && Objects.equals(nameStatusMember, that.nameStatusMember);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameStatusMember);
    }
}
