package com.infotech.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateUtil {
	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;
	
	static {
		//Creating StandardServiceRegistryBuilder
		StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
		
		//Hibernate setting is equivalent to hibernate.cfg.xml properties
		Map<String, String> dbSetting = new HashMap<>();
		
		dbSetting.put(Environment.URL, "jdbc:mysql://localhost:3306/ecommerce");
		dbSetting.put(Environment.USER, "root");
		dbSetting.put(Environment.PASS, "");
		dbSetting.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		dbSetting.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		
		//Apply Batabase setting 
		registryBuilder.applySettings(dbSetting);
		//Creating Registry
		standardServiceRegistry = registryBuilder.build();
		//Creating Metadata Source
		MetadataSources sources = new MetadataSources(standardServiceRegistry);
		//Creating Metadata 
		Metadata metadata = sources.getMetadataBuilder().build();
		//Creating Session factory
		sessionFactory = metadata.getSessionFactoryBuilder().build();
	
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
