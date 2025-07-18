package net.edigest.journalApp.repository;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryImplTest {
     @Autowired
    private UserRepositoryImpl userRepositoryImpl;

     @Test
    public void getUserForSATest(){
         Assertions.assertNotNull(userRepositoryImpl.getUsersForSA());
     }
}
