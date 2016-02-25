package com.webservice.dao;

import com.webservice.persistence.CatBancos;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface CatBancosDAO {

    public void save(CatBancos cat)throws Exception;

    public void update(CatBancos cat)throws Exception;

    public void delete(CatBancos cat)throws Exception;

    public CatBancos get(CatBancos cat)throws Exception;

    public List<CatBancos> list(CatBancos cat)throws Exception;
}
