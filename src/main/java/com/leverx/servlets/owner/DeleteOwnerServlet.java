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

@WebServlet("/owner/delete")
public class DeleteOwnerServlet extends HttpServlet {

    OwnerService service = new OwnerService();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        PrintWriter writer = resp.getWriter();

        Long ownerId = Long.parseLong(id);
        service.deleteOwner(ownerId);

        writer.print("The owner was removed!");
    }
}
