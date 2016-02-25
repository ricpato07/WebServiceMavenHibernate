package com.servlet.service;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.webservice.persistence.CatBancos;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "Update", urlPatterns = {"/update"})
public class Update extends HttpServlet {

    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8085/WebServiceHibernate/resources";

    public Update() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("bancos");
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        update(2);
        response.sendRedirect("update.jsp");
    }

    public void update(int id) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        String sjson = resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        Gson gson = new Gson();
        CatBancos banco = gson.fromJson(sjson, CatBancos.class);
       
        System.out.println("response status");
        System.out.println(response.getStatus());
        System.out.println("sjson");
        System.out.println(sjson);
         System.out.println("banco");
        System.out.println(banco.getSbanco());
        
        banco.setSbanco("banorte");
        String jsonbanco = gson.toJson(banco);
        
         ClientResponse responseupdate = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, jsonbanco);
        System.out.println("responseupdate");
        System.out.println(responseupdate);

    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


}
