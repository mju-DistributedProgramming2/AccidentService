package com.omnm.accident.DTO;



import com.omnm.accident.enumeration.contract.ContractStatus;
import com.omnm.accident.enumeration.contract.ContractTerm;
import com.omnm.accident.enumeration.contract.PaymentCycle;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "contract")
public class Contract implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "customer_info_id", nullable = false)
    private Integer customerInfoId;
    @Column(name = "customer_id", nullable = false)
    private String customerId;
    @Column(name = "insurance_id", nullable = false)
    private Integer insuranceId;
    @Column(name = "sale_employee_id", nullable = false)
    private String saleEmployeeId;
    private ContractTerm term;
    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;
    @Column(name = "expiration_date", nullable = false)
    private Timestamp expirationDate;
    @Column(name = "payment_fee", nullable = false)
    private Integer paymentFee;
    @Column(name = "payment_cycle", nullable = false)
    private PaymentCycle paymentCycle;
    @Column(name = "payment_deadline", nullable = false)
    private Timestamp paymentDeadline;
    private Integer compensation;
    @Column(name = "contract_status", nullable = false)
    private ContractStatus contractStatus;

    public Contract(Integer customerInfoId, Integer insuranceId, String saleEmployeeId, String customerId, ContractTerm term, Integer paymentFee, PaymentCycle paymentCycle, Integer compensation, ContractStatus contractStatus) {
        this.customerInfoId = customerInfoId;
        this.insuranceId = insuranceId;
        this.saleEmployeeId = saleEmployeeId;
        this.customerId=customerId;
        this.term = term;
        this.paymentFee = paymentFee;
        this.paymentCycle = paymentCycle;
        this.compensation = compensation;
        this.contractStatus = contractStatus;
    }

    public Contract() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerInfoId() {
        return customerInfoId;
    }

    public void setCustomerInfoId(Integer customerInfoId) {
        this.customerInfoId = customerInfoId;
    }

    public Integer getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Integer insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getSaleEmployeeId() {
        return saleEmployeeId;
    }

    public void setSaleEmployeeId(String saleEmployeeId) {
        this.saleEmployeeId = saleEmployeeId;
    }

    public ContractTerm getTerm() {
        return term;
    }

    public void setTerm(ContractTerm term) {
        this.term = term;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Timestamp expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getPaymentFee() {
        return paymentFee;
    }

    public void setPaymentFee(Integer paymentFee) {
        this.paymentFee = paymentFee;
    }

    public PaymentCycle getPayCycle() {
        return paymentCycle;
    }

    public void setPayCycle(PaymentCycle paymentCycle) {
        this.paymentCycle = paymentCycle;
    }

    public Timestamp getPaymentDeadline() {
        return paymentDeadline;
    }

    public void setPaymentDeadline(Timestamp paymentDeadline) {
        this.paymentDeadline = paymentDeadline;
    }

    public Integer getCompensation() {
        return compensation;
    }

    public void setCompensation(Integer compensation) {
        this.compensation = compensation;
    }

    public ContractStatus getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(ContractStatus contractStatus) {
        this.contractStatus = contractStatus;
    }

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

    public PaymentCycle getPaymentCycle() {
        return paymentCycle;
    }

    public void setPaymentCycle(PaymentCycle paymentCycle) {
        this.paymentCycle = paymentCycle;
    }
}
