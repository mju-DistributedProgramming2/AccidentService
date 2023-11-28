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
    public GetAccidentListResponse getAccidentListByStatus(GetAccidentListRequest status){
        ArrayList<Accident> accidentList = this.accidentService.getAllAccidentList(status.getStatus());
        GetAccidentListResponse getAccidentListResponse = new GetAccidentListResponse();
        getAccidentListResponse.setAccidentList(accidentList);
        return getAccidentListResponse;
    }
    @GetMapping("/accidents/list")
    public GetAccidentListResponse getAccidentList(){
        List<Accident> accidentList = this.accidentService.getAllAccidentList();
        GetAccidentListResponse getAccidentListResponse=new GetAccidentListResponse();
        getAccidentListResponse.setAccidentList(accidentList);
        return getAccidentListResponse;
    }
    @GetMapping("/accident") // Param accidentId로 변경 -> uri에 id 들어가는
    public AccidentResponse getAccidentById(GetAccidentRequest getAccidentRequest){
        Accident accident = this.accidentService.getAccident(getAccidentRequest.getId());
        AccidentResponse accidentResponse = new AccidentResponse(accident);
        return accidentResponse;
    }
    @PostMapping("/accident")
    public ReportAccidentResponse postAccident(@RequestBody ReportAccidentRequest accident){
        ReportAccidentResponse reportAccidentResponse = new ReportAccidentResponse();
        reportAccidentResponse.setId(accidentService.reportAccident(accident.getAccident()));
        return reportAccidentResponse;
    }
    @PatchMapping("/status")
    public SetStatusResponse patchStatusById(@RequestBody SetStatusRequest setStatusRequest){
        SetStatusResponse setStatusResponse = new SetStatusResponse();
        setStatusResponse.setStatusResponse(accidentService.setStatus(setStatusRequest.getAccidentId(),setStatusRequest.getStatus()));
        return setStatusResponse;
    }

    }
