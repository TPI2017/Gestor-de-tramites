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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dani
 */
@Entity
@Table(name = "paso_requisito", catalog = "gestor_tramites", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PasoRequisito.findAll", query = "SELECT p FROM PasoRequisito p")
    , @NamedQuery(name = "PasoRequisito.findByIdPasoRequisito", query = "SELECT p FROM PasoRequisito p WHERE p.idPasoRequisito = :idPasoRequisito")
    , @NamedQuery(name = "PasoRequisito.findByComentarios", query = "SELECT p FROM PasoRequisito p WHERE p.comentarios = :comentarios")})
public class PasoRequisito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_paso_requisito", nullable = false)
    private Integer idPasoRequisito;
    @Size(max = 100)
    @Column(name = "comentarios", length = 100)
    private String comentarios;
    @JoinColumn(name = "Paso_id_paso", referencedColumnName = "id_paso", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Paso pasoidpaso;
    @JoinColumn(name = "Requisito_id_requisito", referencedColumnName = "id_requisito", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Requisito requisitoidrequisito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pasoRequisitoIdPasoRequisito", fetch = FetchType.LAZY)
    private List<CasoDetalleRequisito> casoDetalleRequisitoList;

    public PasoRequisito() {
    }

    public PasoRequisito(Integer idPasoRequisito) {
        this.idPasoRequisito = idPasoRequisito;
    }

    public Integer getIdPasoRequisito() {
        return idPasoRequisito;
    }

    public void setIdPasoRequisito(Integer idPasoRequisito) {
        this.idPasoRequisito = idPasoRequisito;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Paso getPasoidpaso() {
        return pasoidpaso;
    }

    public void setPasoidpaso(Paso pasoidpaso) {
        this.pasoidpaso = pasoidpaso;
    }

    public Requisito getRequisitoidrequisito() {
        return requisitoidrequisito;
    }

    public void setRequisitoidrequisito(Requisito requisitoidrequisito) {
        this.requisitoidrequisito = requisitoidrequisito;
    }

    @XmlTransient
    public List<CasoDetalleRequisito> getCasoDetalleRequisitoList() {
        return casoDetalleRequisitoList;
    }

    public void setCasoDetalleRequisitoList(List<CasoDetalleRequisito> casoDetalleRequisitoList) {
        this.casoDetalleRequisitoList = casoDetalleRequisitoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPasoRequisito != null ? idPasoRequisito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PasoRequisito)) {
            return false;
        }
        PasoRequisito other = (PasoRequisito) object;
        if ((this.idPasoRequisito == null && other.idPasoRequisito != null) || (this.idPasoRequisito != null && !this.idPasoRequisito.equals(other.idPasoRequisito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tramitesAcad.datos.PasoRequisito[ idPasoRequisito=" + idPasoRequisito + " ]";
    }
    
}
