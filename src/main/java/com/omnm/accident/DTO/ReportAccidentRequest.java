package com.omnm.accident.DTO;

import com.omnm.accident.Entity.Accident;

public class ReportAccidentRequest {
    private Accident accident;

    public Accident postAccident() {
        return accident;
    }

    public void setAccident(Accident accident) {
        this.accident = accident;
    }
}
