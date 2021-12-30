package com.leverx.servlets;

import com.leverx.model.Animal;
import com.leverx.model.Owner;
import com.leverx.services.AnimalService;
import com.leverx.services.OwnerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/animals")
public class AnimalServlet extends HttpServlet {

    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final String OWNER_ID = "ownerId";
    public static final String ID = "animalId";

    private final AnimalService animalService = new AnimalService();
    private final OwnerService ownerService = new OwnerService();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Animal> animals = animalService.findAllAnimals();
        for (Animal animal : animals) {
            PrintWriter writer = resp.getWriter();
            writer.println(animal);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter(NAME);
        String stringAge = req.getParameter(AGE);
        String stringOwnerId = req.getParameter(OWNER_ID);

        Integer age = Integer.parseInt(stringAge);
        Long ownerId = Long.parseLong(stringOwnerId);

        Owner owner = ownerService.findOwner(ownerId);
        Animal animal = new Animal(name, age, owner);
        animalService.saveAnimal(animal);
        PrintWriter writer = resp.getWriter();
        writer.print("The animal was created!");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter(ID));
        Animal animal = animalService.findAnimal(id);
        animal.setName(req.getParameter(NAME));

        String stringAge = req.getParameter(AGE);
        Integer age = Integer.parseInt(stringAge);
        animal.setAge(age);
        animalService.updateAnimal(animal);
        PrintWriter writer = resp.getWriter();
        writer.print("The animal was updated!");
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter(ID);
        PrintWriter writer = resp.getWriter();
        Long animalId = Long.parseLong(id);
        animalService.deleteAnimal(animalId);
        writer.print("The animal was removed!");
    }
}
