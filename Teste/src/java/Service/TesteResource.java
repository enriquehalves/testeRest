/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import com.google.gson.Gson;
import dao.Conexao;
import dao.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import modelo.Usuario;

/**
 * REST Web Service
 *
 * @author enriq
 */
@Path("teste")
public class TesteResource {

    @Context
    private UriInfo context;

 
    public TesteResource() {
    }

    @GET
    @Produces("application/json")
    @Path("usuario/get/{login}")
    //@Path("usuario/get/{login}/{senha}")
    //public String getJson(@PathParam("login") String login, @PathParam("senha") String senha)
    public String getJson(@PathParam("login") String login) {
     
        Usuario u = new Usuario();
        u.setLogin(login);
        UsuarioDAO dao = new UsuarioDAO();
        u=dao.buscar(u);
        Gson g = new Gson();
        return g.toJson(u);
                
    }
    
    @GET
    @Produces("application/json")
    @Path("usuario/lista")
    public String getJson() {
        List<Usuario> lista;
        UsuarioDAO dao = new UsuarioDAO();
        Gson g = new Gson();
        lista = dao.listar();
        return g.toJson(lista);
    }

   
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
