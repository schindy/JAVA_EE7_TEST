package de.dpunkt.myaktion.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import de.dpunkt.myaktion.model.Aktion;
import de.dpunkt.myaktion.model.Spende.Status;

@RequestScoped
@Named
public class SpendeListController implements Serializable {

	private static final long serialVersionUID = 2459195467747180771L;
	private Aktion aktion;
	
	public Aktion getAktion() {
		return aktion;
	}
	
	public void setAktion(Aktion aktion) {
		this.aktion = aktion;
	}
	
	public String doOk() {
		return Pages.AKTION_LIST;
	}
	
	public String convertStatus(Status status) {
		switch(status) {
		case UEBERWIESEN:
			return "überwiesen";
		case IN_BEARBEITUNG:
			return "in Bearbeitung";
		default:
			return "";
		}
	}
}
