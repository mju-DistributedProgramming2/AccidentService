package com.omnm.accident.Repository;


import com.omnm.accident.Entity.Accident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccidentRepository extends JpaRepository<Accident,Integer> {
//    ArrayList<Accident> findByStatus(AccidentStatus status);
}