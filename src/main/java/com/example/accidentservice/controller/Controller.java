package com.example.accidentservice.controller;



import com.example.accidentservice.DTO.*;
import com.example.accidentservice.Entity.Accident;
import com.example.accidentservice.enumeration.accident.AccidentStatus;
import com.example.accidentservice.exception.EmptyListException;
import com.example.accidentservice.exception.NoDataException;
import com.example.accidentservice.exception.TimeDelayException;
import com.example.accidentservice.service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.ArrayList;

@RestController
public class Controller {
    @Autowired
    AccidentService accidentService;
    @GetMapping("/accidents")
    public ArrayList<Accident> getAccidentList(GetAccidentListRequest status) throws TimeDelayException, EmptyListException, RemoteException {
        ArrayList<Accident> accidentList = this.accidentService.getAccidentList(status.getStatus());
        return accidentList;
    }
    @GetMapping("/allAccidents")
    public GetAccidentListResponse getAccidentList() throws TimeDelayException, EmptyListException, RemoteException {
        ArrayList<Accident> accidentList = this.accidentService.getAccidentList();
        GetAccidentListResponse getAccidentListResponse=new GetAccidentListResponse();
        getAccidentListResponse.setAccidentList(accidentList);
        return getAccidentListResponse;
    }
    @GetMapping("/accident")
    public AccidentResponse getAccident(GetAccidentRequest id) throws RemoteException, NoDataException {
        Accident accident = this.accidentService.getAccident(id.getId());
        AccidentResponse accidentResponse = new AccidentResponse(accident);
        return accidentResponse;
    }
    @PostMapping("/accident")
    public ReportAccidentResponse reportAccident(@RequestBody ReportAccidentRequest accident) throws  RemoteException {
        ReportAccidentResponse reportAccidentResponse = new ReportAccidentResponse();
        reportAccidentResponse.setId(accidentService.reportAccident(accident.getAccident()));
        return reportAccidentResponse;
    }
    @PatchMapping("/status")
    public SetStatusResponse setStatus(SetStatusRequest setStatusRequest) throws RemoteException{
        SetStatusResponse setStatusResponse = new SetStatusResponse();
        setStatusResponse.setStatusResponse(accidentService.setStatus(setStatusRequest.getAccidentId(),setStatusRequest.getStatus()));
        return setStatusResponse;
    }

    }
