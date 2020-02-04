package com.siva.Jpa;

import com.siva.Jpa.dao.Repo;
import com.siva.Jpa.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	Repo repo;
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		logger.info("By id--->{}",repo.findbyId(101));
//		repo.delete(101);
//		logger.info("insert --->{}",repo.insert(new Course("React.js")));
//		logger.info("update-->{}",repo.update(new Course(102,"jdbc")));
		//repo.playwithentityManger();
		//logger.info("Basic Jpql query-->{}",repo.jpql_basic());
		//logger.info("Typed Jpql query-->{}",repo.jpql_typed());
		logger.info("Where Jpql query-->{}",repo.jqpl_where());

	}
}
