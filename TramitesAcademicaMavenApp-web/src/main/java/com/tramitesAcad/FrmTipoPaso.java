package com.tramitesAcad;

import com.tramitesAcad.datos.TipoPaso;
import com.tramitesAcad.negocios.TipoPasoFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@Named
@ViewScoped
public class FrmTipoPaso implements Serializable {
 private LazyDataModel<TipoPaso> modelo;
     
    @EJB
    private TipoPasoFacadeLocal tipoPasoFacade;

    private TipoPaso tps = new TipoPaso();

    public FrmTipoPaso() {
    }

      
    @PostConstruct
    public void init(){
        //this.registro=new TipoPaso();
        
         setModelo(new LazyDataModel<TipoPaso>(){

            @Override
            public List<TipoPaso> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                List salida = new ArrayList();
                if(tipoPasoFacade != null){
                    this.setRowCount(tipoPasoFacade.count());
                    int[] rango = new int[2];
                    rango[0] = first;
                    rango[1] = pageSize;
                    salida = tipoPasoFacade.findRange(rango);
                }
                return salida;
            }

            @Override
            public Object getRowKey(TipoPaso object) {
                return object.getIdTipoPaso();
            }

            @Override
            public TipoPaso getRowData(String rowKey) {
                if(this.getWrappedData()!=null){
                    List<TipoPaso> lista = (List<TipoPaso>) this.getWrappedData();
                    if(!lista.isEmpty()) {
                        for(TipoPaso get : lista) {
                            if(get.getIdTipoPaso().compareTo(Integer.parseInt(rowKey))==0) {
                                return get;
                            }
                        }
                    }
                }
                return null;
            }       
        });
    
    
    }
    
    
    public LazyDataModel<TipoPaso> getModelo() {
        return modelo;
    }

    public void setModelo(LazyDataModel<TipoPaso> modelo) {
        this.modelo = modelo;
    }
    
   
    public List<TipoPaso> getFindAll() {

        return tipoPasoFacade.findAll();

    }

    public TipoPaso getTps() {
        return tps;
    }

    public void setTps(TipoPaso tps) {
        this.tps = tps;
    }

    public String Crear() {
        tipoPasoFacade.create(tps);
        this.tps = new TipoPaso();
        return "tabla:tablappal";
    }

    public void Eliminar() {
        tipoPasoFacade.remove(tps);  
        this.tps = new TipoPaso();
    }

    public String Editar(TipoPaso tp) {

        this.tps = tp;

        return "form";
    }

    public String Modificar() {

        this.tipoPasoFacade.edit(this.tps);

        this.tps = new TipoPaso();

        return "tabla:tablappal";
    }

    public String Cancelar() {
        this.tps = new TipoPaso();
        return "tabla:tablappal";
    }

}
