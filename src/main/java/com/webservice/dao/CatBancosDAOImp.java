package com.webservice.dao;

import com.webservice.hibernate.HibernateUtil;
import com.webservice.persistence.CatBancos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author USUARIO
 */
public class CatBancosDAOImp implements CatBancosDAO {

    @Override
    public void save(CatBancos cat) throws Exception {
        Session session = null;
        Transaction trans = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            trans = session.beginTransaction();
            session.save(cat);
            trans.commit();
        } catch (HibernateException he) {
            if (trans != null) {
                trans.rollback();
            }
            throw new HibernateException(he);
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void update(CatBancos cat) throws Exception {
        Session session = null;
        Transaction trans = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            trans = session.beginTransaction();
            session.update(cat);
            trans.commit();
        } catch (HibernateException he) {
            if (trans != null) {
                trans.rollback();
            }
            throw new HibernateException(he);
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(CatBancos cat) throws Exception {
        Session session = null;
        Transaction trans = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            trans = session.beginTransaction();
            session.delete(cat);
            trans.commit();
        } catch (HibernateException he) {
            if (trans != null) {
                trans.rollback();
            }
            throw new HibernateException(he);
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public CatBancos get(CatBancos cat) throws Exception {
        Session session = null;
        Transaction trans = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            trans = session.beginTransaction();
            
            CatBancos obj = (CatBancos) session.get(CatBancos.class, cat.getIdBanco());
            
            trans.commit();
            return obj;
        } catch (HibernateException he) {
            if (trans != null) {
                trans.rollback();
            }
            he.printStackTrace();
            throw new HibernateException(he);
            
        } catch (Exception e) {
            throw new Exception(e);
        }  finally {
//            if (session != null) {
//                session.close();
//            }
        }
    }

    @Override
    public List<CatBancos> list(CatBancos cat) throws Exception {
        Session session = null;
        Transaction trans = null;
        List<CatBancos> lista = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            trans = session.beginTransaction();

            List result;
            String squery;
            if (cat.getSbanco() != null) {
                squery = "from CatBancos where sbanco like :sbanco order by sbanco";
                result = session.createQuery(squery)
                        .setString("sbanco", "%" + cat.getSbanco() + "%")
                        .list();
            } else {
                squery = "from CatBancos order by sbanco";
                result = session.createQuery(squery).list();
            }

            if (!result.isEmpty()) {
                lista = new ArrayList();
                for (Iterator iterator = result.iterator(); iterator.hasNext();) {
                    CatBancos obj = (CatBancos) iterator.next();
                    lista.add(obj);
                }
            }
            trans.commit();
            return lista;
        } catch (HibernateException he) {
            if (trans != null) {
                trans.rollback();
            }
            throw new HibernateException(he);
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
//            if (session != null) {
//                session.close();
//            }
        }
    }

}
