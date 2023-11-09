package com.example.accidentservice.DTO;

import com.example.accidentservice.enumeration.accident.AccidentStatus;

public class GetAccidentListRequest {
    AccidentStatus status;

    public AccidentStatus getStatus() {
        return status;
    }

    public void setStatus(AccidentStatus status) {
        this.status = status;
    }
}
