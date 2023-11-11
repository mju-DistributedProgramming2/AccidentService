package com.example.accidentservice.dao;//package dao;



import com.example.accidentservice.Entity.Accident;
import com.example.accidentservice.Repository.AccidentRepository;
import com.example.accidentservice.enumeration.accident.AccidentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AccidentDao extends Dao {
    @Autowired
    private final AccidentRepository accidentRepository;

    public AccidentDao(AccidentRepository accidentRepository) {
        this.accidentRepository = accidentRepository;
    }


    public boolean create(Accident accident) {

        System.out.println(accident);
        accidentRepository.save(accident);
        if(accidentRepository.save(accident)==null) return false;
//        String query ="insert into accident values ("+
//                           accident.getId()+", "+
//                accident.getContractId()+", "+
//                "'"+accident.getDate()+"'"+", "+
//                "'"+accident.getLocation()+"'"+", "+
//                "'"+accident.getCause()+"'"+", "+
//                "'"+accident.getContent()+"'"+", "+
//                accident.getDamage()+", "+
//                "'"+accident.getAccountNumber()+"'"+", "+
//                "'"+accident.getStatus()+"'"+");";
//        return create(query);
        return true;
    }
    public List<Accident> retrieve(){
//        String query = "select * from accident;";
//        ArrayList<Accident> accidentList = new ArrayList<>();
//        resultSet = retrieve(query);
//        try {
//            while(resultSet.next()) {
//                AccidentStatus accidentStatus = null;
//                switch(resultSet.getString(9)) {
//                    case "ReportAccident":
//                        accidentStatus = AccidentStatus.ReportAccident;
//                        break;
//                    case "RefuseCompensate":
//                        accidentStatus = AccidentStatus.RefuseCompensate;
//                        break;
//                    case "Compensate":
//                        accidentStatus = AccidentStatus.Compensate;
//                        break;
//                }
//                Accident accident = new Accident(
//                        resultSet.getInt(2),
//                        resultSet.getTimestamp(3),
//                        resultSet.getString(4),
//                        resultSet.getString(5),
//                        resultSet.getString(6),
//                        resultSet.getLong(7),
//                        resultSet.getString(8),
//                        accidentStatus
//                );
//                accident.setId(resultSet.getInt(1));
//                accidentList.add(accident);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return new ArrayList<>();
//        }
//        return accidentList;
        return accidentRepository.findAll();
    }
    public boolean update(int id, AccidentStatus status) {
        List<Accident> accidentList = retrieve();
        for(Accident accident : accidentList) {
            if(accident.getId()==id) {
                accident.setStatus(status);
//                String query = "update accident set stauts = "+"'"+status+"'"+" where id = "+id;
                accidentRepository.save(accident);
                return true;
            }
        }
        return false;
    }
    public int add(Accident accident) {
        List<Accident> accidentList = retrieve();
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
            if(accident.getId() == id) return accident;
        }
        return null;
    }

}
