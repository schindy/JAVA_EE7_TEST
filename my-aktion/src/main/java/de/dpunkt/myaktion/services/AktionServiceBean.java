package de.dpunkt.myaktion.services;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import de.dpunkt.myaktion.model.Aktion;
import de.dpunkt.myaktion.util.Resources.TecLog;

@RequestScoped
@Alternative
public class AktionServiceBean implements AktionService {
	
	@Inject
	EntityManager entityManager;
	
	@Inject @TecLog
	Logger logger;
	
	public List<Aktion> getAllAktion() {
		TypedQuery<Aktion> query = entityManager.createNamedQuery(Aktion.findAll, Aktion.class);
		List<Aktion> aktionen = query.getResultList();
		return aktionen;
	}
	
	@Override
	public List<Aktion> getAllAktionen() {
		logger.info("getAllAktion()");
		return new LinkedList<Aktion>();
	}
	
	@Override
	public void addAktion(Aktion aktion) {
		entityManager.persist(aktion);
	}
	
	@Override
	public void updateAktion(Aktion aktion) {
		entityManager.merge(aktion);
	}

	@Override
	public void deleteAktion(Aktion aktion) {
		Aktion managedAktion = entityManager.find(Aktion.class, aktion.getId());
		entityManager.remove(managedAktion);
	}

}
