package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class LinkedPurchaseListKey implements Serializable {

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id",unique = true)
    private int courseId;


}
