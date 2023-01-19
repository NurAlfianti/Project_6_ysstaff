package pojo;
// Generated Oct 17, 2022 1:26:04 PM by Hibernate Tools 4.3.1

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




/**
 * TbAdmin generated by hbm2java
 */

@ManagedBean (name = "loginAdminBean")
@SessionScoped
public class TbAdmin  implements java.io.Serializable {


     private Integer adminId;
     private String adminNama;
     private String adminPass;

    public TbAdmin() {
    }

    public TbAdmin(String adminNama, String adminPass) {
       this.adminNama = adminNama;
       this.adminPass = adminPass;
    }
   
    public Integer getAdminId() {
        return this.adminId;
    }
    
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
    public String getAdminNama() {
        return this.adminNama;
    }
    
    public void setAdminNama(String adminNama) {
        this.adminNama = adminNama;
    }
    public String getAdminPass() {
        return this.adminPass;
    }
    
    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    
    
    public boolean checkadmin() {
        
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            Query query = session.createQuery("from TbAdmin where admin_nama=:admin_nama and admin_pass=:admin_pass");
            query.setString("admin_nama", adminNama);
            query.setString("admin_pass", adminPass);
            
            List list = query.list();
            
            if(list.size()==1) {
                return true;
            } else {
                return false;
            }            
        } catch(Exception e) {
            System.out.println(e);
        }
            return false;
    }


}


