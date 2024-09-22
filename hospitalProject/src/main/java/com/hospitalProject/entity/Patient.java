package com.hospitalProject.entity;

import com.hospitalProject.core.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
@Getter
@Setter
public class Patient extends BaseEntity<UUID> {

    private String tcNo;
    private String firstName;
    private String lastName;
    private String password;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments =new ArrayList<>();
}
