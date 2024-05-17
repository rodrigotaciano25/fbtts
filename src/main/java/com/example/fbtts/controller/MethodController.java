package com.example.fbtts.controller;

import com.example.fbtts.entity.Match;
import com.example.fbtts.entity.Method;
import com.example.fbtts.entity.User;
import com.example.fbtts.infra.security.TokenService;
import com.example.fbtts.repository.MatchRepository;
import com.example.fbtts.repository.MethodRepository;
import com.example.fbtts.service.MethodService;
import com.example.fbtts.service.SequenceGeneratorService;
import com.example.fbtts.service.security.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/methods")
@AllArgsConstructor
public class MethodController {
    private final UserService userService;
    private MethodService methodService;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @Autowired
    private MethodRepository methodRepository;
    @Autowired
    private MatchRepository matchRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Method> findById(@PathVariable long id) {
        System.out.println(id);
        Method method = methodService.findById(id);
        if (method != null) {
            return ResponseEntity.ok(method);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{title}/{user}")
    public ResponseEntity<Method> findByTitleAndUser(@PathVariable String title, @PathVariable String user) {
        System.out.println(title);
        System.out.println(user);
        Method method = methodService.findByTitleAndUser(title, user);
        if (method != null) {
            return ResponseEntity.ok(method);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user")
    public ResponseEntity<Method> findByUser(@RequestParam(required = false) String user,
                                             @RequestHeader("Authorization") String authorizationHeader,
                                             @Autowired TokenService tokenService) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String token = authorizationHeader.substring(7); // Remove "Bearer " prefix
        String userEmail;
        try {
            userEmail = tokenService.validateToken(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // Check if token is valid for the requested user (if user is provided)
        if (user != null && !userEmail.equals(user)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        Method method = methodService.findByUser(user);
        if (method != null) {
            return ResponseEntity.ok(method);
        } else {
            // User might not have any methods associated with them
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/matches/{leagueId}")
    public ResponseEntity<List<Match>> findMatchesByLeague(@PathVariable String leagueId) {
        try {
            List<Match> matches = matchRepository.findAllByLeague(leagueId);
            if (matches != null && !matches.isEmpty()) {
                return ResponseEntity.ok(matches);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/{title}/{user}/addMatch")
    public ResponseEntity<Method> addMatchToMethod(@PathVariable String title,
                                                   @PathVariable String user,
                                                   @RequestBody Match match) {
        Method method = methodService.addMatchToMethod(title, user, match);
        if (method != null) {
            return ResponseEntity.ok(method); // Método encontrado e atualizado com sucesso
        } else {
            return ResponseEntity.notFound().build(); // Método não encontrado
        }
    }

    @GetMapping("/{methodId}/matches")
    public ResponseEntity<List<Match>> getMatchesForMethod(@PathVariable Long methodId) {
        Method method = methodService.findById(methodId);
        if (method != null) {
            return ResponseEntity.ok(method.getMatches());
        } else {
            return ResponseEntity.notFound().build(); // Método não encontrado
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Method> addMethod(@RequestBody Method method) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            System.out.println("User not authenticated.");
        }

        Method newMethod = methodService.addMethod(method);
        newMethod.setId((long) sequenceGeneratorService.getSequenceNumber(Method.SEQUENCE_NAME));
        String email = method.getUser();
        User user = userService.findByEmail(email);
        user.addMethod(newMethod);
        methodRepository.save(method);

        return ResponseEntity.status(HttpStatus.CREATED).body(newMethod);
    }

}
