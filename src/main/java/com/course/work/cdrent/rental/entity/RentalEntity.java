package com.course.work.cdrent.rental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Embeddable
@Table(name = "rental")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RentalEntity {
    @Id
    @Column(name = "num_rental")
    private Integer numRental;
    @Column(name = "num_cd")
    private Integer numCd;
    @Column(name = "num_renter")
    private Integer numRenter;
    @Column(name = "date_rental")
    private Date dateRental;
}
