package service;

import model.FeedBack;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
@Transactional
public class FeedBackServiceIMPL implements IFeedBackService{

    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

//    static {
//        try{
//            sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
//            entityManager = sessionFactory.createEntityManager();
//        }catch (HibernateException e){
//            e.printStackTrace();
//        }
//    }

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
            System.out.println("Test session");
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }


    @Override
    public List<FeedBack> findAll() {
        String queryStr = "SELECT c FROM FeedBack AS c";
        TypedQuery<FeedBack> query = entityManager.createQuery(queryStr, FeedBack.class);
        return query.getResultList();
    }

}
