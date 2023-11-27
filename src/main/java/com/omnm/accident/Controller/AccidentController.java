package com.omnm.accident.Controller;



import com.omnm.accident.Entity.Accident;
import com.omnm.accident.exception.EmptyListException;
import com.omnm.accident.exception.NoDataException;
import com.omnm.accident.exception.TimeDelayException;
import com.omnm.accident.Service.AccidentService;
import com.omnm.accident.DTO.*;
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
    public GetAccidentListResponse getAccidentList(GetAccidentListRequest status) throws TimeDelayException, EmptyListException, RemoteException {
        ArrayList<Accident> accidentList = this.accidentService.getAllAccidentList(status.getStatus());
        GetAccidentListResponse getAccidentListResponse = new GetAccidentListResponse();
        getAccidentListResponse.setAccidentList(accidentList);
        return getAccidentListResponse;
    }
    @GetMapping("/allAccidents")
    public GetAccidentListResponse getAccidentList() throws TimeDelayException, EmptyListException, RemoteException {
        List<Accident> accidentList = this.accidentService.getAllAccidentList();
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
        ReportAccidentResponse reportAccidentResponse = new ReportAccidentResponse();
        reportAccidentResponse.setId(accidentService.reportAccident(accident.getAccident()));
        return reportAccidentResponse;
    }
    @PatchMapping("/status")
    public SetStatusResponse setStatus(@RequestBody SetStatusRequest setStatusRequest) throws RemoteException{
        System.out.println(setStatusRequest.toString());
        System.out.println(setStatusRequest.getAccidentId());
        System.out.println(setStatusRequest.getStatus());
        SetStatusResponse setStatusResponse = new SetStatusResponse();
        setStatusResponse.setStatusResponse(accidentService.setStatus(setStatusRequest.getAccidentId(),setStatusRequest.getStatus()));
        return setStatusResponse;
    }

    }
