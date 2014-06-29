package de.dpunkt.myaktion.controller;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import de.dpunkt.myaktion.model.Spende;
import de.dpunkt.myaktion.util.Resources.FachLog;

@SessionScoped
@Named
public class GeldSpendenController implements Serializable {

	private static final long serialVersionUID = 492756331494863028L;
	private String textColor = "000000";
	private String bgColor = "ffffff";
	private String titel = "Geld spenden";
	private Spende spende;
	private Long aktionId;
	
	@Inject
	private FacesContext facesContext;
	
	@Inject @FachLog
	Logger logger;
	
	public GeldSpendenController () {
		init();
	}
	
	@PostConstruct
	public void init() {
		this.spende = new Spende();
	}
	
	public Spende getSpende() {
		return spende;
	}
	
	public void setSpende(Spende spende) {
		this.spende = spende;
	}
	
	public String getTextColor () {
		return textColor;
	}
	
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
	
	public String getBgColor() {
		return bgColor;
	}
	
	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}
	
	public Long getAktionId() {
		return aktionId;
	}
	
	public void setAktionId(Long aktionId) {
		this.aktionId = aktionId;
	}
	
	public String doSpende() {
		logger.info(spende.getSpenderName() + " hat " + spende.getBetrag() + " Euro gespendet.");
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Vielen Dank für die Spende", null);
		facesContext.addMessage(null, facesMessage);
		init();
		return Pages.GELD_SPENDEN;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}
}
