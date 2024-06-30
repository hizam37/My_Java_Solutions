package org.example;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "PurchaseList")
public class PurchaseList {

    @EmbeddedId
    private PurchaseListKey purchaseListKey;


    @Column(name = "student_name",insertable = false,updatable = false)
    private String studentName;

    @Column(name = "course_name",insertable = false,updatable = false)
    private String courseName;


    @Column(name = "price")
    private int price;

    @Column(name = "subscription_date")
    private Timestamp subscriptiondate;

}
