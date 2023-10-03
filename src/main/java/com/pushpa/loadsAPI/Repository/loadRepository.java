package com.pushpa.loadsAPI.Repository;

import com.pushpa.loadsAPI.Entity.Load;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface loadRepository extends CrudRepository<Load,Long> {

    List<Load> findByShipperId(UUID shipperId);
}
