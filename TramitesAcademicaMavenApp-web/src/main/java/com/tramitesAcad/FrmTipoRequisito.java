package com.tramitesAcad;

import com.tramitesAcad.datos.TipoPaso;
import com.tramitesAcad.datos.TipoRequisito;
import com.tramitesAcad.negocios.TipoRequisitoFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.ListDataModel;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@Named
@ViewScoped
public class FrmTipoRequisito implements Serializable {

    /* private Integer idTipoRequisito;
    private String nombreTipo;
    private boolean estado;
    private String observaciones;*/
    private TipoRequisito trq = new TipoRequisito();

    /*   private TipoRequisito current;
    private DataModel items = null;
     */
    @EJB
    private TipoRequisitoFacadeLocal TipoRequisitoFacade;
    // private CustomModel custom;

    private LazyDataModel<TipoRequisito> modelo;
    public FrmTipoRequisito() {
    }

        
    @PostConstruct
    public void init(){
        //this.registro=new TipoPaso();
        
         setModelo(new LazyDataModel<TipoRequisito>(){

            @Override
            public List<TipoRequisito> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                List salida = new ArrayList();
                if(TipoRequisitoFacade != null){
                    this.setRowCount(TipoRequisitoFacade.count());
                    int[] rango = new int[2];
                    rango[0] = first;
                    rango[1] = pageSize;
                    salida = TipoRequisitoFacade.findRange(rango);
                }
                return salida;
            }

            @Override
            public Object getRowKey(TipoRequisito object) {
                return object.getIdTipoRequisito();
            }

            @Override
            public TipoRequisito getRowData(String rowKey) {
                if(this.getWrappedData()!=null){
                    List<TipoRequisito> lista = (List<TipoRequisito>) this.getWrappedData();
                    if(!lista.isEmpty()) {
                        for(TipoRequisito get : lista) {
                            if(get.getIdTipoRequisito().compareTo(Integer.parseInt(rowKey))==0) {
                                return get;
                            }
                        }
                    }
                }
                return null;
            }       
        });
    
    
    }
    
    
    public LazyDataModel<TipoRequisito> getModelo() {
        return modelo;
    }

    public void setModelo(LazyDataModel<TipoRequisito> modelo) {
        this.modelo = modelo;
    }
    
   
    public List<TipoRequisito> getFindAll() {

        return TipoRequisitoFacade.findAll();

    }
    

    public TipoRequisito getTrq() {
        return trq;
    }

    public void setTrq(TipoRequisito trq) {
        this.trq = trq;
    }

    //Método para agregar un nuevo registro a la tabla
    //Botón Agregar
    public String Crear() {

        TipoRequisitoFacade.create(trq);

        this.trq = new TipoRequisito();

        return "tabla:tablappal";

    }

    //Método para eliminar un registro a la tabla
     public void Eliminar() {

        TipoRequisitoFacade.remove(trq);
        
        this.trq = new TipoRequisito();
       

    }

//    //Método para cargar unregistro de nuevo al formulario para poder editarlo
//    //Botón Editar
//    public String Editar(TipoRequisito tr) {
//
//        this.trq = tr;
//
//        return "frm";
//    }

    //Método para modificar el registro seleccionado por el método Editar()
    //Botón Modificar
    public String Modificar() {

        this.TipoRequisitoFacade.edit(this.trq);

        this.trq = new TipoRequisito();

        return "tabla:tablappal";
    }

    //Método para cancelar un cambio
    //Botón Cancelar
    public void Cancelar() {

        this.trq = new TipoRequisito();

       
    }
}
