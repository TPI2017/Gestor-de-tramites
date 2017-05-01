package com.tramitesAcad;

import com.tramitesAcad.datos.PasoRequisito;
import com.tramitesAcad.negocios.PasoRequisitoFacadeLocal;
import com.tramitesAcad.negocios.PasoFacadeLocal;
import com.tramitesAcad.negocios.RequisitoFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class FrmPasoRequisito implements Serializable{
    
    
@EJB
private PasoFacadeLocal PasoFacade;

@EJB
private RequisitoFacadeLocal RequisitoFacade;

@EJB
private PasoRequisitoFacadeLocal pasoRequistoFacade;

private PasoRequisito pr = new PasoRequisito();
    
    
    
    
}
