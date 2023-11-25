package com.omnm.accident.Service;


import com.omnm.accident.Entity.Accident;
import com.omnm.accident.DAO.AccidentDao;
import com.omnm.accident.enumeration.accident.AccidentStatus;
import com.omnm.accident.exception.EmptyListException;
import com.omnm.accident.exception.NoDataException;
import com.omnm.accident.exception.TimeDelayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

@Service
@EnableDiscoveryClient
public class AccidentService extends UnicastRemoteObject implements AccidentServiceIF{
    @Autowired
    AccidentDao accidentDao;


    public AccidentService() throws RemoteException {
    }

    @Override
    public ArrayList<Accident> getAllAccidentList(AccidentStatus status) throws RemoteException, EmptyListException, TimeDelayException {
        long beforeTime = System.currentTimeMillis();
        ArrayList<Accident> accidentList = this.accidentDao.findByStatus(status);
        if(accidentList.isEmpty()) throw new EmptyListException("! 목록이 존재하지 않습니다.");
//        try {Thread.sleep(7000);}
//        catch (InterruptedException e) {throw new RuntimeException(e);}
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime)/1000;
        if(secDiffTime>=7) throw new TimeDelayException("! 시스템에 오류가 발생했습니다. 다시 시도해주세요.");

        return accidentList;
    }
    @Override
    public ArrayList<Accident> getAllAccidentList() throws RemoteException, EmptyListException, TimeDelayException {
        long beforeTime = System.currentTimeMillis();
        ArrayList<Accident> accidentList = this.accidentDao.retrieve();
        if(accidentList.isEmpty()) throw new EmptyListException("! 목록이 존재하지 않습니다.");
//        try {Thread.sleep(7000);}
//        catch (InterruptedException e) {throw new RuntimeException(e);}
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime)/1000;
        if(secDiffTime>=7) throw new TimeDelayException("! 시스템에 오류가 발생했습니다. 다시 시도해주세요.");

        return accidentList;
    }
    @Override
    public Accident getAccident(int id) throws RemoteException, NoDataException {
        Accident accident = this.accidentDao.findById(id);
        if(accident == null) throw new NoDataException("! 존재하지 않는 사고입니다.");
        return accident;
    }
    @Override
    public int reportAccident(Accident accident) throws RemoteException {
        return this.accidentDao.add(accident);
    }

    @Override
    public boolean setStatus(int accidentId, AccidentStatus status) throws RemoteException{
        return this.accidentDao.update(accidentId, status);
    }
}
