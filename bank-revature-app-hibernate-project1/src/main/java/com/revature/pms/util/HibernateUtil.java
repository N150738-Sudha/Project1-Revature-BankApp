package com.revature.pms.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	public static SessionFactory getSessionFactory() {
		AnnotationConfiguration configuration = new AnnotationConfiguration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		return sessionFactory;
	}
}
