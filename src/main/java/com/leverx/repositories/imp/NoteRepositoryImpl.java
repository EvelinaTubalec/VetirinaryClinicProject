package com.leverx.repositories.imp;

import com.leverx.model.Note;
import com.leverx.repositories.NoteRepository;
import com.leverx.utills.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class NoteRepositoryImpl implements NoteRepository {
    @Override
    public Note findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Note note = session.get(Note.class, id);
        session.close();
        return note;
    }

    @Override
    public List<Note> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Note> notes = session.createQuery("from Note").getResultList();
        session.close();
        return notes;
    }

    @Override
    public void create(Note entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Note entity) {
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
        Note byId = findById(id);
        session.delete(byId);
        transaction.commit();
        session.close();
    }
}
