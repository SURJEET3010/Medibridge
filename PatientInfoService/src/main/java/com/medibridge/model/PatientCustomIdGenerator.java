package com.medibridge.model;

import java.util.Properties;
import java.util.UUID;

import org.hibernate.boot.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

public class PatientCustomIdGenerator implements  IdentifierGenerator {
	public static final String GENERATOR_NAME = "customIdGenerator";
	public static final String PREFIX_PARAM = "prefix";
	private String prefix = "";

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		String uuid = UUID.randomUUID().toString().substring(0, 4);
		return (prefix + uuid).toUpperCase();
	}
	
	@Override
	public void configure(Type type, Properties parameters, ServiceRegistry serviceRegistry) throws MappingException{
		this.prefix = parameters.getProperty(PREFIX_PARAM, "");
	}
}
