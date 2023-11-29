package com.omnm.accident.DAO;//package dao;



import com.omnm.accident.Entity.Accident;
import com.omnm.accident.Repository.AccidentRepository;
import com.omnm.accident.enumeration.accident.AccidentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public class AccidentDAO {
    @Autowired
    private AccidentRepository accidentRepository;

    public AccidentDAO(AccidentRepository accidentRepository) {
        this.accidentRepository = accidentRepository;
    }

    public boolean updateStatusInAccidentById(int id, AccidentStatus status) { // updateStatusInAccidentById
//        ArrayList<Accident> accidentList = retrieve();
//        System.out.println("---------"+id);
//        for(Accident accident : accidentList) {
//            System.out.println(accident.getId());
//            if(accident.getId()==id) {
//                accident.setStatus(status);
//                accidentRepository.save(accident);
//                return true;
//            }
//        }
//        return false;
        Optional<Accident> accidents  = accidentRepository.findById(id);
        Accident accident = accidents.get();
        accident.setStatus(status);
        accidentRepository.save(accident);
        if(accidentRepository.save(accident)==null) return false;
        return true;
    }
    public int createAccident(Accident accident) { // createAccident
//        ArrayList<Accident> accidentList = retrieve();
//        if(accidentList.size()==0) accident.setId(1);
//        else {accident.setId(accidentList.get(accidentList.size()-1).getId()+1);}
//        if(create(accident)) return accident.getId();
//        else {return 0;}
        return accidentRepository.save(accident).getId();
    }
    public ArrayList<Accident> findAccidentByStatus(AccidentStatus accidentStatus) { // findAccidentByStatus
        return accidentRepository.findByStatus(accidentStatus);
    }

    public Accident findAccidentById(int id) { //findAccidentById
       return accidentRepository.findById(id).get();
    }

    public ArrayList<Accident> findAccident() {
        return (ArrayList<Accident>) accidentRepository.findAll();
    }
}
