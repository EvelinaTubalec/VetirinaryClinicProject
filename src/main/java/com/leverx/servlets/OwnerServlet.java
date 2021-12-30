package com.leverx.servlets;

import com.leverx.model.Owner;
import com.leverx.model.Role;
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
public class OwnerServlet extends HttpServlet {

    public static final String LAST_NAME = "lastName";
    public static final String OWNER_ID = "ownerId";
    public static final String FIRST_NAME = "firstName";

    private final OwnerService ownerService = new OwnerService();


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Owner> owners = ownerService.findOwners();
        for (Owner owner : owners) {
            PrintWriter writer = resp.getWriter();
            writer.println(owner);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String firstName = req.getParameter(FIRST_NAME);
        String lastName = req.getParameter(LAST_NAME);

        Owner owner = new Owner(firstName, lastName, Role.OWNER);
        ownerService.saveOwner(owner);
        PrintWriter writer = resp.getWriter();
        writer.print("The owner was created!");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter(OWNER_ID));
        Owner owner = ownerService.findOwner(id);
        owner.setFirstname(req.getParameter(FIRST_NAME));
        owner.setLastName(req.getParameter(LAST_NAME));
        ownerService.updateOwner(owner);
        PrintWriter writer = resp.getWriter();
        writer.print("The owner was updated!");
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter(OWNER_ID);
        PrintWriter writer = resp.getWriter();
        Long ownerId = Long.parseLong(id);
        ownerService.deleteOwner(ownerId);
        writer.print("The owner was removed!");
    }
}
