package com.omnm.accident.Service;


import com.omnm.accident.DAO.AccidentDAO;
import com.omnm.accident.DTO.GetAccidentListResponse;
import com.omnm.accident.DTO.ReportAccidentResponse;
import com.omnm.accident.DTO.SetStatusResponse;
import com.omnm.accident.Entity.Accident;
import com.omnm.accident.enumeration.accident.AccidentStatus;
import com.omnm.accident.exception.EmptyListException;
import com.omnm.accident.exception.NoDataException;
import com.omnm.accident.exception.TimeDelayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

@Service
@EnableDiscoveryClient
public class AccidentService implements AccidentServiceIF{
    @Autowired
    AccidentDAO accidentDao;


    @Override
    public ResponseEntity<ArrayList<Accident>> getAccidentListByStatus(AccidentStatus status) {
        long beforeTime = System.currentTimeMillis();
        ArrayList<Accident> accidentList = this.accidentDao.findAccidentByStatus(status);
        if(accidentList.isEmpty())return new ResponseEntity<>(accidentList,new HttpHeaders(),HttpStatus.valueOf(500));

//        try {Thread.sleep(7000);}
//        catch (InterruptedException e) {throw new RuntimeException(e);}
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime)/1000;
        if(secDiffTime>=7) return new ResponseEntity<>(accidentList,new HttpHeaders(),HttpStatus.valueOf(500));

        return new ResponseEntity<>(accidentList,new HttpHeaders(),HttpStatus.valueOf(200));
    }
    @Override
    public ResponseEntity<ArrayList<Accident>>  getAccidentList() {
        long beforeTime = System.currentTimeMillis();
        ArrayList<Accident> accidentList = this.accidentDao.findAccident();
        if(accidentList.isEmpty())  return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.valueOf(500));
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
    public ResponseEntity<ReportAccidentResponse> postAccident(Accident accident){
        ReportAccidentResponse reportAccidentResponse = new ReportAccidentResponse();
        reportAccidentResponse.setId(this.accidentDao.createAccident(accident));
        return new ResponseEntity<>(reportAccidentResponse,new HttpHeaders(),HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity<SetStatusResponse> patchStatusById(int accidentId, AccidentStatus status){
        SetStatusResponse setStatusResponse = new SetStatusResponse();
        setStatusResponse.setStatusResponse(this.accidentDao.updateStatusInAccidentById(accidentId,status));
        return new ResponseEntity<>(setStatusResponse,new HttpHeaders(),HttpStatus.valueOf(200));
    }
}
