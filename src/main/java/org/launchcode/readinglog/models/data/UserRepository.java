package org.launchcode.readinglog.models.data;

public interface UserRepository  extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}
