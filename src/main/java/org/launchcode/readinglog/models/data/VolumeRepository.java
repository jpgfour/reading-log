package org.launchcode.readinglog.models.data;

import org.launchcode.readinglog.models.Volume;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//analagous to EmployerRepository
@Repository
public interface VolumeRepository extends CrudRepository<Volume, Integer> {
}
