package com.siva.Jpa.dao;

import com.siva.Jpa.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class Repo
{
    @Autowired
    EntityManager em;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public Course findbyId(int id)
    {
        return em.find(Course.class,id);
    }


    public Course insert(Course course)
    {
       em.persist(course);
       return course;
    }

    public Course update(Course course)
    {
       em.merge(course);
       return course;
    }

    public void delete(int id)
    {
        Course course = findbyId(id);
        em.remove(course);
    }

    public List jpql_basic()
    {
        Query query = em.createQuery("select x from Course x");
        return query.getResultList();
    }

    public List jpql_typed()
    {
        TypedQuery typedQuery = em.createQuery("select y from Course y",Course.class);
        List resultList = typedQuery.getResultList();
        return resultList;
    }

    public List jqpl_where()
    {
        TypedQuery typedQuery = em.createQuery("select x from Course x where name like '%Steps' ",Course.class);
        List resultList = typedQuery.getResultList();
        return resultList;
    }
}
