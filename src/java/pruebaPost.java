
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author faranzabe
 */
@Path("/pruebaPost/")
public class pruebaPost {

    /*
    A continuación dos proyectos servicios web diferentes. Hacen lo mismo pero al cliente le devuelven diferente tipo de respuesta.
    Aceptan un String en el que se le envían datos en formato JSON. Una vez convertidos en objetos su tratamiento es el que queramos: insertar
    en una lista, en una BD... lo que queramos.
    Después cada método devuelve cosas diferentes al cliente:
    post --> un texto usando Response.
    post2 --> un string estándar de Java.
    post3 --> un json.
    post4 --> colección de json.
    */
    
    //Este servicio se consume con el proyecto ClientePost.
    @POST
    @Path("/post")
    @Consumes("application/json")
    //@Consumes(MediaType.APPLICATION_JSON)
    //@Consumes("*/*")
    public Response crearDato(String stream) throws IOException {
        Gson gson = new Gson();
        Datos dato = gson.fromJson(stream, Datos.class);
        String result = "Elemento creado en el servidor: " + dato;
        return Response.ok(result).build();

    }
    
       
    //Este servicio se consume con el proyecto MiclientePost.
    @POST
    @Path("/post2")
    @Consumes("application/json")
    //@Consumes(MediaType.APPLICATION_JSON)
    public String crearDatoS(String stream) throws IOException {
        Gson gson = new Gson();
        Datos dato = gson.fromJson(stream, Datos.class);
        String result = "Elemento creado en el servidor de servicios WEB: " + dato;
        return result;

    }
    
    //Este servicio se consume con el proyecto MiclientePost.
    @POST
    @Path("/post3")
    @Consumes("application/json")
    //@Consumes(MediaType.APPLICATION_JSON)
    public String crearDatoJSON(String stream) throws IOException {
        Gson gson = new Gson();
        Datos dato = gson.fromJson(stream, Datos.class);
        String jsonObj = "";
        jsonObj = gson.toJson(dato);
        return jsonObj;

    }
    
        //Este servicio se consume con el proyecto MiclientePost.
    @POST
    @Path("/post4")
    @Consumes("application/json")
    //@Consumes(MediaType.APPLICATION_JSON)
    public String crearDatoJSONColeccion(String stream) throws IOException {
        List<Datos> result = new LinkedList<>();
        result.add(new Datos(1, "uno"));
        result.add(new Datos(2, "dos"));
        result.add(new Datos(3, "tres"));
        result.add(new Datos(4, "cuatro"));

        Gson gson = new Gson();
        String json = new Gson().toJson(result);
        return json;

    }
}
