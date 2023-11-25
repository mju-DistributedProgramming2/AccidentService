package com.omnm.accident.DTO;

import com.omnm.accident.enumeration.accident.AccidentStatus;

public class GetAccidentListRequest {
    AccidentStatus status;

    public AccidentStatus getStatus() {
        return status;
    }

    public void setStatus(AccidentStatus status) {
        this.status = status;
    }
}
