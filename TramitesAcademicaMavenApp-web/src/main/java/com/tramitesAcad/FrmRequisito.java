
package com.tramitesAcad;

import com.tramitesAcad.datos.Paso;
import com.tramitesAcad.datos.Requisito;
import com.tramitesAcad.datos.TipoPaso;
import com.tramitesAcad.datos.TipoRequisito;
import com.tramitesAcad.negocios.RequisitoFacadeLocal;
import com.tramitesAcad.negocios.TipoRequisitoFacadeLocal;
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
public class FrmRequisito implements Serializable{

    @EJB
    private TipoRequisitoFacadeLocal tipoRequisitoFacade;

    @EJB
    private RequisitoFacadeLocal requisitoFacade;
  
    private Requisito rq = new Requisito();
    
    private LazyDataModel<Requisito> modelo;
       
    private TipoRequisito tipoRequisito;
    
    private List<TipoRequisito> listaTipos;
    
    public FrmRequisito() {

        this.tipoRequisito = new TipoRequisito();

    }

        
    
    
     @PostConstruct
    public void init(){
        //this.registro=new TipoPaso();
        this.listaTipos= tipoRequisitoFacade.findAll();
        
         setModelo(new LazyDataModel<Requisito>(){

            @Override
            public List<Requisito> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                List salida = new ArrayList();
                if(requisitoFacade != null){
                    this.setRowCount(requisitoFacade.count());
                    int[] rango = new int[2];
                    rango[0] = first;
                    rango[1] = pageSize;
                    salida = requisitoFacade.findRange(rango);
                }
                return salida;
            }

            @Override
            public Object getRowKey(Requisito object) {
                return object.getIdRequisito();
                            
            }

            @Override
            public Requisito getRowData(String rowKey) {
                if(this.getWrappedData()!=null){
                    List<Requisito> lista = (List<Requisito>) this.getWrappedData();
                    if(!lista.isEmpty()) {
                        for(Requisito get : lista) {
                            if(get.getIdRequisito().compareTo(Integer.parseInt(rowKey))==0) {
                                return get;
                            }
                        }
                    }
                }
                return null;
            }       
        });
    
    
    }
    
    
    public LazyDataModel<Requisito> getModelo() {
        return modelo;
    }

    public void setModelo(LazyDataModel<Requisito> modelo) {
        this.modelo = modelo;
    }
    
    


  
       public Integer getTipoSeleccionado(){
     if(rq!= null){
            if(rq.getIdTipoRequisitoIdTipoRequisito()!= null){
                return this.rq.getIdTipoRequisitoIdTipoRequisito().getIdTipoRequisito();
            } else {
                return null;
            }         
        } else {
            return null;
        }
    }
    
    public void setTipoSeleccionado(Integer idTipo){
        if(idTipo >= 0 && !this.listaTipos.isEmpty()){
            for(TipoRequisito tre : this.getListaTipos()) {
                if(Objects.equals(tre.getIdTipoRequisito(), idTipo)) {
                    if(this.rq.getIdTipoRequisitoIdTipoRequisito()!= null) {
                        this.rq.getIdTipoRequisitoIdTipoRequisito().setIdTipoRequisito(idTipo);
                    } else {
                        this.rq.setIdTipoRequisitoIdTipoRequisito(tre);
                    }
                }
            }
        }
    
    }

    public List<TipoRequisito> getListaTipos() {
        return listaTipos;
    }

    public void setListaTipos(List<TipoRequisito> listaTipos) {
        this.listaTipos = listaTipos;
    }
    
    














    
    
     public List<Requisito> getFindAll() {

        return requisitoFacade.findAll();

    }

    public Requisito getRq() {
        return rq;
    }

    public void setRq(Requisito rq) {
        this.rq = rq;
    }

          
    public String Crear() {
        rq.setIdTipoRequisitoIdTipoRequisito(tipoRequisitoFacade.find(tipoRequisito.getIdTipoRequisito()));
        requisitoFacade.create(rq);
        this.rq = new Requisito();
        tipoRequisito.setIdTipoRequisito(0);
        return "tabla:tablappal";
    }

    public void Eliminar() {
        rq.setIdTipoRequisitoIdTipoRequisito(tipoRequisitoFacade.find(tipoRequisito.getIdTipoRequisito()));
        requisitoFacade.remove(rq);
        this.rq = new Requisito();
          tipoRequisito.setIdTipoRequisito(0);
    }

    public String Editar(Requisito r) {

        this.rq = r;
        tipoRequisito.setIdTipoRequisito(r.getIdTipoRequisitoIdTipoRequisito().getIdTipoRequisito());
        return "frm";
    }

    public String Modificar() {

        rq.setIdTipoRequisitoIdTipoRequisito(tipoRequisitoFacade.find(tipoRequisito.getIdTipoRequisito()));
        this.requisitoFacade.edit(this.rq);
        this.rq = new Requisito();
        tipoRequisito.setIdTipoRequisito(0);
        return "tabla:tablappal";
    }

    public void Cancelar() {

        this.rq = new Requisito();

        tipoRequisito.setIdTipoRequisito(0);
        
    }

    public RequisitoFacadeLocal getRequisitoFacade() {
        return requisitoFacade;
    }

    public void setRequisitoFacade(RequisitoFacadeLocal requisitoFacade) {
        this.requisitoFacade = requisitoFacade;
    }

    public TipoRequisito getTipoRequisito() {
        return tipoRequisito;
    }

    public void setTipoRequisito(TipoRequisito tipoRequisito) {
        this.tipoRequisito = tipoRequisito;
    }

    
    
    
}
