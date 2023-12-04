package com.omnm.accident.Controller;

import com.omnm.accident.Entity.Accident;
import com.omnm.accident.Service.AccidentService;
import com.omnm.accident.DTO.*;
import com.omnm.accident.enumeration.accident.AccidentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class AccidentController {

    @Autowired
    AccidentService accidentService;

    @GetMapping("/accidents/{status}")
    public ResponseEntity<AccidentList> getAccidentListByStatus(@PathVariable("status") AccidentStatus status){
        return this.accidentService.getAccidentListByStatus(status);
    }
    @GetMapping("/list/accidents")
    public ResponseEntity<AccidentList> getAccidentList(){
        return this.accidentService.getAccidentList();
    }
    @GetMapping("/accident/{id}")
    public ResponseEntity<Accident> getAccidentById(@PathVariable("id") int id){
        return this.accidentService.getAccidentById(id);
    }
    @PostMapping("/accident")
    public ResponseEntity<Integer> postAccident(@RequestBody Accident accident){
        return accidentService.postAccident(accident);
    }
    @PatchMapping("/status")
    public ResponseEntity<Boolean> patchStatusById(@RequestBody SetStatusRequest setStatusRequest){
        return accidentService.patchStatusById(setStatusRequest.getAccidentId(),setStatusRequest.getStatus());
    }

    }
