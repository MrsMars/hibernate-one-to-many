package com.aoher.main;

import com.aoher.model.Cart;
import com.aoher.model.Items;
import com.aoher.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class HibernateOneToManyMain {

    private static Logger log = LoggerFactory.getLogger(HibernateOneToManyMain.class);

    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.setName("MyCart");

        Items item1 = new Items("I1", 10, 1, cart);
        Items item2 = new Items("I2", 20, 2, cart);
        Set<Items> itemsSet = new HashSet<>();
        itemsSet.add(item1);
        itemsSet.add(item2);

        cart.setItems(itemsSet);
        cart.setTotal(10 + 20 * 2);

        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;

        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            log.info("Session created");
            tx = session.beginTransaction();
            session.save(cart);
            session.save(item1);
            session.save(item2);

            tx.commit();
            log.info(String.format("Cart ID=%s", cart.getId()));
        } catch (Exception e) {
            log.error(String.format("Exception occured. %s", e.getMessage()));
        } finally {
            if (sessionFactory != null && !sessionFactory.isClosed()) {
                log.info("Closing SessionFactory");
                sessionFactory.close();
            }
        }
    }
}
