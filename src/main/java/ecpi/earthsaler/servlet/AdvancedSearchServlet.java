package ecpi.earthsaler.servlet;

import ecpi.earthsaler.model.Land;
import ecpi.earthsaler.service.LandService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/advancedSearch")
public class AdvancedSearchServlet extends HttpServlet {
    private LandService landService;

    @Override
    public void init() throws ServletException {
        landService = new LandService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        Double minPrice = request.getParameter("minPrice") != null ? Double.parseDouble(request.getParameter("minPrice")) : null;
        Double maxPrice = request.getParameter("maxPrice") != null ? Double.parseDouble(request.getParameter("maxPrice")) : null;
        Double minArea = request.getParameter("minArea") != null ? Double.parseDouble(request.getParameter("minArea")) : null;
        Double maxArea = request.getParameter("maxArea") != null ? Double.parseDouble(request.getParameter("maxArea")) : null;

        List<Land> lands = landService.searchAdvanced(city, district, minPrice, maxPrice, minArea, maxArea);

        request.setAttribute("lands", lands);
        request.getRequestDispatcher("/advancedSearchResults.jsp").forward(request, response);
    }
}

