/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tramitesAcad.negocios;

import com.tramitesAcad.datos.TipoPaso;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author daniel
 */
@Stateless
public class TipoPasoFacade extends AbstractFacade<TipoPaso> implements TipoPasoFacadeLocal{
    
     @PersistenceContext(unitName = "com.tramitesAcad_TramitesAcademicaMavenApp-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoPasoFacade() {
        super(TipoPaso.class);
    }
    
}
