package com.omnm.accident.DAO;//package dao;



import com.omnm.accident.Entity.Accident;
import com.omnm.accident.Repository.AccidentRepository;
import com.omnm.accident.enumeration.accident.AccidentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class AccidentDao {
    @Autowired
    private final AccidentRepository accidentRepository;

    public AccidentDao(AccidentRepository accidentRepository) {
        this.accidentRepository = accidentRepository;
    }


    public boolean create(Accident accident) {

        System.out.println(accident);
        if(accidentRepository.save(accident)==null) return false;
        return true;
    }
    public ArrayList<Accident> retrieve(){
        ArrayList<Accident> accidentList = new ArrayList<>(accidentRepository.findAll());

        return accidentList;
    }
    public boolean update(int id, AccidentStatus status) {
        ArrayList<Accident> accidentList = retrieve();
        System.out.println("---------"+id);
        for(Accident accident : accidentList) {
            System.out.println(accident.getId());
            if(accident.getId()==id) {
                accident.setStatus(status);
                accidentRepository.save(accident);
                return true;
            }
        }
        return false;
    }
    public int add(Accident accident) {
        ArrayList<Accident> accidentList = retrieve();
        if(accidentList.size()==0) accident.setId(1);
        else {accident.setId(accidentList.get(accidentList.size()-1).getId()+1);}
        if(create(accident)) return accident.getId();
        else {return 0;}
    }
    public ArrayList<Accident> findByStatus(AccidentStatus accidentStatus) {
        ArrayList<Accident> accidentList = new ArrayList<>();
        for(Accident accident : retrieve()) {
            if(accident.getStatus() == accidentStatus) accidentList.add(accident);
        }
        return accidentList;
    }

    public Accident findById(int id) {
        for(Accident accident : retrieve()) {
            System.out.println(accident.getId());
            if(accident.getId() == id) return accident;
        }
        return null;
    }

}
