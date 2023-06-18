package be.thomasmore.webapp.repositories;

import be.thomasmore.webapp.model.Tournament;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TournamentRepository extends CrudRepository<Tournament,Integer> {
    List<Tournament> findAllBy();
}
