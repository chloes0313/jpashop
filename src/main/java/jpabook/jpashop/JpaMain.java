package jpabook.jpashop;

import com.sun.org.apache.xpath.internal.operations.Or;
import jpabook.jpashop.domain.*;

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
//            Book newBook = new Book();
//            newBook.setName("책이다");
//            newBook.setAuthor("Unkwown");
//
//            em.persist(newBook);

            Member member = new Member();
            member.setName("chloe");


            Order order = new Order();
            order.setMember(member);
            order.setStatus(OrderStatus.ORDER);

            Delivery delivery = new Delivery();
            delivery.setStatus(DeliveryStatus.PENDING);
            //persist X

            Book book1 = new Book();
            book1.setName("Pachinko");
            book1.setAuthor("이민진");
            book1.setPrice(12000);
            em.persist(book1);

            Album album1 = new Album();
            album1.setArtist("ZEROBASEONE");
            album1.setName("1st Mini Album - YOUTH IN THE SHADE");
            album1.setPrice(19800);
            em.persist(album1);

            OrderItem orderItem1 = new OrderItem();
            orderItem1.setItem(book1);
            orderItem1.setCount(1);
            orderItem1.setOrderPrice(12000);
            OrderItem orderItem2 = new OrderItem();
            orderItem2.setItem(album1);
            orderItem2.setCount(2);
            orderItem2.setOrderPrice(39600);
//
            order.setDelivery(delivery);
            order.addOrderItem(orderItem1);
            order.addOrderItem(orderItem2);

            em.persist(member);
            em.persist(order);

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
