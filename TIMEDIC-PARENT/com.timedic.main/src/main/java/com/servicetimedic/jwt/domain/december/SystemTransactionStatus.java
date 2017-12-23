/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servicetimedic.jwt.domain.december;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hafid
 */
@Entity
@Table(name = "system_transaction_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SystemTransactionStatus.findAll", query = "SELECT s FROM SystemTransactionStatus s"),
    @NamedQuery(name = "SystemTransactionStatus.findById", query = "SELECT s FROM SystemTransactionStatus s WHERE s.id = :id"),
    @NamedQuery(name = "SystemTransactionStatus.findByStatus", query = "SELECT s FROM SystemTransactionStatus s WHERE s.status = :status")})
public class SystemTransactionStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "status")
    private String status;
    @OneToMany(mappedBy = "transactionStatusId")
    private List<HomecareServiceTransaction> homecareServiceTransactionList;
    @OneToMany(mappedBy = "transactionStatus")
    private List<LaboratoryServiceTransaction> laboratoryServiceTransactionList;

    public SystemTransactionStatus() {
    }

    public SystemTransactionStatus(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<HomecareServiceTransaction> getHomecareServiceTransactionList() {
        return homecareServiceTransactionList;
    }

    public void setHomecareServiceTransactionList(List<HomecareServiceTransaction> homecareServiceTransactionList) {
        this.homecareServiceTransactionList = homecareServiceTransactionList;
    }

    @XmlTransient
    public List<LaboratoryServiceTransaction> getLaboratoryServiceTransactionList() {
        return laboratoryServiceTransactionList;
    }

    public void setLaboratoryServiceTransactionList(List<LaboratoryServiceTransaction> laboratoryServiceTransactionList) {
        this.laboratoryServiceTransactionList = laboratoryServiceTransactionList;
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
        if (!(object instanceof SystemTransactionStatus)) {
            return false;
        }
        SystemTransactionStatus other = (SystemTransactionStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "trial.entity.SystemTransactionStatus[ id=" + id + " ]";
    }
    
}