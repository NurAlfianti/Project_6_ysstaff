/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.TbJabatan;
import util.HibernateUtil;

/**
 *
 * @author laila
 */
public class DAOJabatan {
    
    public List<TbJabatan> getBy(String uStaffId, String uJbtn, String uGaji) {
    
        Transaction trans= null;
        TbJabatan jb = new TbJabatan();
        List<TbJabatan> jabatan = new ArrayList();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TbJabatan where staffId=:uStaffId AND jabatan=:uJbtn AND gaji=:uGaji");
            query.setString("uStaffId", uStaffId);
            query.setString("uJbtn", uJbtn);
            query.setString("uGaji", uGaji);
            jb = (TbJabatan) query.uniqueResult();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return jabatan;
    }
    
    
    public void add_jabatan(TbJabatan jabatan) {
    
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(jabatan);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    
    }
    
    
    public List<TbJabatan> retreveTbJabatan() {
    
        List jb = new ArrayList();
        TbJabatan jbl = new TbJabatan();
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TbJabatan");
            jb = query.list();
            jb.add(jbl.getJabatanId());
            jb.add(jbl.getStaffId());
            jb.add(jbl.getJabatan());
            jb.add(jbl.getGaji());
        } catch (Exception e) {
            System.out.println(e);
        }
        return jb;
    
    }
    
    
    public List<TbJabatan> getbyID(String idJ) {
    
        TbJabatan jb = new TbJabatan();
        List<TbJabatan> iJb = new ArrayList();
        
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
           trans = session.beginTransaction();
           Query query = session.createQuery("from TbJabatan where jabatanId=:id");
           query.setString("id", idJ);
           jb = (TbJabatan) query.uniqueResult();
           iJb = query.list();
           trans.commit();
        } catch (Exception e) {
           System.out.println(e);
        }
        return iJb;
    }
    
    
    public void deleteJabatan(Integer idJ) {
    
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
           trans = session.beginTransaction();
           TbJabatan jb = (TbJabatan) session.load(TbJabatan.class, new Integer(idJ));
           session.delete(jb);
           trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    
    }
    
    
    public void editJabatan(TbJabatan jb)
   {
       Transaction trans = null;
       Session session = HibernateUtil.getSessionFactory().openSession();
       
       try{
           trans = session.beginTransaction();
           session.update(jb);
           trans.commit();
       } catch (Exception e){
           System.out.println(e);
       }
   }
    
    
    public void resetJabatan(TbJabatan jb)
   {
       Transaction trans = null;
       Session session = HibernateUtil.getSessionFactory().openSession();
       
       try{
           trans = session.beginTransaction();
           session.clear();
           trans.commit();
       }catch(Exception e){
           System.out.println(e);
       }
   } 
    
    
    
}
