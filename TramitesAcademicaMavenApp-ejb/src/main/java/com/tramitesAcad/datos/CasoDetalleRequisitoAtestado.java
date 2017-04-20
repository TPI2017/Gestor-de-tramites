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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dani
 */
@Entity
@Table(name = "caso_detalle_requisito_atestado", catalog = "gestor_tramites", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CasoDetalleRequisitoAtestado.findAll", query = "SELECT c FROM CasoDetalleRequisitoAtestado c")
    , @NamedQuery(name = "CasoDetalleRequisitoAtestado.findByIdCasoDetalleRequisitoAtestado", query = "SELECT c FROM CasoDetalleRequisitoAtestado c WHERE c.idCasoDetalleRequisitoAtestado = :idCasoDetalleRequisitoAtestado")
    , @NamedQuery(name = "CasoDetalleRequisitoAtestado.findByComentarios", query = "SELECT c FROM CasoDetalleRequisitoAtestado c WHERE c.comentarios = :comentarios")
    , @NamedQuery(name = "CasoDetalleRequisitoAtestado.findByFechaFin", query = "SELECT c FROM CasoDetalleRequisitoAtestado c WHERE c.fechaFin = :fechaFin")})
public class CasoDetalleRequisitoAtestado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_caso_detalle_requisito_atestado", nullable = false)
    private Integer idCasoDetalleRequisitoAtestado;
    @Size(max = 150)
    @Column(name = "comentarios", length = 150)
    private String comentarios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @JoinColumn(name = "Caso_detalle_requisito_id_caso_detalle_requisito", referencedColumnName = "id_caso_detalle_requisito", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CasoDetalleRequisito casodetallerequisitoidcasodetallerequisito;

    public CasoDetalleRequisitoAtestado() {
    }

    public CasoDetalleRequisitoAtestado(Integer idCasoDetalleRequisitoAtestado) {
        this.idCasoDetalleRequisitoAtestado = idCasoDetalleRequisitoAtestado;
    }

    public CasoDetalleRequisitoAtestado(Integer idCasoDetalleRequisitoAtestado, Date fechaFin) {
        this.idCasoDetalleRequisitoAtestado = idCasoDetalleRequisitoAtestado;
        this.fechaFin = fechaFin;
    }

    public Integer getIdCasoDetalleRequisitoAtestado() {
        return idCasoDetalleRequisitoAtestado;
    }

    public void setIdCasoDetalleRequisitoAtestado(Integer idCasoDetalleRequisitoAtestado) {
        this.idCasoDetalleRequisitoAtestado = idCasoDetalleRequisitoAtestado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public CasoDetalleRequisito getCasodetallerequisitoidcasodetallerequisito() {
        return casodetallerequisitoidcasodetallerequisito;
    }

    public void setCasodetallerequisitoidcasodetallerequisito(CasoDetalleRequisito casodetallerequisitoidcasodetallerequisito) {
        this.casodetallerequisitoidcasodetallerequisito = casodetallerequisitoidcasodetallerequisito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCasoDetalleRequisitoAtestado != null ? idCasoDetalleRequisitoAtestado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CasoDetalleRequisitoAtestado)) {
            return false;
        }
        CasoDetalleRequisitoAtestado other = (CasoDetalleRequisitoAtestado) object;
        if ((this.idCasoDetalleRequisitoAtestado == null && other.idCasoDetalleRequisitoAtestado != null) || (this.idCasoDetalleRequisitoAtestado != null && !this.idCasoDetalleRequisitoAtestado.equals(other.idCasoDetalleRequisitoAtestado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tramitesAcad.datos.CasoDetalleRequisitoAtestado[ idCasoDetalleRequisitoAtestado=" + idCasoDetalleRequisitoAtestado + " ]";
    }
    
}
