package com.learn.cryptozoology.repository;

import com.learn.cryptozoology.model.Habitat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitatRepository extends JpaRepository<Habitat,String> {

}
