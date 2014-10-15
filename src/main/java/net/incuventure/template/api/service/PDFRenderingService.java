package net.incuventure.template.api.service;

import org.springframework.stereotype.Component;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jett on 10/2/14.
 */
@Path("/report")
@Component
public class PDFRenderingService {

    @POST
//    @Produces(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/render")
    public Response testEvent(@Context UriInfo allUri, String postBody) {

//        Gson gson = new Gson();

        String result = "";
        Map returnMap = new HashMap();

        try {

            System.out.println(postBody);
            //returnMap.put("status", "ok");


            ITextRenderer renderer = new ITextRenderer();

            renderer.setDocumentFromString(postBody);
            renderer.layout();

            final ByteArrayOutputStream inmemPDF = new ByteArrayOutputStream();
            renderer.createPDF(inmemPDF);

            // from http://stackoverflow.com/questions/8147956/return-file-from-resteasy-server
            StreamingOutput stream = new StreamingOutput() {

                public void write(OutputStream output) throws IOException, WebApplicationException {
                    try {
                        output.write(inmemPDF.toByteArray());
                    }
                    catch (Exception e) {
                        throw new WebApplicationException(e);
                    }
                }
            };

            return Response.ok(stream, MediaType.APPLICATION_OCTET_STREAM).header("content-disposition", "attachment; filename=\"temp.pdf\"").build();

        } catch (Exception e) {

            Map errorDetails = new HashMap();

            e.printStackTrace();

            errorDetails.put("code", e.getMessage());
            errorDetails.put("description", e.toString());

            returnMap.put("status", "error");
            returnMap.put("error", errorDetails);

            return Response.status(400).entity("bad request").build();
        }

        // format return data as json
//        result = gson.toJson(returnMap);

        // todo: we should probably return the appropriate HTTP error codes instead of always returning 200
//        return Response.status(200).entity(result).build();
    }
}
