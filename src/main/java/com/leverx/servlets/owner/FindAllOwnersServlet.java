package com.leverx.servlets.owner;

import com.leverx.model.Owner;
import com.leverx.services.OwnerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/owners")
public class FindAllOwnersServlet extends HttpServlet {

    OwnerService service = new OwnerService();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Owner> allOwners = service.findAllOwners();
        for (Owner owner : allOwners) {
            PrintWriter writer = resp.getWriter();
            writer.println(owner);
        }
    }
}
