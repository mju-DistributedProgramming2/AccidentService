package com.example.accidentservice.DTO;



import com.example.accidentservice.Entity.Accident;
import com.example.accidentservice.enumeration.accident.AccidentStatus;

import java.io.Serializable;
import java.sql.Timestamp;

public class AccidentResponse implements Serializable {
    private int id;
    private int contractId;
    private Timestamp date;
    private String location;
    private String cause;
    private String content;
    private long damage;
    private String accountNumber;
    private AccidentStatus status;

    public AccidentResponse(Accident accident) {
        this.id = accident.getId();
        this.contractId = accident.getContractId();
        this.date = accident.getDate();
        this.location = accident.getLocation();
        this.cause = accident.getCause();
        this.content = accident.getContent();
        this.damage = accident.getDamage();
        this.accountNumber = accident.getAccountNumber();
        this.status = accident.getStatus();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getDamage() {
        return damage;
    }

    public void setDamage(long damage) {
        this.damage = damage;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String  accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccidentStatus getStatus() {
        return status;
    }

    public void setStatus(AccidentStatus status) {
        this.status = status;
    }
}