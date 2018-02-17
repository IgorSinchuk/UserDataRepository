package com.igorsinchuk.datarepository.service;

import com.igorsinchuk.datarepository.model.User;
import com.igorsinchuk.datarepository.repository.UserRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @TestConfiguration
    public class UserServiceImplTestContextConfiguration {

        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }
    }

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void setUp() {
        User igor = new User("1", "2", "Igor", "Sinchuk");
        User found = userService.getUserById(1);
    }
}
