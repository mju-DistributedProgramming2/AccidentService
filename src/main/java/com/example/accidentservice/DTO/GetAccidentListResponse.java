package com.example.accidentservice.DTO;

import com.example.accidentservice.Entity.Accident;

import java.util.ArrayList;

public class GetAccidentListResponse {
    ArrayList<Accident> accidentList;

    public ArrayList<Accident> getAccidentList() {
        return accidentList;
    }

    public void setAccidentList(ArrayList<Accident> accidentList) {
        this.accidentList = accidentList;
    }
}
