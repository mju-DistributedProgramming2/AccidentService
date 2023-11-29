package com.omnm.accident.Controller;

import com.omnm.accident.Entity.Accident;
import com.omnm.accident.Service.AccidentService;
import com.omnm.accident.DTO.*;
import com.omnm.accident.enumeration.accident.AccidentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccidentController {

    @Autowired
    AccidentService accidentService;

    @GetMapping("/accidents")
    public ResponseEntity<ArrayList<Accident>> getAccidentListByStatus(@Param("status") AccidentStatus status){
        System.out.println(status);
        return this.accidentService.getAccidentListByStatus(status);
    }
    @GetMapping("/accidents/list")
    public ResponseEntity<ArrayList<Accident>> getAccidentList(){
        return this.accidentService.getAccidentList();
    }
    @GetMapping("/accident") // Param accidentId로 변경 -> uri에 id 들어가는
    public ResponseEntity<Accident> getAccidentById(@Param("id") int id){
        return this.accidentService.getAccidentById(id);
    }
    @PostMapping("/accident")
    public ResponseEntity<ReportAccidentResponse> postAccident(@RequestBody ReportAccidentRequest accident){
        return accidentService.postAccident(accident.getAccident());
    }
    @PatchMapping("/status")
    public ResponseEntity<SetStatusResponse> patchStatusById(@RequestBody SetStatusRequest setStatusRequest){
        return accidentService.patchStatusById(setStatusRequest.getAccidentId(),setStatusRequest.getStatus());
    }

    }
