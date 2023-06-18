package be.thomasmore.webapp.repositories;

import be.thomasmore.webapp.model.Game;
import be.thomasmore.webapp.model.Tournament;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TournamentRepository extends CrudRepository<Tournament,Integer> {
    List<Tournament> findAllBy();
    List<Tournament> findAllByGame_Id(Integer id);

    Optional<Tournament> findFirstByIdLessThanOrderByIdDesc(int id);
    Optional<Tournament> findFirstByIdGreaterThanOrderById(int id);

    Optional<Tournament> findFirstByOrderByIdDesc();
    Optional<Tournament> findFirstByOrderByIdAsc();

    @Query("SELECT t FROM Tournament t " +
            "WHERE (:name IS NULL OR t.name = :name) " +
            "AND (:game IS NULL OR t.game = :game) " +
            "AND (:free IS NULL OR t.free = :free) " +
            "AND (:prizepool IS NULL OR t.prizepool = :prizepool) " +
            "AND (:date IS NULL OR t.date = :date) ")
    List<Tournament> findByNameGameFreePrizepoolDate(
            @Param("name") String name,
            @Param("game") Game game,
            @Param("free") Boolean free,
            @Param("prizepool") Double prizepool,
            @Param("date") Date date);
}
