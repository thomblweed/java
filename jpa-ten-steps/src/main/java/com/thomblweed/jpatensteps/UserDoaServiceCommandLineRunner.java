package com.thomblweed.jpatensteps;

import com.thomblweed.jpatensteps.entity.User;
import com.thomblweed.jpatensteps.service.UserDOAService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDoaServiceCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(UserDoaServiceCommandLineRunner.class);

    @Autowired
    private UserDOAService userDoaService;

    @Override
    public void run(String... args) throws Exception {
      // TODO Auto-generated method stub
      User user = new User("Jack", "Admin");
      long insert = userDoaService.insert(user);
      log.info("New User is created : " + user);
    }
}