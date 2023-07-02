package demo;

import domain.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteProduct {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Product.class);
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();

        Query q = ses.createQuery("delete from Product p where p.productPrice<="+25000.25+" ");
        tx= ses.beginTransaction();
        int count = q.executeUpdate();
        tx.commit();
        System.out.println(count+" Record Deleted Successfully");
    }
}
