package com.leverx.repositories.imp;

import com.leverx.model.Vet;
import com.leverx.repositories.VetRepository;
import com.leverx.utills.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class VetRepositoryImpl implements VetRepository {
    @Override
    public Vet findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Vet vet = session.get(Vet.class, id);
        session.close();
        return vet;
    }

    @Override
    public List<Vet> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Vet> allVets = session.createQuery("from Vet").getResultList();
        session.close();
        return allVets;
    }

    @Override
    public void create(Vet entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Vet entity) {
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
        Vet byId = findById(id);
        session.delete(byId);
        transaction.commit();
        session.close();
    }
}