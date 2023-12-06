package com.omnm.accident.Service;


import com.omnm.accident.DAO.AccidentDAO;
import com.omnm.accident.DTO.AccidentList;
import com.omnm.accident.Entity.Accident;
import com.omnm.accident.enumeration.accident.AccidentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@EnableDiscoveryClient
public class AccidentService implements AccidentServiceIF{
    @Autowired
    AccidentDAO accidentDao;


    @Override
    public ResponseEntity<AccidentList> getAccidentListByStatus(AccidentStatus status) {
        long beforeTime = System.currentTimeMillis();
        ArrayList<Accident> accidents = this.accidentDao.findAccidentByStatus(status);
        AccidentList accidentList = new AccidentList(accidents);
        if(accidentList.getAccidentList().size()==0)return new ResponseEntity<>(null,new HttpHeaders(),HttpStatus.valueOf(500));

//        try {Thread.sleep(7000);}
//        catch (InterruptedException e) {throw new RuntimeException(e);}
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime)/1000;
        if(secDiffTime>=7) return new ResponseEntity<>(null,new HttpHeaders(),HttpStatus.valueOf(500));

        return new ResponseEntity<>(accidentList,new HttpHeaders(),HttpStatus.valueOf(200));
    }
    @Override
    public ResponseEntity<AccidentList>  getAccidentList() {
        long beforeTime = System.currentTimeMillis();
        ArrayList<Accident> accidents = this.accidentDao.findAccident();
        AccidentList accidentList = new AccidentList(accidents);

        if(accidentList.getAccidentList().size()==0)  return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.valueOf(500));
//        try {Thread.sleep(7000);}
//        catch (InterruptedException e) {throw new RuntimeException(e);}
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime)/1000;
        if(secDiffTime>=7)return new ResponseEntity<>(null,new HttpHeaders(),HttpStatus.valueOf(200));

        return new ResponseEntity<>(accidentList,new HttpHeaders(),HttpStatus.valueOf(200));
    }
    @Override
    public ResponseEntity<Accident> getAccidentById(int id){
        Accident accident = this.accidentDao.findAccidentById(id);
        if(accident == null) return new ResponseEntity<>(accident,new HttpHeaders(),HttpStatus.valueOf(500));
        return new ResponseEntity<>(accident,new HttpHeaders(),HttpStatus.valueOf(200));
    }
    @Override
    public ResponseEntity<Integer> postAccident(Accident accident){
        return new ResponseEntity<>(this.accidentDao.createAccident(accident),new HttpHeaders(),HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity<Boolean> patchStatusById(int accidentId, AccidentStatus status){
        return new ResponseEntity<>(this.accidentDao.updateStatusInAccidentById(accidentId,status),new HttpHeaders(),HttpStatus.valueOf(200));
    }
}
