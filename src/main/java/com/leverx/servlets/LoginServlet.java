package com.leverx.servlets;

import com.leverx.model.Vet;
import com.leverx.services.VetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";

    private final VetService vetService = new VetService();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);

        PrintWriter writer = resp.getWriter();
        Vet vetByLogin = null;
        try {
            vetByLogin = vetService.findVetByLogin(login);
        } catch(Exception e){
            writer.println("Incorrect login!");
        }

        String vetPassword = vetByLogin.getPassword();
        if (password.equals(vetPassword)){
            writer.println("You was successfully authenticated!");
        }else{
            writer.println("Incorrect password!");
        }
    }
}
