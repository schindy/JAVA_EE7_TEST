package de.dpunkt.myaktion.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import de.dpunkt.myaktion.model.Aktion;
import de.dpunkt.myaktion.util.Events.Added;
import de.dpunkt.myaktion.util.Events.Updated;

@SessionScoped
@Named
public class AktionEditController implements Serializable {

	private static final long serialVersionUID = 4423924627821473096L;
	
	@Inject @Added
	private Event<Aktion> aktionAddEventSrc;
	
	@Inject @Updated
	private Event<Aktion> aktionUpdateEventSrc;
	
	public enum Mode {
		EDIT, ADD
	};
	
	private Aktion aktion;
	private Mode mode;
	
	private Mode getMode () {
		return mode;
	}
	
	public Aktion getAktion() {
		return aktion;
	}
	
	public void setAktionToEdit(Mode mode) {
		setAktionToEdit(mode, new Aktion());
	}
	
	public void setAktionToEdit(Mode mode, Aktion aktion) {
		this.aktion = aktion;
		this.mode = mode;
	}
	
	public String doSave() {
		if(getMode() == Mode.ADD) {
			aktionAddEventSrc.fire(aktion);
		} else {
			aktionUpdateEventSrc.fire(aktion);
		}
		return Pages.AKTION_LIST;
	}
	
	public String doCancel() {
		return Pages.AKTION_LIST;
	}
	
	public String getTitle() {
		return getMode()==Mode.EDIT ? "Aktion editieren" : "Neue Aktion anlegen";
	}
}
