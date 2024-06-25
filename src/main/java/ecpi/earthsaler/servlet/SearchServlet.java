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

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private LandService landService;

    @Override
    public void init() throws ServletException {
        landService = new LandService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        double minPrice = Double.parseDouble(request.getParameter("minPrice"));
        double maxPrice = Double.parseDouble(request.getParameter("maxPrice"));
        double minArea = Double.parseDouble(request.getParameter("minArea"));
        double maxArea = Double.parseDouble(request.getParameter("maxArea"));

        List<Land> lands = landService.searchLands(city, district, minPrice, maxPrice, minArea, maxArea);

        request.setAttribute("lands", lands);
        request.getRequestDispatcher("/searchResults.jsp").forward(request, response);
    }
}
