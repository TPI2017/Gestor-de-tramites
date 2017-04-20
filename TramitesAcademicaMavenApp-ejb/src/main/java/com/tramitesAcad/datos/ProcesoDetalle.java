/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tramitesAcad.datos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dani
 */
@Entity
@Table(name = "proceso_detalle", catalog = "gestor_tramites", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesoDetalle.findAll", query = "SELECT p FROM ProcesoDetalle p")
    , @NamedQuery(name = "ProcesoDetalle.findByIdProcesoDetalle", query = "SELECT p FROM ProcesoDetalle p WHERE p.idProcesoDetalle = :idProcesoDetalle")
    , @NamedQuery(name = "ProcesoDetalle.findByTiempoAprox", query = "SELECT p FROM ProcesoDetalle p WHERE p.tiempoAprox = :tiempoAprox")})
public class ProcesoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proceso_detalle", nullable = false)
    private Integer idProcesoDetalle;
    @Column(name = "tiempoAprox")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tiempoAprox;
    @JoinColumn(name = "Paso_id_paso", referencedColumnName = "id_paso", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Paso pasoidpaso;
    @JoinColumn(name = "Proceso_id_proceso", referencedColumnName = "id_proceso", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Proceso procesoidproceso;

    public ProcesoDetalle() {
    }

    public ProcesoDetalle(Integer idProcesoDetalle) {
        this.idProcesoDetalle = idProcesoDetalle;
    }

    public Integer getIdProcesoDetalle() {
        return idProcesoDetalle;
    }

    public void setIdProcesoDetalle(Integer idProcesoDetalle) {
        this.idProcesoDetalle = idProcesoDetalle;
    }

    public Date getTiempoAprox() {
        return tiempoAprox;
    }

    public void setTiempoAprox(Date tiempoAprox) {
        this.tiempoAprox = tiempoAprox;
    }

    public Paso getPasoidpaso() {
        return pasoidpaso;
    }

    public void setPasoidpaso(Paso pasoidpaso) {
        this.pasoidpaso = pasoidpaso;
    }

    public Proceso getProcesoidproceso() {
        return procesoidproceso;
    }

    public void setProcesoidproceso(Proceso procesoidproceso) {
        this.procesoidproceso = procesoidproceso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcesoDetalle != null ? idProcesoDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesoDetalle)) {
            return false;
        }
        ProcesoDetalle other = (ProcesoDetalle) object;
        if ((this.idProcesoDetalle == null && other.idProcesoDetalle != null) || (this.idProcesoDetalle != null && !this.idProcesoDetalle.equals(other.idProcesoDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tramitesAcad.datos.ProcesoDetalle[ idProcesoDetalle=" + idProcesoDetalle + " ]";
    }
    
}
