/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servicetimedic.jwt.domain.december;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hafid
 */
@Entity
@Table(name = "laboratory_service_package")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LaboratoryServicePackage.findAll", query = "SELECT l FROM LaboratoryServicePackage l"),
    @NamedQuery(name = "LaboratoryServicePackage.findById", query = "SELECT l FROM LaboratoryServicePackage l WHERE l.id = :id")})
public class LaboratoryServicePackage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "id_laboratory_package", referencedColumnName = "id")
    @ManyToOne
    private LaboratoryPackage idLaboratoryPackage;
    @JoinColumn(name = "id_laboratory_service", referencedColumnName = "id")
    @ManyToOne
    private LaboratoryService idLaboratoryService;

    public LaboratoryServicePackage() {
    }

    public LaboratoryServicePackage(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LaboratoryPackage getIdLaboratoryPackage() {
        return idLaboratoryPackage;
    }

    public void setIdLaboratoryPackage(LaboratoryPackage idLaboratoryPackage) {
        this.idLaboratoryPackage = idLaboratoryPackage;
    }

    public LaboratoryService getIdLaboratoryService() {
        return idLaboratoryService;
    }

    public void setIdLaboratoryService(LaboratoryService idLaboratoryService) {
        this.idLaboratoryService = idLaboratoryService;
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
        if (!(object instanceof LaboratoryServicePackage)) {
            return false;
        }
        LaboratoryServicePackage other = (LaboratoryServicePackage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "trial.entity.LaboratoryServicePackage[ id=" + id + " ]";
    }
    
}