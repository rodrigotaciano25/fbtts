package com.example.fbtts.service;

import com.example.fbtts.entity.Match;
import com.example.fbtts.entity.Method;
import com.example.fbtts.repository.MethodRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MethodService {
    @Autowired
    private MethodRepository methodRepository;
    @Autowired
    private MatchService matchService;

    public Method findById(long id) {
        return methodRepository.findById(id);
    }

    public Method findByTitleAndUser(String title, String user) {
        return methodRepository.findByTitleAndUser(title, user);
    }

    public List<Method> getAllByUser(String user) {
        return methodRepository.findAllByUser(user);
    }

    public Method findByUser(String user) {
        return methodRepository.findByUser(user);
    }

    public Method addMethod(Method method) {
        return methodRepository.save(method);
    }

    public List<Match> getMatchesForMethod(Long methodId) {
        Method method = methodRepository.findById(methodId)
                .orElseThrow(() -> new RuntimeException("Method not found with ID: " + methodId));
        return method.getMatches();
    }

    public Method addMatchToMethod(String title, String user, Match match) {
        Method method = methodRepository.findByTitleAndUser(title, user);
        if (method != null) {
            // Verifique se o ID do Match não é nulo e defina um ID se necessário
            if (match.getId() == null) {
                match.setId(matchService.findMatchByDateAndMatch(match.getDate(), match.getMatch()).getId());
            }
            method.getMatches().add(match);
            return methodRepository.save(method);
        } else {
            return null;
        }
    }
}
