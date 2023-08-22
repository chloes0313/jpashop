package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager ();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //비영속
            //비영속
            Member memberA = new Member();

            Order order = new Order();
            // order.addOrderItem(new OrderItem());
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            System.out.println("============================");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
