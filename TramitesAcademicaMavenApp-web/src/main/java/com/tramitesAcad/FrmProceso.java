package com.tramitesAcad;

import com.tramitesAcad.datos.Proceso;
import com.tramitesAcad.negocios.ProcesoFacadeLocal;
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
public class FrmProceso implements Serializable{
    
    private LazyDataModel<Proceso> modelo;
    
    @EJB
    private ProcesoFacadeLocal procesoFacade;

    private Proceso pro = new Proceso();
    
    
        @PostConstruct
    public void init(){
         setModelo(new LazyDataModel<Proceso>(){

            @Override
            public List<Proceso> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                List salida = new ArrayList();
                if(procesoFacade != null){
                    this.setRowCount(procesoFacade.count());
                    int[] rango = new int[2];
                    rango[0] = first;
                    rango[1] = pageSize;
                    salida = procesoFacade.findRange(rango);
                }
                return salida;
            }

    @Override
    public Object getRowKey(Proceso object) {
                return object.getIdProceso();
            }

    @Override
    public Proceso getRowData(String rowKey) {
                if(this.getWrappedData()!=null){
                    List<Proceso> lista = (List<Proceso>) this.getWrappedData();
                    if(!lista.isEmpty()) {
                        for(Proceso get : lista) {
                            if(get.getIdProceso().compareTo(Integer.parseInt(rowKey))==0) {
                                return get;
                            }
                        }
                    }
                }
                return null;
            }       
        });
    
    
    }

    public LazyDataModel<Proceso> getModelo() {
        return modelo;
    }

    public void setModelo(LazyDataModel<Proceso> modelo) {
        this.modelo = modelo;
    }

    public Proceso getPro() {
        return pro;
    }

    public void setPro(Proceso pro) {
        this.pro = pro;
    }
    
    public String Crear() {
        procesoFacade.create(pro);
        this.pro = new Proceso();
        return "tabla:tablappal";
    }

    public void Eliminar() {
        procesoFacade.remove(pro);  
        this.pro = new Proceso();
    }

    public String Editar(Proceso pr) {

        this.pro = pr;

        return "form";
    }

    public String Modificar() {

        this.procesoFacade.edit(this.pro);

        this.pro = new Proceso();

        return "tabla:tablappal";
    }

    public String Cancelar() {
        this.pro = new Proceso();
        return "tabla:tablappal";
    }

    
    
    
    
    
    
    
}
