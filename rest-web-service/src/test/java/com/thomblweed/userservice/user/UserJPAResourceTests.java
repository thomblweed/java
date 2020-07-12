package com.thomblweed.userservice.user;

import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest
class UserJPAResourceTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserRepository mockUserRepository;

    @MockBean
    PostRepository mockPostRepository;

    @Test
    public void getUserById() throws Exception {

        Mockito.when(mockUserRepository.findAll()).thenReturn(Collections.emptyList());
        
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/users/jpa/getAll").accept(MediaType.APPLICATION_JSON))
                .andReturn();

        System.out.println(mvcResult);

        Mockito.verify(mockUserRepository).findAll();
    }
}
