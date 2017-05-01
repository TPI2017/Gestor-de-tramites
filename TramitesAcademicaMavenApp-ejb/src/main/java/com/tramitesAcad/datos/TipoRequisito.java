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
@Table(name = "tipo_requisito", catalog = "gestor_tramites", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRequisito.findAll", query = "SELECT t FROM TipoRequisito t")
    , @NamedQuery(name = "TipoRequisito.findByIdTipoRequisito", query = "SELECT t FROM TipoRequisito t WHERE t.idTipoRequisito = :idTipoRequisito")
    , @NamedQuery(name = "TipoRequisito.findByNombreTipo", query = "SELECT t FROM TipoRequisito t WHERE t.nombreTipo = :nombreTipo")
    , @NamedQuery(name = "TipoRequisito.findByEstado", query = "SELECT t FROM TipoRequisito t WHERE t.estado = :estado")
    , @NamedQuery(name = "TipoRequisito.findByObservaciones", query = "SELECT t FROM TipoRequisito t WHERE t.observaciones = :observaciones")})
public class TipoRequisito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_requisito", nullable = false)
    private Integer idTipoRequisito;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoRequisitoIdTipoRequisito", fetch = FetchType.LAZY)
    private List<Requisito> requisitoList;

    public TipoRequisito() {
    }

    public TipoRequisito(Integer idTipoRequisito) {
        this.idTipoRequisito = idTipoRequisito;
    }

    public TipoRequisito(Integer idTipoRequisito, String nombreTipo, boolean estado) {
        this.idTipoRequisito = idTipoRequisito;
        this.nombreTipo = nombreTipo;
        this.estado = estado;
    }

    public Integer getIdTipoRequisito() {
        return idTipoRequisito;
    }

    public void setIdTipoRequisito(Integer idTipoRequisito) {
        this.idTipoRequisito = idTipoRequisito;
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
    public List<Requisito> getRequisitoList() {
        return requisitoList;
    }

    public void setRequisitoList(List<Requisito> requisitoList) {
        this.requisitoList = requisitoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoRequisito != null ? idTipoRequisito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRequisito)) {
            return false;
        }
        TipoRequisito other = (TipoRequisito) object;
        if ((this.idTipoRequisito == null && other.idTipoRequisito != null) || (this.idTipoRequisito != null && !this.idTipoRequisito.equals(other.idTipoRequisito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tramitesAcad.datos.TipoRequisito[ idTipoRequisito=" + idTipoRequisito + " ]";
    }
    
}
