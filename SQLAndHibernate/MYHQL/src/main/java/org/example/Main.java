package org.example;


import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();


        String hql = "SELECT s.id AS student_id, c.id AS course_id " +
                "FROM Students s " +
                "INNER JOIN PurchaseList p ON s.name = p.studentName " +
                "INNER JOIN Courses c ON c.name = p.courseName " +
                "ORDER by student_id ASC";

        Query query = session.createQuery(hql);
        List<Object[]> results = query.getResultList();
        Set<Integer> uniqueCourseIds = new HashSet<>();

        for (Object[] column : results) {
            Integer studentId = (Integer) column[1];
            Integer courseId = (Integer) column[0];

            LinkedPurchaseListKey key = new LinkedPurchaseListKey();
            key.setStudentId(studentId);
            if (!uniqueCourseIds.contains(courseId)) {
                key.setCourseId(courseId);

                LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
                linkedPurchaseList.setLinkedPurchaseListKey(key);
                linkedPurchaseList.setStudentId(key.getStudentId());
                linkedPurchaseList.setCourseId(key.getCourseId());

                session.persist(linkedPurchaseList);

                uniqueCourseIds.add(courseId);
            }
        }

        transaction.commit();
        session.close();
    }
}