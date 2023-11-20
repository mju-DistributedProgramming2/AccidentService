package com.example.accidentservice.service;



import com.example.accidentservice.Entity.Accident;
import com.example.accidentservice.enumeration.accident.AccidentStatus;
import com.example.accidentservice.exception.EmptyListException;
import com.example.accidentservice.exception.NoDataException;
import com.example.accidentservice.exception.TimeDelayException;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface AccidentServiceIF extends Remote{
    ArrayList<Accident> getAllAccidentList(AccidentStatus status) throws RemoteException, EmptyListException, TimeDelayException;

    ArrayList<Accident> getAllAccidentList() throws RemoteException, EmptyListException, TimeDelayException;

    Accident getAccident(int id) throws RemoteException, NoDataException;

    int reportAccident(Accident accident) throws RemoteException;

    boolean setStatus(int accidentId, AccidentStatus status) throws RemoteException;
}
