package com.source.repository;

import com.source.domain.Game;
import org.springframework.data.repository.CrudRepository;


public interface GameRepository extends CrudRepository<Game, Integer> {
}
