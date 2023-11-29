package com.omnm.accident.Service;



import com.omnm.accident.DTO.ReportAccidentResponse;
import com.omnm.accident.DTO.SetStatusResponse;
import com.omnm.accident.Entity.Accident;
import com.omnm.accident.enumeration.accident.AccidentStatus;
import com.omnm.accident.exception.EmptyListException;
import com.omnm.accident.exception.NoDataException;
import com.omnm.accident.exception.TimeDelayException;
import org.springframework.http.ResponseEntity;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface AccidentServiceIF extends Remote{
    ResponseEntity<ArrayList<Accident>> getAccidentListByStatus(AccidentStatus status);

    ResponseEntity<ArrayList<Accident>> getAccidentList();

    ResponseEntity<Accident> getAccidentById(int id);

    ResponseEntity<Integer> postAccident(Accident accident);

    ResponseEntity<Boolean> patchStatusById(int accidentId, AccidentStatus status);
}
