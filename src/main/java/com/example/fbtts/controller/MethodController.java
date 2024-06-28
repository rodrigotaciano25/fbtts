package com.example.fbtts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.io.IOException;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@RestController
public class MethodController {

    @GetMapping("/methods")
    public ResponseEntity<String> getMethods() throws IOException {
        String filePath = "C:\\Users\\rodyt\\OneDrive\\Ambiente de Trabalho\\React Native TFC\\StickerSmash - Cópia\\JSON\\methods.json";

        File file = new File(filePath);
        byte[] jsonData = Files.readAllBytes(file.toPath());
        String data = new String(jsonData, StandardCharsets.UTF_8);

        return ResponseEntity.ok(data);
    }

    @GetMapping("/methods/matches")
    public ResponseEntity<String> getMatches() throws IOException {
        String filePath = "C:\\Users\\rodyt\\OneDrive\\Ambiente de Trabalho\\React Native TFC\\StickerSmash - Cópia\\JSON\\matches.json";

        File file = new File(filePath);
        byte[] jsonData = Files.readAllBytes(file.toPath());
        String data = new String(jsonData, StandardCharsets.UTF_8);

        return ResponseEntity.ok(data);
    }

}
