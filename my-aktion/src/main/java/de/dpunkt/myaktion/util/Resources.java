package de.dpunkt.myaktion.util;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.inject.Qualifier;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

public class Resources {
	
	@Produces
	@PersistenceContext
	private EntityManager entityManager;
	
	@Produces
	@FachLog
	public Logger produceFachLog(InjectionPoint injectionPoint) {
		return Logger.getLogger("FachLog: " + injectionPoint.getMember().getDeclaringClass().getName());
	}
	
	@Produces
	@TecLog
	public Logger produceTecLog(InjectionPoint injectionPoint) {
		return Logger.getLogger("TecLog: " + injectionPoint.getMember().getDeclaringClass().getName());
	}
	
	
	@Produces
	@RequestScoped
	public FacesContext produceFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	@Produces
	@RequestScoped
	HttpServletRequest produceRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
	
	@Qualifier
	@Target({ METHOD, FIELD, PARAMETER })
	@Retention(RUNTIME)
	public @interface FachLog {
		
	}
	
	@Qualifier
	@Target({ METHOD, FIELD, PARAMETER })
	@Retention(RUNTIME)
	public @interface TecLog {
		
	}
	
}
