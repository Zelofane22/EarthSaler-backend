package landseller.resource;

import landseller.model.Land;
import landseller.service.LandService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/search")
public class SearchResource {
    private final LandService landService;

    public SearchResource() {
        this.landService = new LandService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLands(
            @QueryParam("city") String city,
            @QueryParam("district") String district,
            @QueryParam("minPrice") Double minPrice,
            @QueryParam("maxPrice") Double maxPrice,
            @QueryParam("minArea") Double minArea,
            @QueryParam("maxArea") Double maxArea) {

        List<Land> lands = landService.searchAdvanced(city, district, minPrice, maxPrice, minArea, maxArea);
        return Response.ok(lands).build();
    }

    @GET
    @Path("/price")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLandsByPrice(
            @QueryParam("minPrice") double minPrice,
            @QueryParam("maxPrice") double maxPrice) {

        List<Land> lands = landService.searchByPrice(minPrice, maxPrice);
        return Response.ok(lands).build();
    }

    @GET
    @Path("/area")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLandsByArea(
            @QueryParam("minArea") double minArea,
            @QueryParam("maxArea") double maxArea) {

        List<Land> lands = landService.searchByArea(minArea, maxArea);
        return Response.ok(lands).build();
    }

    @GET
    @Path("/location")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLandsByLocation(
            @QueryParam("city") String city,
            @QueryParam("district") String district) {

        List<Land> lands = landService.searchByLocation(city, district);
        return Response.ok(lands).build();
    }
}