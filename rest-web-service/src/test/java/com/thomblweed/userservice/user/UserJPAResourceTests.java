package com.thomblweed.userservice.user;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class UserJPAResourceTests {

    @InjectMocks
    UserJPAResource userJPAResource;

    @Mock
    UserRepository mockUserRepository;

    @Test
    public void testGetAllUsers() {
        Mockito.when(mockUserRepository.findAll()).thenReturn(mockUsers());

        List<User> userResult = userJPAResource.getAllUsers();

        assertThat(userResult.get(0).getName()).isEqualTo("Thomas");
        assertThat(userResult.get(1).getName()).isEqualTo("Jeff");
    }

    private List<User> mockUsers() {
        User user1 = new User(1, "Thomas", new Date());
        User user2 = new User(1, "Jeff", new Date());
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        return userList;
    }
}
