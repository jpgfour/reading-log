package org.launchcode.readinglog.models.data;

import org.launchcode.readinglog.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}
