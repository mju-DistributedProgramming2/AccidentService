package com.example.accidentservice.DTO;

import com.example.accidentservice.Entity.Accident;

public class ReportAccidentRequest {
    private Accident accident;

    public Accident getAccident() {
        return accident;
    }

    public void setAccident(Accident accident) {
        this.accident = accident;
    }
}
