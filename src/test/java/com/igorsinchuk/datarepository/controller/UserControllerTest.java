package com.igorsinchuk.datarepository.controller;

import com.igorsinchuk.datarepository.model.User;
import com.igorsinchuk.datarepository.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserController userController;



    @Test
    public void getAll() throws Exception {
        User user = new User();
        user.setId(3);
        user.setLogin("Login");
        user.setPassword("Password");
        user.setFirstName("Name");
        user.setLastName("Last");

        List<User> userList = singletonList(user);
        given(userController.getAll()).willReturn(userList);

        mockMvc.perform(get("/list/users/")
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.login").value("Login"))
                .andExpect(jsonPath("$.password").value("Password"))
                .andExpect(jsonPath("$.firstName").value("First"))
                .andExpect(jsonPath("$.lastName").value("Last"));


    }

    @Test
    public void getUserById() throws Exception {
        User user = new User();
        user.setId(3);

        given(userController.getUserById(user.getId())).willReturn(user);
        mockMvc.perform(get("/list/users/3" + user.getId())
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$id").value(user.getId()));
    }

    @Test
    public void createUser() {
    }
}