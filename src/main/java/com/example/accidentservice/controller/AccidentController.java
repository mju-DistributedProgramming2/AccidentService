package com.example.accidentservice.controller;



import com.example.accidentservice.DTO.*;
import com.example.accidentservice.Entity.Accident;
import com.example.accidentservice.exception.EmptyListException;
import com.example.accidentservice.exception.NoDataException;
import com.example.accidentservice.exception.TimeDelayException;
import com.example.accidentservice.service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AccidentController {
    @Autowired
    AccidentService accidentService;
    @GetMapping("/accidents")
    public ArrayList<Accident> getAccidentList(GetAccidentListRequest status) throws TimeDelayException, EmptyListException, RemoteException {
        System.out.println(status.getStatus());
        ArrayList<Accident> accidentList = this.accidentService.getAccidentList(status.getStatus());
        return accidentList;
    }
    @GetMapping("/allAccidents")
    public GetAccidentListResponse getAccidentList() throws TimeDelayException, EmptyListException, RemoteException {
        List<Accident> accidentList = this.accidentService.getAccidentList();
        GetAccidentListResponse getAccidentListResponse=new GetAccidentListResponse();
        getAccidentListResponse.setAccidentList(accidentList);
        return getAccidentListResponse;
    }
    @GetMapping("/accident")
    public AccidentResponse getAccident(GetAccidentRequest getAccidentRequest) throws RemoteException, NoDataException {
        Accident accident = this.accidentService.getAccident(getAccidentRequest.getId());
        AccidentResponse accidentResponse = new AccidentResponse(accident);
        return accidentResponse;
    }
    @PostMapping("/accident")
    public ReportAccidentResponse reportAccident(@RequestBody ReportAccidentRequest accident) throws  RemoteException {
        System.out.println(accident.getAccident());
        ReportAccidentResponse reportAccidentResponse = new ReportAccidentResponse();
        reportAccidentResponse.setId(accidentService.reportAccident(accident.getAccident()));
        return reportAccidentResponse;
    }
    @PatchMapping("/status")
    public SetStatusResponse setStatus(SetStatusRequest setStatusRequest) throws RemoteException{
        System.out.println(setStatusRequest.getAccidentId()+"   "+setStatusRequest.getStatus());
        SetStatusResponse setStatusResponse = new SetStatusResponse();
        setStatusResponse.setStatusResponse(accidentService.setStatus(setStatusRequest.getAccidentId(),setStatusRequest.getStatus()));
        return setStatusResponse;
    }

    }