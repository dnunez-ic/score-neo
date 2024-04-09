package com.innerconsulting.scoreneo.controller;

import com.innerconsulting.scoreneo.model.Score;
import com.innerconsulting.scoreneo.services.ScoreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scores")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @PostMapping("/")
    public ResponseEntity<Score> createScore(@RequestBody Score score) {
        Score createdScore = scoreService.saveScore(score);
        return new ResponseEntity<>(createdScore, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Score> getScoreById(@PathVariable Long id) {
        Score score = scoreService.findScoreById(id);
        if (score != null) {
            return new ResponseEntity<>(score, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Score>> getAllScores() {
        Iterable<Score> scores = scoreService.findAllScores();
        return new ResponseEntity<>(scores, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScoreById(@PathVariable Long id) {
        Score score = scoreService.findScoreById(id);
        if (score != null) {
            scoreService.deleteScoreById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
