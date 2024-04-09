package com.innerconsulting.scoreneo.services;

import com.innerconsulting.scoreneo.model.Score;
import com.innerconsulting.scoreneo.repository.ScoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    @Autowired
    private final ScoreRepository scoreRepository;

    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public Score saveScore(Score score) {
        return this.scoreRepository.save(score);
    }

    public Score findScoreById(Long id) {
        return this.scoreRepository.findById(id).orElse(null);
    }

    public Iterable<Score> findAllScores() {
        return this.scoreRepository.findAll();
    }

    public void deleteScoreById(Long id) {
        this.scoreRepository.deleteById(id);
    }
}
