package be.thomasmore.webapp.repositories;

import be.thomasmore.webapp.model.Game;
import be.thomasmore.webapp.model.Tournament;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends CrudRepository<Game,Integer> {
    List<Game> findAllBy();

    Optional<Game> findFirstByIdLessThanOrderByIdDesc(int id);
    Optional<Game> findFirstByIdGreaterThanOrderById(int id);

    Optional<Game> findFirstByOrderByIdDesc();
    Optional<Game> findFirstByOrderByIdAsc();
}
