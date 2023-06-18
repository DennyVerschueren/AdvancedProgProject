package be.thomasmore.webapp.repositories;

import be.thomasmore.webapp.model.EndUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<EndUser, Integer> {
}
