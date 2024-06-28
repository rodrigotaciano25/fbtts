package com.example.fbtts;

import com.example.fbtts.controller.MethodController;
import com.example.fbtts.infra.security.TokenService;
import com.example.fbtts.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = MethodController.class)
public class MethodTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TokenService tokenService; // Mock TokenService

    @MockBean
    private UserRepository userRepository; // Mock UserRepository

    @Test
    @WithMockUser(username = "roman", roles = {"USER"})
    public void whenGetMethods_thenReturnJson() throws Exception {
        String filePath = "C:\\Users\\rodyt\\OneDrive\\Ambiente de Trabalho\\React Native TFC\\StickerSmash - Cópia\\JSON\\methods.json";
        File file = new File(filePath);
        byte[] jsonData = Files.readAllBytes(file.toPath());
        String expectedContent = new String(jsonData, StandardCharsets.UTF_8);

        mockMvc.perform(get("/methods")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedContent));
    }

    @Test
    @WithMockUser(username = "roman", roles = {"USER"})
    public void whenGetMatches_thenReturnJson() throws Exception {
        String filePath = "C:\\Users\\rodyt\\OneDrive\\Ambiente de Trabalho\\React Native TFC\\StickerSmash - Cópia\\JSON\\matches.json";
        File file = new File(filePath);
        byte[] jsonData = Files.readAllBytes(file.toPath());
        String expectedContent = new String(jsonData, StandardCharsets.UTF_8);

        mockMvc.perform(get("/methods/matches")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedContent));
    }
}
