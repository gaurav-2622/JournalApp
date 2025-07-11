package net.edigest.journalApp.service;

import net.edigest.journalApp.entity.User;
import net.edigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@SpringBootTest public class UserDetailsServiceImplTests {

    @InjectMocks
    private  UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    @Disabled
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Disabled
    public void loadUserByUsernameTest(){
        when(userRepository.findByuserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("Ram").password("fbcebf").roles(new ArrayList<>()).build());
        UserDetails user = userDetailsService.loadUserByUsername("Ram");
        Assertions.assertNotNull(user);
    }
}
