package com.omnm.accident.DTO;

import com.omnm.accident.Entity.Accident;

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
