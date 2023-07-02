package demo;

import domain.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.Iterator;
import java.util.List;

public class criteriaDemo {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg= new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Product.class);
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        //fetching complete Object
        //create criteria
        Criteria crt = ses.createCriteria(Product.class);
        //execute criteria
        List<Product> productList = crt.list();
        //process data
        for(Product p : productList)
        {
            System.out.println(p);
        }
        System.out.println("=============================================");

        //fetching data from specific column

        Criteria crt1 = ses.createCriteria(Product.class);
        crt1.setProjection(Projections.property("productName"));
        List<String> name = crt1.list();
        for (String s : name)
        {
            System.out.println(s);
        }
        System.out.println("=============================================");

        //fetching data from two or more columns
        //display product name and price
        Criteria crt2 = ses.createCriteria(Product.class);
//        crt2.add(Restrictions.eq("productName", "Mobile"));
//        crt2.add(Restrictions.eq("productPrice", "25000.25"));
        ProjectionList p1 = Projections.projectionList();
        p1.add(Projections.property("productName"));
        p1.add(Projections.property("productPrice"));
        crt2.setProjection(p1);
        List data = crt2.list();
        Iterator itr = data.iterator();
        while (itr.hasNext())
        {
            Object[] arr = (Object[]) itr.next();
            System.out.println(arr[0]+"\t"+arr[1]);
        }
    }
}
