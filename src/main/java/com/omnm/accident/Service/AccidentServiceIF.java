package com.omnm.accident.Service;



import com.omnm.accident.Entity.Accident;
import com.omnm.accident.enumeration.accident.AccidentStatus;
import com.omnm.accident.exception.EmptyListException;
import com.omnm.accident.exception.NoDataException;
import com.omnm.accident.exception.TimeDelayException;

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
