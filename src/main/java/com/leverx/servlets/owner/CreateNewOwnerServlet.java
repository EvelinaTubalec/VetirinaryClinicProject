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

@WebServlet("/owner/create")
public class CreateNewOwnerServlet extends HttpServlet {

    OwnerService service = new OwnerService();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        Owner owner = new Owner(firstName, lastName);
        service.saveOwner(owner);

        PrintWriter writer = resp.getWriter();
        writer.print("You create new owner!");
    }
}
