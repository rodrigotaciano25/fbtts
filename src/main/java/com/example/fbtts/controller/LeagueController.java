package com.example.fbtts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.io.IOException;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@RestController
public class LeagueController {

    @GetMapping("/leagues")
    public ResponseEntity<String> getLeagues() throws IOException {

        String filePath = "C:\\Users\\rodyt\\OneDrive\\Ambiente de Trabalho\\React Native TFC\\StickerSmash - Cópia\\JSON\\leagues.json";

        File file = new File(filePath);
        byte[] jsonData = Files.readAllBytes(file.toPath());
        String data = new String(jsonData, StandardCharsets.UTF_8);

        return ResponseEntity.ok(data);
    }

    @GetMapping("/leaguedetailed")
    public ResponseEntity<String> getLeagueDetailed() throws IOException {
        String filePath = "C:\\Users\\rodyt\\OneDrive\\Ambiente de Trabalho\\React Native TFC\\StickerSmash - Cópia\\JSON\\bundesliga1.json";

        File file = new File(filePath);
        byte[] jsonData = Files.readAllBytes(file.toPath());
        String data = new String(jsonData, StandardCharsets.UTF_8);

        return ResponseEntity.ok(data);
    }
}
