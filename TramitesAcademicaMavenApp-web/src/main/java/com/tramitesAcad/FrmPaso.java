package com.tramitesAcad;

import com.tramitesAcad.datos.Paso;
import com.tramitesAcad.datos.TipoPaso;
import com.tramitesAcad.negocios.PasoFacadeLocal;
import com.tramitesAcad.negocios.TipoPasoFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@Named
@ViewScoped
public class FrmPaso implements Serializable {

 
    private LazyDataModel<Paso> modelo;
    
    @EJB
    private PasoFacadeLocal PasoFacade;
    @EJB
    private TipoPasoFacadeLocal TipoPasoFacade;

    private Paso ps = new Paso();
    private List<TipoPaso> listaTipos;

    //Para la clave foránea
    private TipoPaso tipoPaso;

    //Lo inicializamos vacío
    public FrmPaso() {
        this.tipoPaso = new TipoPaso();
    }
    
    @PostConstruct
    public void init(){
        //this.registro=new TipoPaso();
        
        this.listaTipos= TipoPasoFacade.findAll();
        
         setModelo(new LazyDataModel<Paso>(){

            @Override
            public List<Paso> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                List salida = new ArrayList();
                if(PasoFacade != null){
                    this.setRowCount(PasoFacade.count());
                    int[] rango = new int[2];
                    rango[0] = first;
                    rango[1] = pageSize;
                    salida = PasoFacade.findRange(rango);
                }
                return salida;
            }

            @Override
            public Object getRowKey(Paso object) {
                return object.getIdPaso();
                            
            }

            @Override
            public Paso getRowData(String rowKey) {
                if(this.getWrappedData()!=null){
                    List<Paso> lista = (List<Paso>) this.getWrappedData();
                    if(!lista.isEmpty()) {
                        for(Paso get : lista) {
                            if(get.getIdPaso().compareTo(Integer.parseInt(rowKey))==0) {
                                return get;
                            }
                        }
                    }
                }
                return null;
            }       
        });
    
    
    }
    
    
    public LazyDataModel<Paso> getModelo() {
        return modelo;
    }

    public void setModelo(LazyDataModel<Paso> modelo) {
        this.modelo = modelo;
    }
    
    
    
    
       public Integer getTipoSeleccionado(){
     if(ps!= null){
            if(ps.getTipopasoidtipopaso()!= null){
                return this.ps.getTipopasoidtipopaso().getIdTipoPaso();
            } else {
                return null;
            }         
        } else {
            return null;
        }
    }
    
    public void setTipoSeleccionado(Integer idTipo){
        if(idTipo >= 0 && !this.listaTipos.isEmpty()){
            for(TipoPaso tpe : this.getListaTipos()) {
                if(Objects.equals(tpe.getIdTipoPaso(), idTipo)) {
                    if(this.ps.getTipopasoidtipopaso()!= null) {
                        this.ps.getTipopasoidtipopaso().setIdTipoPaso(idTipo);
                    } else {
                        this.ps.setTipopasoidtipopaso(tpe);
                    }
                }
            }
        }
    
    }

    public List<TipoPaso> getListaTipos() {
        return listaTipos;
    }

    public void setListaTipos(List<TipoPaso> listaTipos) {
        this.listaTipos = listaTipos;
    }
    
    
 
    /*
    public List<Paso> getFindAll() {
        return PasoFacade.findAll();
    }
*/
    public Paso getPs() {
//        tipoPaso.setIdTipoPaso(1);
        return ps;
    }

    public void setPs(Paso ps) {
        this.ps = ps;
    }

    public String Crear() {
        ps.setTipopasoidtipopaso(TipoPasoFacade.find(tipoPaso.getIdTipoPaso()));
        PasoFacade.create(ps);
        this.ps = new Paso();
        tipoPaso.setIdTipoPaso(0);
        return "tablaPaso:tablappal";
    }

    public void Eliminar() {
        ps.setTipopasoidtipopaso(TipoPasoFacade.find(tipoPaso.getIdTipoPaso()));
        PasoFacade.remove(ps);
        this.ps = new Paso();
        tipoPaso.setIdTipoPaso(0);
    }

    public String Editar(Paso p) {
        this.ps = p;
        tipoPaso.setIdTipoPaso(ps.getTipopasoidtipopaso().getIdTipoPaso());
        return "formularioAE";
    }

    public String Modificar() {
        ps.setTipopasoidtipopaso(TipoPasoFacade.find(tipoPaso.getIdTipoPaso()));
        this.PasoFacade.edit(this.ps);
        this.ps = new Paso();
        tipoPaso.setIdTipoPaso(0);
        return "tablaPaso:tablappal";
    }

    public void Cancelar() {
        this.ps = new Paso();
        tipoPaso.setIdTipoPaso(0);
    }

    public PasoFacadeLocal getPasoFacade() {
        return PasoFacade;
    }

    public void setPasoFacade(PasoFacadeLocal PasoFacade) {
        this.PasoFacade = PasoFacade;
    }

    public TipoPaso getTipoPaso() {
        return tipoPaso;
    }

    public void setTipoPaso(TipoPaso tipoPaso) {
        this.tipoPaso = tipoPaso;
    }

    
}
