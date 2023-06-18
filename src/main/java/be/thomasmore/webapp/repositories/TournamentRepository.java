package be.thomasmore.webapp.repositories;

import be.thomasmore.webapp.model.Tournament;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TournamentRepository extends CrudRepository<Tournament,Integer> {
    List<Tournament> findAllBy();
    List<Tournament> findAllByGame_Id(Integer id);
}
