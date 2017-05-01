/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tramitesAcad.datos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dani
 */
@Entity
@Table(name = "caso_detalle", catalog = "gestor_tramites", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CasoDetalle.findAll", query = "SELECT c FROM CasoDetalle c")
    , @NamedQuery(name = "CasoDetalle.findByIdCasoDetalle", query = "SELECT c FROM CasoDetalle c WHERE c.idCasoDetalle = :idCasoDetalle")
    , @NamedQuery(name = "CasoDetalle.findByFechaInicio", query = "SELECT c FROM CasoDetalle c WHERE c.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "CasoDetalle.findByPersonaResponsable", query = "SELECT c FROM CasoDetalle c WHERE c.personaResponsable = :personaResponsable")})
public class CasoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_caso_detalle", nullable = false)
    private Integer idCasoDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "persona_responsable", nullable = false, length = 45)
    private String personaResponsable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "casodetalleidcaso", fetch = FetchType.LAZY)
    private List<CasoDetalleRequisito> casoDetalleRequisitoList;
    @JoinColumn(name = "Caso_id_caso", referencedColumnName = "id_caso", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Caso casoidcaso;

    public CasoDetalle() {
    }

    public CasoDetalle(Integer idCasoDetalle) {
        this.idCasoDetalle = idCasoDetalle;
    }

    public CasoDetalle(Integer idCasoDetalle, Date fechaInicio, String personaResponsable) {
        this.idCasoDetalle = idCasoDetalle;
        this.fechaInicio = fechaInicio;
        this.personaResponsable = personaResponsable;
    }

    public Integer getIdCasoDetalle() {
        return idCasoDetalle;
    }

    public void setIdCasoDetalle(Integer idCasoDetalle) {
        this.idCasoDetalle = idCasoDetalle;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getPersonaResponsable() {
        return personaResponsable;
    }

    public void setPersonaResponsable(String personaResponsable) {
        this.personaResponsable = personaResponsable;
    }

    @XmlTransient
    public List<CasoDetalleRequisito> getCasoDetalleRequisitoList() {
        return casoDetalleRequisitoList;
    }

    public void setCasoDetalleRequisitoList(List<CasoDetalleRequisito> casoDetalleRequisitoList) {
        this.casoDetalleRequisitoList = casoDetalleRequisitoList;
    }

    public Caso getCasoidcaso() {
        return casoidcaso;
    }

    public void setCasoidcaso(Caso casoidcaso) {
        this.casoidcaso = casoidcaso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCasoDetalle != null ? idCasoDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CasoDetalle)) {
            return false;
        }
        CasoDetalle other = (CasoDetalle) object;
        if ((this.idCasoDetalle == null && other.idCasoDetalle != null) || (this.idCasoDetalle != null && !this.idCasoDetalle.equals(other.idCasoDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tramitesAcad.datos.CasoDetalle[ idCasoDetalle=" + idCasoDetalle + " ]";
    }
    
}
