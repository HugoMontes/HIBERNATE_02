package com.educomser.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
 
public class HibernateUtil {
 
    private static final SessionFactory sessionFactory = buildSessionFactory();
 
    // Hibernate 5:
    private static SessionFactory buildSessionFactory() {
        try {
            // Crear el ServiceRegistry desde hibernate.cfg.xml
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
 
            // Crear fuentes de metadatos utilizados en el registro de servicio.
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
 
            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {
         
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    public static void closeSessionFactory() {
        // Cerrar caches y grupo de conexiones
    	if (sessionFactory != null && !sessionFactory.isClosed()) {
    		getSessionFactory().close();
    	}        
    }
}