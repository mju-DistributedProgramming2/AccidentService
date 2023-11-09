package com.example.accidentservice.Repository;


import com.example.accidentservice.Entity.Accident;
import com.example.accidentservice.enumeration.accident.AccidentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface AccidentRepository extends JpaRepository<Accident,Integer> {
    ArrayList<Accident> findByStatus(AccidentStatus status);
}