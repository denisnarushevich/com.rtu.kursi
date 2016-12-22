/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rtu.kursi;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author dnarushevich
 */
public class CourseService {
    
    private EntityManager entityManager;
    
    CourseService(){
        entityManager = Persistence.createEntityManagerFactory("com.rtu.kursi.CoursePU").createEntityManager();
    }
    
    public List<Course> getAllCourses(){
        Query query = entityManager.createNamedQuery("Course.findAll");
        return query.getResultList();
    }
    
    public Course createNew(String name, String place, String author, String dateFrom, String dateTo, Integer maxSeats) {
        //System.out.println("Creating: " + name);
        Course c = new Course();
        
        c.setName(name);
        c.setPlace(place);
        c.setAuthor(author);
        c.setDateFrom(dateFrom);
        c.setDateTo(dateTo);
        c.setMaxSeats(maxSeats);
                
        save(c);
        
        return c;
    }
    
    public void save(Course course){
        if(course != null){
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();  
        }
    }
    
    public void remove(Course course){
        if(course != null){
            entityManager.getTransaction().begin();
            entityManager.remove(course);
            entityManager.getTransaction().commit(); 
        }
    }
}
