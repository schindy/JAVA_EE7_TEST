package de.dpunkt.myaktion.model;

public class FormConfig {
	
	private String textColor = "000000";
	private String bgColor = "ffffff";
	private String titel = "Geld spenden";
	
	public String getBgColor() {
		return bgColor;
	}
	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}
	public String getTextColor() {
		return textColor;
	}
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
}
