package demo;

import domain.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CriteriaDemo1 {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg= new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Product.class);
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        //create Criteria to display first record
        Criteria crt = ses.createCriteria(Product.class);
        crt.setMaxResults(1);
        List<Product>data = crt.list();
        for (Product p:data)
        {
            System.out.println(p);
        }
        System.out.println("=================================");
        Criteria crt1 = ses.createCriteria(Product.class);
        crt1.setMaxResults(1);
        List<Product> data1 = crt1.list();
        for (Product p:data1)
        {
            System.out.println(p);
        }

    }
}
