package com.example.fbtts;

import com.example.fbtts.controller.LeagueController;
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
@WebMvcTest(controllers = LeagueController.class)
public class LeagueTest {

    private static final String BASE_PATH = "C:\\Users\\rodyt\\OneDrive\\Ambiente de Trabalho\\React Native TFC\\StickerSmash - Cópia\\JSON\\";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TokenService tokenService; // Mock TokenService

    @MockBean
    private UserRepository userRepository; // Mock UserRepository

    @Test
    @WithMockUser(username = "roman", roles = {"USER"})
    public void whenGetLeagues_thenReturnJson() throws Exception {
        String filePath = BASE_PATH + "leagues.json";
        File file = new File(filePath);
        byte[] jsonData = Files.readAllBytes(file.toPath());
        String expectedContent = new String(jsonData, StandardCharsets.UTF_8);

        mockMvc.perform(get("/leagues")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedContent));
    }

    @Test
    @WithMockUser(username = "roman", roles = {"USER"})
    public void whenGetLeagueDetailed_thenReturnJson() throws Exception {
        String filePath = BASE_PATH + "bundesliga1.json";
        File file = new File(filePath);
        byte[] jsonData = Files.readAllBytes(file.toPath());
        String expectedContent = new String(jsonData, StandardCharsets.UTF_8);

        mockMvc.perform(get("/leaguedetailed")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedContent));
    }
}
