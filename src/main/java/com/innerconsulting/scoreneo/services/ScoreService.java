package com.innerconsulting.scoreneo.services;

import com.innerconsulting.scoreneo.model.Score;
import com.innerconsulting.scoreneo.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private final ScoreRepository scoreRepository;

    public ScoreService(ScoreRepository scoreRepository) {

        this.scoreRepository = scoreRepository;
    }

    public List<Score> getAllScore(){
        return scoreRepository.findAll();
    }

    public Score saveScore( Score score){
        return scoreRepository.save(score);
    }

    public Score updateScore(Score score){
        Optional<Score> scoreFromDB=scoreRepository.findById(score.getId());
        if(scoreFromDB.isPresent()){
            Score scoreFromDBVal = scoreFromDB.get();

            scoreFromDBVal.setName(score.getName());
            scoreFromDBVal.setSearchable(score.isSearchable());
            scoreFromDBVal.setRoles(score.getRoles());
            score=scoreRepository.save(scoreFromDBVal);
        }else {
            return null;
        }
        return score;
    }


    public Score findScoreById(Long id) {

        return this.scoreRepository.findById(id).orElse(null);
    }


    public void deleteScoreById(Long id) {

        this.scoreRepository.deleteById(id);
    }
}
