package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "LinkedPurchaseList")
@Getter
@Setter
public class LinkedPurchaseList {

    @EmbeddedId
    private LinkedPurchaseListKey linkedPurchaseListKey;

    @Column(name = "student_id",insertable = false,updatable = false)
    private int studentId;

    @Column(name = "course_id",insertable = false,updatable = false)
    private int courseId;


}
