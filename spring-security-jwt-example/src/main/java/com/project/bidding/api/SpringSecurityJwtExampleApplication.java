package com.project.bidding.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.project.bidding.api.controller.WelcomeController;
import com.project.bidding.api.entity.User;
import com.project.bidding.api.repository.UserRepository;

import javax.annotation.PostConstruct;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@ComponentScan("com.project.bidding.api")
public class SpringSecurityJwtExampleApplication {
    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(101, "javatechie", "password", "javatechie@gmail.com"),
                new User(102, "user1", "pwd1", "user1@gmail.com"),
                new User(103, "user2", "pwd2", "user2@gmail.com"),
                new User(104, "user3", "pwd3", "user3@gmail.com")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }

    public static void main(String[] args) {
    	new File(WelcomeController.uploadDirectory).mkdir();
    	new File(WelcomeController.uploadDirectoryForCatalog).mkdir();
        SpringApplication.run(SpringSecurityJwtExampleApplication.class, args);
    }

}
