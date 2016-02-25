package com.webservice.service;

import com.google.gson.Gson;
import com.webservice.dao.CatBancosDAO;
import com.webservice.dao.CatBancosDAOImp;
import com.webservice.persistence.CatBancos;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author USUARIO
 */
@Path("bancos")
public class BancosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BancosResource
     */
    public BancosResource() {
    }

    /**
     * Regresa todos los bancos o busca por el nombre colocado
     *
     * @param nombre texto del banco a buscar
     * @return una lista con los bancos encontrados
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAll(@QueryParam("nombre") String nombre) {
        try {
            System.out.println("nombre: " + nombre);
            CatBancosDAO bancosDAO = new CatBancosDAOImp();
            CatBancos banco = new CatBancos();
            banco.setSbanco(nombre);
            return new Gson().toJson(bancosDAO.list(banco));
        } catch (Exception e) {
            System.err.println("Ocurrió un error en el WebService: " + e.getMessage());
        }
        return null;
    }

    /**
     * Regresa el banco de acuerdo al id colocado
     *
     * @param id identificador del banco a buscar
     * @return un objeto de tipo banco
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getOne(@PathParam("id") int id) {
        try {
            CatBancosDAO bancosDAO = new CatBancosDAOImp();
            CatBancos banco = new CatBancos();
            banco.setIdBanco(id);
            return new Gson().toJson(bancosDAO.get(banco));
        } catch (Exception e) {
            System.err.println("Ocurrió un error en el WebService: " + e.getMessage());
        }
        return null;
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String set(@FormParam("sbanco") String sbanco) {
        try {
            CatBancosDAO bancosDAO = new CatBancosDAOImp();
            CatBancos banco = new CatBancos();
            banco.setSbanco(sbanco);
            bancosDAO.save(banco);
            return new Gson().toJson("Se guardó el banco correctamente");
        } catch (Exception e) {
            System.err.println("Ocurrió un error en el WebService: " + e.getMessage());
        }
        return null;
    }

    @PUT
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
    public String update(@PathParam("id") int id,String jsonObject) {
        System.out.println("UPDATE");
        try {
            Gson gson = new Gson();
            System.out.println("jsonObject:");
            System.out.println(jsonObject);
            System.out.println("id:");
            System.out.println(id);
            CatBancos jsonBanco = gson.fromJson(jsonObject, CatBancos.class);
            System.out.println("jsonBanco:");
            System.out.println(jsonBanco.getSbanco());        
            
            CatBancosDAO bancosDAO = new CatBancosDAOImp();
            bancosDAO.update(jsonBanco);
            return new Gson().toJson("Se actualizó el banco correctamente");
        } catch (Exception e) {
            System.err.println("Ocurrió un error en el WebService: " + e.getMessage());
        }
        return null;
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String delete(@PathParam("id") int id) {
        System.out.println("UPDATE");
        try {
            CatBancosDAO bancosDAO = new CatBancosDAOImp();
            CatBancos banco = new CatBancos();
            banco.setIdBanco(id);
            bancosDAO.delete(banco);
            return new Gson().toJson("El banco se eliminó correctamente");
        } catch (Exception e) {
            System.err.println("Ocurrió un error en el WebService: " + e.getMessage());
        }
        return null;
    }
}
