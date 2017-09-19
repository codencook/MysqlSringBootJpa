package com.source.repository;

import com.source.domain.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface GameRepository extends CrudRepository<Game, Integer> {
    List<Game> findByName(String name);
}
