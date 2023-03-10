package pojo;
// Generated Oct 17, 2022 1:26:04 PM by Hibernate Tools 4.3.1

import dao.DAOProfil;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 * TbProfil generated by hbm2java
 */
@ManagedBean
public class TbProfil  implements java.io.Serializable {


     private Integer staffId;
     private String nama;
     private String staffDivisi;
     private String jenisKelamin;
     private String tanggalLahir;
     private String tanggalMasuk;
     private String tanggalKeluar;
     private String noHp;
     private String alamat;
     
     
     public void save_profil()
     {
         DAOProfil addd = new DAOProfil();
         addd.add_profil(this);
     }
     
     public List<TbProfil> getAllRecordss()
    {
        DAOProfil pro = new DAOProfil();
        List<TbProfil> lPro = pro.retreveTbProfil();
        return lPro;
    }
     
     public String getByIdpro()
    {
        String staff_id = staffId.toString();
        DAOProfil pro = new DAOProfil();
        List<TbProfil> lPro = pro.getbyID(staff_id);
        nama = lPro.get(0).getNama();
        staffDivisi = lPro.get(0).getStaffDivisi();
        jenisKelamin = lPro.get(0).getJenisKelamin();
        tanggalLahir = lPro.get(0).getTanggalLahir();
        tanggalMasuk = lPro.get(0).getTanggalMasuk();
        tanggalKeluar = lPro.get(0).getTanggalKeluar();
        noHp = lPro.get(0).getNoHp();
        alamat = lPro.get(0).getAlamat();
        return"profil";
    }
     
     public String editt(){
        DAOProfil pro = new DAOProfil();
        pro.editProfil(this);
        nama = "";
        staffDivisi = "";
        jenisKelamin = "";
        tanggalLahir = "";
        tanggalMasuk = "";
        tanggalKeluar = "";
        noHp = "";
        alamat = "";
        return "profil";
    }
     
     
     public String deletee(){
        DAOProfil pro = new DAOProfil();
        pro.deleteProfil(staffId);
        nama = "";
        staffDivisi = "";
        jenisKelamin = "";
        tanggalLahir = "";
        tanggalMasuk = "";
        tanggalKeluar = "";
        noHp = "";
        alamat = "";
        return "profil";
    }
     
     
     public String resetee(){
        DAOProfil cus = new DAOProfil();
        cus.resetProfil(this);
        nama = "";
        staffDivisi = "";
        jenisKelamin = "";
        tanggalLahir = "";
        tanggalMasuk = "";
        tanggalKeluar = "";
        noHp = "";
        alamat = "";
        return "profil";
    } 
     
     
     
     
     
     
     
     
     

    public TbProfil() {
    }

    public TbProfil(String nama, String staffDivisi, String jenisKelamin, String tanggalLahir, String tanggalMasuk, String tanggalKeluar, String noHp, String alamat) {
       this.nama = nama;
       this.staffDivisi = staffDivisi;
       this.jenisKelamin = jenisKelamin;
       this.tanggalLahir = tanggalLahir;
       this.tanggalMasuk = tanggalMasuk;
       this.tanggalKeluar = tanggalKeluar;
       this.noHp = noHp;
       this.alamat = alamat;
    }
   
    public Integer getStaffId() {
        return this.staffId;
    }
    
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }
    public String getNama() {
        return this.nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getStaffDivisi() {
        return this.staffDivisi;
    }
    
    public void setStaffDivisi(String staffDivisi) {
        this.staffDivisi = staffDivisi;
    }
    public String getJenisKelamin() {
        return this.jenisKelamin;
    }
    
    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
    public String getTanggalLahir() {
        return this.tanggalLahir;
    }
    
    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }
    public String getTanggalMasuk() {
        return this.tanggalMasuk;
    }
    
    public void setTanggalMasuk(String tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }
    public String getTanggalKeluar() {
        return this.tanggalKeluar;
    }
    
    public void setTanggalKeluar(String tanggalKeluar) {
        this.tanggalKeluar = tanggalKeluar;
    }
    public String getNoHp() {
        return this.noHp;
    }
    
    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
    public String getAlamat() {
        return this.alamat;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }




}


