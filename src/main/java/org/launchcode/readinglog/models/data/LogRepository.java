package org.launchcode.readinglog.models.data;

import org.launchcode.readinglog.models.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

//analagous to JobRepository
@Repository
@Transactional
public interface LogRepository extends CrudRepository<Log, Integer> {
}
