package com.aoher.main;

import com.aoher.model.Cart1;
import com.aoher.model.Items1;
import com.aoher.util.HibernateAnnotationUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class HibernateOneToManyAnnotationMain {

    private static Logger log = LoggerFactory.getLogger(HibernateOneToManyAnnotationMain.class);

    public static void main(String[] args) {
        Cart1 cart = new Cart1();
        cart.setName("MyCart1");

        Items1 item1 = new Items1("I10", 10, 1, cart);
        Items1 item2 = new Items1("I20", 20, 2, cart);

        Set<Items1> items1Set = new HashSet<>();
        items1Set.add(item1);
        items1Set.add(item2);

        cart.setItems1(items1Set);
        cart.setTotal(10 + 20*2);

        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            sessionFactory = HibernateAnnotationUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            log.info("Session created");
            tx = session.beginTransaction();
            session.save(cart);
            session.save(item1);
            session.save(item2);
            tx.commit();

            log.info(String.format("Cart1 ID=%s", cart.getId()));
            log.info(String.format("item1 ID=%s, Foreign Key Cart ID=%s", item1.getId(), item1.getCart1().getId()));
            log.info(String.format("item2 ID=%s, Foreign Key Cart ID=%s", item2.getId(), item1.getCart1().getId()));
        } catch (Exception e) {
            log.error(String.format("Exception occurred. %s", e.getMessage()));
        } finally {
            if (sessionFactory != null && !sessionFactory.isClosed()) {
                log.info("Closing SessionFactory");
                sessionFactory.close();
            }
        }
    }

}
