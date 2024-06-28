package com.example.fbtts;


import com.example.fbtts.controller.authentication.UserController;
import com.example.fbtts.entity.User;
import com.example.fbtts.repository.UserRepository;
import com.example.fbtts.security.UserRole;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
public class UserTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Configuration
    static class TestConfig {
        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
    }

    @Test
    @WithMockUser(username = "bernas@gmail.com", roles = {"USER"})
    public void testDecrementClicks() throws Exception {
        // Create a user "bernas" with initial clicks
        User user = new User("bernas", "bernas@gmail.com", passwordEncoder.encode("roman"), UserRole.USER);

        // Mock UserRepository response
        Mockito.when(userRepository.findByEmail(eq("bernas@gmail.com")))
                .thenReturn(user);

        // Perform decrement clicks request after successful login
        mockMvc.perform(post("/bernas@gmail.com/decrement-clicks")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.clicks", is(74)));

        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }

}
