package com.acelada.dsmovie.repositories;

import com.acelada.dsmovie.entities.Score;
import com.acelada.dsmovie.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}
