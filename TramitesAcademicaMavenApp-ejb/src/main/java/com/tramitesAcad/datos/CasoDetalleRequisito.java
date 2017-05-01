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
@Table(name = "caso_detalle_requisito", catalog = "gestor_tramites", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CasoDetalleRequisito.findAll", query = "SELECT c FROM CasoDetalleRequisito c")
    , @NamedQuery(name = "CasoDetalleRequisito.findByIdCasoDetalleRequisito", query = "SELECT c FROM CasoDetalleRequisito c WHERE c.idCasoDetalleRequisito = :idCasoDetalleRequisito")
    , @NamedQuery(name = "CasoDetalleRequisito.findByEstadoAceptadoRechazado", query = "SELECT c FROM CasoDetalleRequisito c WHERE c.estadoAceptadoRechazado = :estadoAceptadoRechazado")
    , @NamedQuery(name = "CasoDetalleRequisito.findByFecha", query = "SELECT c FROM CasoDetalleRequisito c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "CasoDetalleRequisito.findByComentarios", query = "SELECT c FROM CasoDetalleRequisito c WHERE c.comentarios = :comentarios")})
public class CasoDetalleRequisito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_caso_detalle_requisito", nullable = false)
    private Integer idCasoDetalleRequisito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_aceptado_rechazado", nullable = false)
    private boolean estadoAceptadoRechazado;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "comentarios", nullable = false, length = 150)
    private String comentarios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "casodetallerequisitoidcasodetallerequisito", fetch = FetchType.LAZY)
    private List<CasoDetalleRequisitoAtestado> casoDetalleRequisitoAtestadoList;
    @JoinColumn(name = "Caso_detalle_id_caso", referencedColumnName = "id_caso_detalle", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CasoDetalle casodetalleidcaso;
    @JoinColumn(name = "paso_requisito_id_paso_requisito", referencedColumnName = "id_paso_requisito", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PasoRequisito pasoRequisitoIdPasoRequisito;

    public CasoDetalleRequisito() {
    }

    public CasoDetalleRequisito(Integer idCasoDetalleRequisito) {
        this.idCasoDetalleRequisito = idCasoDetalleRequisito;
    }

    public CasoDetalleRequisito(Integer idCasoDetalleRequisito, boolean estadoAceptadoRechazado, String comentarios) {
        this.idCasoDetalleRequisito = idCasoDetalleRequisito;
        this.estadoAceptadoRechazado = estadoAceptadoRechazado;
        this.comentarios = comentarios;
    }

    public Integer getIdCasoDetalleRequisito() {
        return idCasoDetalleRequisito;
    }

    public void setIdCasoDetalleRequisito(Integer idCasoDetalleRequisito) {
        this.idCasoDetalleRequisito = idCasoDetalleRequisito;
    }

    public boolean getEstadoAceptadoRechazado() {
        return estadoAceptadoRechazado;
    }

    public void setEstadoAceptadoRechazado(boolean estadoAceptadoRechazado) {
        this.estadoAceptadoRechazado = estadoAceptadoRechazado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @XmlTransient
    public List<CasoDetalleRequisitoAtestado> getCasoDetalleRequisitoAtestadoList() {
        return casoDetalleRequisitoAtestadoList;
    }

    public void setCasoDetalleRequisitoAtestadoList(List<CasoDetalleRequisitoAtestado> casoDetalleRequisitoAtestadoList) {
        this.casoDetalleRequisitoAtestadoList = casoDetalleRequisitoAtestadoList;
    }

    public CasoDetalle getCasodetalleidcaso() {
        return casodetalleidcaso;
    }

    public void setCasodetalleidcaso(CasoDetalle casodetalleidcaso) {
        this.casodetalleidcaso = casodetalleidcaso;
    }

    public PasoRequisito getPasoRequisitoIdPasoRequisito() {
        return pasoRequisitoIdPasoRequisito;
    }

    public void setPasoRequisitoIdPasoRequisito(PasoRequisito pasoRequisitoIdPasoRequisito) {
        this.pasoRequisitoIdPasoRequisito = pasoRequisitoIdPasoRequisito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCasoDetalleRequisito != null ? idCasoDetalleRequisito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CasoDetalleRequisito)) {
            return false;
        }
        CasoDetalleRequisito other = (CasoDetalleRequisito) object;
        if ((this.idCasoDetalleRequisito == null && other.idCasoDetalleRequisito != null) || (this.idCasoDetalleRequisito != null && !this.idCasoDetalleRequisito.equals(other.idCasoDetalleRequisito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tramitesAcad.datos.CasoDetalleRequisito[ idCasoDetalleRequisito=" + idCasoDetalleRequisito + " ]";
    }
    
}
