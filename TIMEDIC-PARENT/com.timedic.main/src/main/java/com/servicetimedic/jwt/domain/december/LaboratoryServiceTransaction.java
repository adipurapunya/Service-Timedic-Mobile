/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servicetimedic.jwt.domain.december;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "laboratory_service_transaction")
public class LaboratoryServiceTransaction implements Serializable {
    @OneToMany(mappedBy = "idLaboratoryServiceTransaction")
    private Collection<LaboratorySelectedPackageTransaction> laboratorySelectedPackageTransactionCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_price")
    private Float totalPrice;
    @Size(max = 255)
    @Column(name = "transaction_description")
    private String transactionDescription;
    @Column(name = "location_latitude")
    private Float locationLatitude;
    @Column(name = "location_longitude")
    private Float locationLongitude;
    @Size(max = 255)
    @Column(name = "employee_id_number")
    private String employeeIdNumber;
    @OneToMany(mappedBy = "idLaboratoryServiceTransaction")
    private Collection<LaboratorySelectedServiceTransaction> laboratorySelectedServiceTransactionCollection;
    @JoinColumn(name = "id_laboratory_clinic", referencedColumnName = "id")
    @ManyToOne
    private LaboratoryLaboratoryClinic idLaboratoryClinic;
    @JoinColumn(name = "id_patient", referencedColumnName = "id")
    @ManyToOne
    private HomecarePatient idPatient;
    @JoinColumn(name = "transaction_status", referencedColumnName = "id")
    @ManyToOne
    private SystemTransactionStatus transactionStatus;
    @JoinColumn(name = "id_service_package", referencedColumnName = "id")
    @ManyToOne
    private LaboratoryPackage idServicePackage;

    public LaboratoryServiceTransaction() {
    }

    public LaboratoryServiceTransaction(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public Float getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(Float locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public Float getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(Float locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    public String getEmployeeIdNumber() {
        return employeeIdNumber;
    }

    public void setEmployeeIdNumber(String employeeIdNumber) {
        this.employeeIdNumber = employeeIdNumber;
    }

    @XmlTransient
    public Collection<LaboratorySelectedServiceTransaction> getLaboratorySelectedServiceTransactionCollection() {
        return laboratorySelectedServiceTransactionCollection;
    }

    public void setLaboratorySelectedServiceTransactionCollection(Collection<LaboratorySelectedServiceTransaction> laboratorySelectedServiceTransactionCollection) {
        this.laboratorySelectedServiceTransactionCollection = laboratorySelectedServiceTransactionCollection;
    }

    public LaboratoryLaboratoryClinic getIdLaboratoryClinic() {
        return idLaboratoryClinic;
    }

    public void setIdLaboratoryClinic(LaboratoryLaboratoryClinic idLaboratoryClinic) {
        this.idLaboratoryClinic = idLaboratoryClinic;
    }

    public HomecarePatient getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(HomecarePatient idPatient) {
        this.idPatient = idPatient;
    }

    public SystemTransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(SystemTransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public LaboratoryPackage getIdServicePackage() {
        return idServicePackage;
    }

    public void setIdServicePackage(LaboratoryPackage idServicePackage) {
        this.idServicePackage = idServicePackage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LaboratoryServiceTransaction)) {
            return false;
        }
        LaboratoryServiceTransaction other = (LaboratoryServiceTransaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "trial.entity.LaboratoryServiceTransaction[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<LaboratorySelectedPackageTransaction> getLaboratorySelectedPackageTransactionCollection() {
        return laboratorySelectedPackageTransactionCollection;
    }

    public void setLaboratorySelectedPackageTransactionCollection(Collection<LaboratorySelectedPackageTransaction> laboratorySelectedPackageTransactionCollection) {
        this.laboratorySelectedPackageTransactionCollection = laboratorySelectedPackageTransactionCollection;
    }
    
}
