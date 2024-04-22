
import com.google.gson.Gson;
import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/*
 * En este ejemplo se servirán (en formato JSON) los datos que se almacenan en la lista List<Datos>. El obtener los datos de una BD
 * es tan sencillo como acceder a los datos como hemos hecho siempre y convertirlos en JSON usando Gson.
 */
/**
 * 
 * @author faranzabe
 */
@Path("/ServicioDatos/")
public class ServicioDatos {

    public List<Datos> rellenarDatos() {
        List<Datos> result = new LinkedList<>();
        result.add(new Datos(1, "uno"));
        result.add(new Datos(2, "dos"));
        result.add(new Datos(3, "tres"));
        result.add(new Datos(4, "cuatro"));
        return result;
    }

    //Ejemplo de consumo: http://localhost:8080/EjemploGF/app/ServicioDatos --> Devolverá toda la lista.
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getData() {
        List<Datos> result = rellenarDatos();
        Gson gson = new Gson();
        String jsonList = gson.toJson(result);
        return jsonList;
    }

    //Ejemplo de consumo: http://localhost:8080/EjemploGF/app/ServicioDatos/2   --> Busca el elemento 2.
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}")
    public String getData(@PathParam("id") int id) {
        List<Datos> result = rellenarDatos();
        Gson gson = new Gson();
        String jsonObj = "";
        for (Datos ob : result) {
            if (ob.getNum() == id) {
                jsonObj = gson.toJson(ob);
            }
        }
        if (jsonObj.isEmpty()) {
            jsonObj = gson.toJson("No encontrado");
        }
        return jsonObj;
    }
    
//    Ejemplo de consumo: http://localhost:8080/EjemploGF/app/ServicioDatos/otro?id=3 -- Busca el elemento 3.
    @GET
    @Path("/otro")
    @Produces({MediaType.APPLICATION_JSON})
    public String getData2(@QueryParam("id") int id) {
        List<Datos> result = rellenarDatos();
        Gson gson = new Gson();
        String jsonObj = "";
        for (Datos ob : result) {
            if (ob.getNum() == id) {

                jsonObj = gson.toJson(ob);
            }
        }
        if (jsonObj.isEmpty()) {
            jsonObj = gson.toJson("No encontrado");
        }
        return jsonObj;
    }
}
