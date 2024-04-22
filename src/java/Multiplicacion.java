
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * http://localhost:8080/EjemploGF/app/Multiplicacion?n1=9&n2=10 --> Para consumirlo.
 * @author faranzabe
 */
@Path("Multiplicacion")
public class Multiplicacion {
    @GET
    public String operar(@QueryParam("n1") int nu1, @QueryParam("n2") int nu2){
        return String.valueOf(nu2 * nu1);
    }
}
