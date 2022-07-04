import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class OrganizationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HashMap<Long, Organization> organizations = OrganizationRepository.getInstance().getAll();
        response.setContentType("application/json");
        response.getWriter().write(new Gson().toJson(organizations));
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Organization organization = new Gson().fromJson(request.getReader(), Organization.class);
        long id = OrganizationRepository.getInstance().create(organization);

        response.setContentType("application/json");
        response.getWriter().write(new Gson().toJson(organization));
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            long id = Long.parseLong(request.getPathInfo().split("/")[1]);
            OrganizationRepository.getInstance().delete(id);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            response.setStatus(400);
        }
    }
}
