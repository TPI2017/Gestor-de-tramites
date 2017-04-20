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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "requisito", catalog = "gestor_tramites", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requisito.findAll", query = "SELECT r FROM Requisito r")
    , @NamedQuery(name = "Requisito.findByIdRequisito", query = "SELECT r FROM Requisito r WHERE r.idRequisito = :idRequisito")
    , @NamedQuery(name = "Requisito.findByNombreRequisito", query = "SELECT r FROM Requisito r WHERE r.nombreRequisito = :nombreRequisito")
    , @NamedQuery(name = "Requisito.findByDescripcion", query = "SELECT r FROM Requisito r WHERE r.descripcion = :descripcion")})
public class Requisito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_requisito", nullable = false)
    private Integer idRequisito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_requisito", nullable = false, length = 45)
    private String nombreRequisito;
    @Size(max = 150)
    @Column(name = "descripcion", length = 150)
    private String descripcion;
    @JoinColumn(name = "id_tipo_requisito_id_tipo_requisito", referencedColumnName = "id_tipo_requisito", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoRequisito idTipoRequisitoIdTipoRequisito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisitoidrequisito", fetch = FetchType.LAZY)
    private List<PasoRequisito> pasoRequisitoList;

    public Requisito() {
    }

    public Requisito(Integer idRequisito) {
        this.idRequisito = idRequisito;
    }

    public Requisito(Integer idRequisito, String nombreRequisito) {
        this.idRequisito = idRequisito;
        this.nombreRequisito = nombreRequisito;
    }

    public Integer getIdRequisito() {
        return idRequisito;
    }

    public void setIdRequisito(Integer idRequisito) {
        this.idRequisito = idRequisito;
    }

    public String getNombreRequisito() {
        return nombreRequisito;
    }

    public void setNombreRequisito(String nombreRequisito) {
        this.nombreRequisito = nombreRequisito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoRequisito getIdTipoRequisitoIdTipoRequisito() {
        return idTipoRequisitoIdTipoRequisito;
    }

    public void setIdTipoRequisitoIdTipoRequisito(TipoRequisito idTipoRequisitoIdTipoRequisito) {
        this.idTipoRequisitoIdTipoRequisito = idTipoRequisitoIdTipoRequisito;
    }

    @XmlTransient
    public List<PasoRequisito> getPasoRequisitoList() {
        return pasoRequisitoList;
    }

    public void setPasoRequisitoList(List<PasoRequisito> pasoRequisitoList) {
        this.pasoRequisitoList = pasoRequisitoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRequisito != null ? idRequisito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisito)) {
            return false;
        }
        Requisito other = (Requisito) object;
        if ((this.idRequisito == null && other.idRequisito != null) || (this.idRequisito != null && !this.idRequisito.equals(other.idRequisito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tramitesAcad.datos.Requisito[ idRequisito=" + idRequisito + " ]";
    }
    
}
