package com.example.accidentservice.DTO;

import com.example.accidentservice.Entity.Accident;

import java.util.ArrayList;
import java.util.List;

public class GetAccidentListResponse {
    List<Accident> accidentList;

    public List<Accident> getAccidentList() {
        return accidentList;
    }

    public void setAccidentList(List<Accident> accidentList) {
        this.accidentList = accidentList;
    }
}
