/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tramitesAcad.datos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dani
 */
@Entity
@Table(name = "proceso", catalog = "gestor_tramites", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proceso.findAll", query = "SELECT p FROM Proceso p")
    , @NamedQuery(name = "Proceso.findByIdProceso", query = "SELECT p FROM Proceso p WHERE p.idProceso = :idProceso")
    , @NamedQuery(name = "Proceso.findByNombreProceso", query = "SELECT p FROM Proceso p WHERE p.nombreProceso = :nombreProceso")})
public class Proceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_proceso", nullable = false)
    private Integer idProceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_proceso", nullable = false, length = 45)
    private String nombreProceso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procesoidproceso", fetch = FetchType.LAZY)
    private List<ProcesoDetalle> procesoDetalleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procesoidproceso", fetch = FetchType.LAZY)
    private List<Caso> casoList;

    public Proceso() {
    }

    public Proceso(Integer idProceso) {
        this.idProceso = idProceso;
    }

    public Proceso(Integer idProceso, String nombreProceso) {
        this.idProceso = idProceso;
        this.nombreProceso = nombreProceso;
    }

    public Integer getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(Integer idProceso) {
        this.idProceso = idProceso;
    }

    public String getNombreProceso() {
        return nombreProceso;
    }

    public void setNombreProceso(String nombreProceso) {
        this.nombreProceso = nombreProceso;
    }

    @XmlTransient
    public List<ProcesoDetalle> getProcesoDetalleList() {
        return procesoDetalleList;
    }

    public void setProcesoDetalleList(List<ProcesoDetalle> procesoDetalleList) {
        this.procesoDetalleList = procesoDetalleList;
    }

    @XmlTransient
    public List<Caso> getCasoList() {
        return casoList;
    }

    public void setCasoList(List<Caso> casoList) {
        this.casoList = casoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProceso != null ? idProceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proceso)) {
            return false;
        }
        Proceso other = (Proceso) object;
        if ((this.idProceso == null && other.idProceso != null) || (this.idProceso != null && !this.idProceso.equals(other.idProceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tramitesAcad.datos.Proceso[ idProceso=" + idProceso + " ]";
    }
    
}
