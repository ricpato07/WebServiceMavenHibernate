package com.webservice.persistence;
// Generated 24-feb-2016 14:17:18 by Hibernate Tools 3.6.0



/**
 * CatBancos generated by hbm2java
 */
public class CatBancos  implements java.io.Serializable {


     private Integer idBanco;
     private String sbanco;

    public CatBancos() {
    }

    public CatBancos(String sbanco) {
       this.sbanco = sbanco;
    }
   
    public Integer getIdBanco() {
        return this.idBanco;
    }
    
    public void setIdBanco(Integer idBanco) {
        this.idBanco = idBanco;
    }
    public String getSbanco() {
        return this.sbanco;
    }
    
    public void setSbanco(String sbanco) {
        this.sbanco = sbanco;
    }




}


