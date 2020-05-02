package com.course.work.cdrent.renter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Embeddable
@Table(name = "renter")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RenterEntity {
    @Id
    @Column(name = "num_renter")
    private Integer numRenter;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "tel")
    private String tel;
    @Column(name = "email")
    private String email;
}
