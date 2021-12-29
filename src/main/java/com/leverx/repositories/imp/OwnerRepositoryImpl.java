package com.leverx.repositories.imp;

import com.leverx.utills.HibernateUtil;
import com.leverx.model.Owner;
import com.leverx.repositories.OwnerRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OwnerRepositoryImpl implements OwnerRepository {
    @Override
    public Owner findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Owner owner = session.get(Owner.class, id);
        session.close();
        return owner;
    }

    @Override
    public List<Owner> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Owner> allOwners = session.createQuery("from Owner").getResultList();
        session.close();
        return allOwners;
    }

    @Override
    public void create(Owner entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Owner entity) {
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
        Owner byId = findById(id);
        session.delete(byId);
        transaction.commit();
        session.close();
    }
}
