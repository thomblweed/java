package com.thomblweed.userservice.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Links;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class UserJPAResourceTests {

    @InjectMocks
    UserJPAResource userJPAResource;

    @Mock
    UserRepository mockUserRepository;

    @Test
    public void testGetAllUsers() {
        User user1 = new User(1, "Thomas", new Date());
        User user2 = new User(2, "Jeff", new Date());
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        Mockito.when(mockUserRepository.findAll()).thenReturn(userList);

        List<User> userResult = userJPAResource.getAllUsers();

        assertThat(userResult.get(0).getName()).isEqualTo("Thomas");
        assertThat(userResult.get(1).getName()).isEqualTo("Jeff");
    }

    @Test
    public void testGetUserById() throws Exception {
        User user = new User(1, "Thomas", new Date());
        Optional<User> optionalUser = Optional.of(user);

        Mockito.when(mockUserRepository.findById(1)).thenReturn(optionalUser);

        EntityModel<User> expected = EntityModel.of(optionalUser.get());

        EntityModel<User> response = userJPAResource.getUserById(1);

        User responseUser = response.getContent();
        Links responseLinks = response.getLinks();

        assertThat(responseUser).isEqualTo(expected.getContent());
        assertThat(responseUser.getName()).isEqualTo("Thomas");
        assertThat(responseUser.getId()).isEqualTo(1);
        assertThat(responseLinks.hasLink("all-users")).isTrue();
        assertThat(responseLinks.getRequiredLink("all-users").getHref())
                .isEqualTo("/users/jpa/getAll");
    }
}
