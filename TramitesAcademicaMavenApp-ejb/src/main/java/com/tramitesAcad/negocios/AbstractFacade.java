/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tramitesAcad.negocios;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author daniel
 */
public abstract class AbstractFacade<T> {
    
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        try {
            if(getEntityManager()!=null && entity!=null) {
                getEntityManager().persist(entity);
            }          
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }          
    }

    public void edit(T entity) {
        try {
            if(getEntityManager()!=null && entity!=null) {
                getEntityManager().merge(entity);
            }  
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }      
    }

    public void remove(T entity) {
        try {
            if(getEntityManager()!=null && entity!=null) {
                getEntityManager().remove(getEntityManager().merge(entity));
            }  
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }        
    }

    public T find(Object id) {
        T salida = null;
        try {
            if(getEntityManager()!=null && entityClass!=null && id!=null) {
                return getEntityManager().find(entityClass, id);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        } finally {
            salida = (T) new Object();
        }
        return salida;
    }

    public List<T> findAll() {
        List salida = null;
        try {
            if(getEntityManager()!=null && entityClass!=null) {
                javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
                cq.select(cq.from(entityClass));
                return getEntityManager().createQuery(cq).getResultList();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        } finally {
            salida = new ArrayList();
        }
        return salida;
    }

    public List<T> findRange(int[] range) {
        List salida = null;
        try {
            if(getEntityManager()!=null && entityClass!=null) {
                javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
                cq.select(cq.from(entityClass));
                javax.persistence.Query q = getEntityManager().createQuery(cq);
                q.setMaxResults(range[1] - range[0] + 1);
                q.setFirstResult(range[0]);
                return q.getResultList();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        } finally {
            salida = new ArrayList();
        }
        return salida;
    }

    public int count() {
        int salida;
        try {
            if(getEntityManager()!=null && entityClass!=null) {
                javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
                javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
                cq.select(getEntityManager().getCriteriaBuilder().count(rt));
                javax.persistence.Query q = getEntityManager().createQuery(cq);
                return ((Long) q.getSingleResult()).intValue();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        } finally {
            salida = 0;
        }
        return salida;
    }
    
}
