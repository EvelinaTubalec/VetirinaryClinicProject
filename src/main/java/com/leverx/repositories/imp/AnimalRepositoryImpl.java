package com.leverx.repositories.imp;

import com.leverx.model.Animal;
import com.leverx.repositories.AnimalRepository;
import com.leverx.utills.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AnimalRepositoryImpl implements AnimalRepository {

    @Override
    public Animal findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Animal animal = session.get(Animal.class, id);
        session.close();
        return animal;
    }

    @Override
    public List<Animal> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Animal> allAnimals = session.createQuery("from Animal").getResultList();
        session.close();
        return allAnimals;
    }

    @Override
    public void create(Animal entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Animal entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Animal byId = findById(id);
        session.delete(byId);
        transaction.commit();
        session.close();
    }
}
