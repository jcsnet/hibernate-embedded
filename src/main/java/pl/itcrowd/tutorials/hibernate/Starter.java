package pl.itcrowd.tutorials.hibernate;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Startup
@Singleton
public class Starter {

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void postConstruct()
    {

    }
}
