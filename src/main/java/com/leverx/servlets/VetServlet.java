package com.leverx.servlets;

import com.leverx.model.Role;
import com.leverx.model.Vet;
import com.leverx.services.VetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/vets")
public class VetServlet extends HttpServlet {

    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String POSITION = "position";
    public static final String VET_ID = "vetId";

    private final VetService vetService = new VetService();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Vet> vets = vetService.findAllVets();
        for (Vet vet : vets) {
            PrintWriter writer = resp.getWriter();
            writer.println(vet);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String firstName = req.getParameter(FIRST_NAME);
        String lastName = req.getParameter(LAST_NAME);
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        String position = req.getParameter(POSITION);
        Vet vet = new Vet(firstName, lastName, login, password, position, Role.VET);
        vetService.saveVet(vet);
        PrintWriter writer = resp.getWriter();
        writer.print("The vet was created!");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long vetId = Long.parseLong(req.getParameter(VET_ID));
        Vet vet = vetService.findVet(vetId);
        vet.setFirstName(req.getParameter(FIRST_NAME));
        vet.setLastName(req.getParameter(LAST_NAME));
        vet.setPosition(req.getParameter(POSITION));
        vetService.updateVet(vet);
        PrintWriter writer = resp.getWriter();
        writer.print("The vet was updated!");
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter(VET_ID);
        PrintWriter writer = resp.getWriter();
        Long vetId = Long.parseLong(id);
        vetService.deleteVet(vetId);
        writer.print("The vet was removed!");
    }
}
