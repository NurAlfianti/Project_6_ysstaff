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
import pojo.TbProfil;
import util.HibernateUtil;
/**
 *
 * @author laila
 */
public class DAOProfil {
    
    public List<TbProfil> getBy(String unama, String uDiv, String uKlmn, String uTglahir, String uTgmasuk, String uTgkeluar, String uHp, String uAlamat) {
        Transaction trans = null;
        TbProfil pr = new TbProfil();
        List<TbProfil> profil = new ArrayList();

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TbProfil where nama=:unama AND staffDivisi=:uDiv AND jenisKelamin=:uKlmn AND tanggalLahir=:uTglahir AND tanggalMasuk=:uTgmasuk AND tanggalKeluar=:uTgkeluar AND noHp=:uHp AND alamat=:uAlamat");
            query.setString("unama", unama);
            query.setString("uDiv", uDiv);
            query.setString("uKlmn", uKlmn);
            query.setString("uTglahir", uTglahir);
            query.setString("uTgmasuk", uTgmasuk);
            query.setString("uTgkeluar", uTgkeluar);
            query.setString("uHp", uHp);
            query.setString("uAlamat", uAlamat);
            pr = (TbProfil) query.uniqueResult();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return profil;
    }
    
    
    public void add_profil(TbProfil profil) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(profil);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    public List<TbProfil> retreveTbProfil() {
        List pro = new ArrayList();
        TbProfil pro1 = new TbProfil();
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TbProfil");
            pro = query.list();
            pro.add(pro1.getStaffId());
            pro.add(pro1.getNama());
            pro.add(pro1.getStaffDivisi());
            pro.add(pro1.getJenisKelamin());
            pro.add(pro1.getTanggalLahir());
            pro.add(pro1.getTanggalMasuk());
            pro.add(pro1.getTanggalKeluar());
            pro.add(pro1.getNoHp());
            pro.add(pro1.getAlamat());
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return pro;
    }
    
    
    public List<TbProfil> getbyID(String idP) {
        TbProfil pro = new TbProfil();
        List<TbProfil> iPro = new ArrayList();

        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TbProfil where staffId= :id");
            query.setString("id", idP);
            pro = (TbProfil) query.uniqueResult();
            iPro = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return iPro;
    }
    
    
    public void deleteProfil(Integer idP) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            trans = session.beginTransaction();
            TbProfil pro = (TbProfil) session.load(TbProfil.class, new Integer(idP));
            session.delete(pro);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    public void editProfil(TbProfil pro) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            trans = session.beginTransaction();
            session.update(pro);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void resetProfil(TbProfil pro) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            trans = session.beginTransaction();
            session.clear();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
