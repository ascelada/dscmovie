package com.acelada.dsmovie.services;

import com.acelada.dsmovie.dto.MovieDTO;
import com.acelada.dsmovie.dto.ScoreDTO;
import com.acelada.dsmovie.entities.Movie;
import com.acelada.dsmovie.entities.Score;
import com.acelada.dsmovie.entities.User;
import com.acelada.dsmovie.repositories.MovieRepository;
import com.acelada.dsmovie.repositories.ScoreRepository;
import com.acelada.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO dto) {

        User user = userRepository.findByEmail(dto.getEmail());
        if (user == null) {
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }
        Movie movie = movieRepository.getById(dto.getMovieId());

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());

        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for (Score s :
                movie.getScores()) {
            sum = sum + s.getValue();

        }
        double avg = sum / movie.getScores().size();
        movie.setScore(avg);
        movie = movieRepository.save(movie);

        return new MovieDTO(movie);
    }
}
