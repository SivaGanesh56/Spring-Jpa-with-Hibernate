package com.siva.Jpa.dao;

import com.siva.Jpa.JpaApplication;
import com.siva.Jpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = JpaApplication.class)
class RepoTest
{


    @Autowired
    Repo repo;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    void findbyId()
    {

        System.out.println(repo);
        assertEquals("Docker",repo.findbyId(104).getName());
    }

    @Test
    @DirtiesContext
    void delete()
    {
        repo.delete(102);
        assertNull(repo.findbyId(102));
    }

    @Test
    @DirtiesContext
    void insert()
    {
        Course course = repo.findbyId(104);
        course.setName("Nifi");
        repo.update(course);
        Course course1 = repo.findbyId(104);
        assertEquals("Nifi",course1.getName());

    }

     public void playwithentityManger()
    {
        Course course1 = new Course("Angular js");
        repo.insert(course1);
        Course course2 = new Course("Node js");
        repo.insert(course2);
        em.flush();
//        em.detach(course1);
//        em.detach(course2);
        em.clear();
        course1.setName("Angular js--Updated");
        course2.setName("Node js js--Updated");
        em.flush();
    }
}