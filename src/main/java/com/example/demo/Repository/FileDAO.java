package com.example.demo.Repository;

import org.apache.tomcat.jni.File;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.HibernateException;
import java.util.List;

/**
 * Created by Cloie Andrea on 22/07/2018.
 */
public class FileDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save(File document) {
        Session session = sessionFactory.getCurrentSession();
        session.save(document);
    }

    @Transactional
    public List<File> list() {
        Session session = sessionFactory.getCurrentSession();
        List<File> documents = null;
        try {
            documents = (List<File>) session.createQuery("from File").list();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return documents;
    }

    @Transactional
    public File get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return (File) session.get(File.class, id);
    }

    @Transactional
    public void remove(Integer id) {
        Session session = sessionFactory.getCurrentSession();

        File document = (File) session.get(File.class, id);

        session.delete(document);
    }
}
