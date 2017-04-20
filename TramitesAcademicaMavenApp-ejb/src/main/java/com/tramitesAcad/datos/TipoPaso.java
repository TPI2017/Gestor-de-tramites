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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "tipo_paso", catalog = "gestor_tramites", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPaso.findAll", query = "SELECT t FROM TipoPaso t")
    , @NamedQuery(name = "TipoPaso.findByIdTipoPaso", query = "SELECT t FROM TipoPaso t WHERE t.idTipoPaso = :idTipoPaso")
    , @NamedQuery(name = "TipoPaso.findByNombreTipo", query = "SELECT t FROM TipoPaso t WHERE t.nombreTipo = :nombreTipo")
    , @NamedQuery(name = "TipoPaso.findByEstado", query = "SELECT t FROM TipoPaso t WHERE t.estado = :estado")
    , @NamedQuery(name = "TipoPaso.findByObservaciones", query = "SELECT t FROM TipoPaso t WHERE t.observaciones = :observaciones")})
public class TipoPaso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_paso", nullable = false)
    private Integer idTipoPaso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_tipo", nullable = false, length = 45)
    private String nombreTipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado", nullable = false)
    private boolean estado;
    @Size(max = 150)
    @Column(name = "observaciones", length = 150)
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipopasoidtipopaso", fetch = FetchType.LAZY)
    private List<Paso> pasoList;

    public TipoPaso() {
    }

    public TipoPaso(Integer idTipoPaso) {
        this.idTipoPaso = idTipoPaso;
    }

    public TipoPaso(Integer idTipoPaso, String nombreTipo, boolean estado) {
        this.idTipoPaso = idTipoPaso;
        this.nombreTipo = nombreTipo;
        this.estado = estado;
    }

    public Integer getIdTipoPaso() {
        return idTipoPaso;
    }

    public void setIdTipoPaso(Integer idTipoPaso) {
        this.idTipoPaso = idTipoPaso;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<Paso> getPasoList() {
        return pasoList;
    }

    public void setPasoList(List<Paso> pasoList) {
        this.pasoList = pasoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPaso != null ? idTipoPaso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPaso)) {
            return false;
        }
        TipoPaso other = (TipoPaso) object;
        if ((this.idTipoPaso == null && other.idTipoPaso != null) || (this.idTipoPaso != null && !this.idTipoPaso.equals(other.idTipoPaso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tramitesAcad.datos.TipoPaso[ idTipoPaso=" + idTipoPaso + " ]";
    }
    
}
