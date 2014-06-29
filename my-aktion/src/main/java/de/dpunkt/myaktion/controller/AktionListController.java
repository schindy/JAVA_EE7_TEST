package de.dpunkt.myaktion.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import de.dpunkt.myaktion.controller.AktionEditController.Mode;
import de.dpunkt.myaktion.model.Aktion;
import de.dpunkt.myaktion.util.Events.Deleted;


@SessionScoped
@Named
public class AktionListController implements Serializable {

	private static final long serialVersionUID = 8992451628920941345L;
	
	@Inject
	private AktionEditController aktionEditController;
	@Inject
	private SpendeListController spendeListController;
	@Inject
	private SpendeFormEditController spendeFormEditController;
	@Inject @Deleted
	private Event<Aktion> aktionDeleteEventSrc;
	
	private Aktion aktionToDelete;
	
	public String doAddAktion() {
		aktionEditController.setAktionToEdit(Mode.ADD);
		return Pages.AKTION_EDIT;
	}
	
	public String doEditAktion(Aktion aktion) {
		aktionEditController.setAktionToEdit(Mode.EDIT, aktion);
		return Pages.AKTION_EDIT;
	}
	
	public String doListSpende(Aktion aktion) {
		spendeListController.setAktion(aktion);
		return Pages.SPENDE_LIST;
	}
	
	public String doEditSpendeForm(Aktion aktion) {
		System.out.println("aktion " + aktion);
		spendeFormEditController.setAktion(aktion);
		System.out.println("aktion " + aktion);
		return Pages.SPENDE_FORM_EDIT;
	}
	
	public void doDeleteAktion(Aktion aktion) {
		this.aktionToDelete = aktion;
		System.out.println("Aktion zum Löschen vorgemerkt");
	}

	public void commitDeleteAktion() {
		aktionDeleteEventSrc.fire(aktionToDelete);
	}
}
