package com.presentation.controleurs;

import java.util.ArrayList;
import com.business.Decision;
import com.businessmanager.DecisionManager;
import com.presentation.views.AcceuilChefDeService;
import com.presentation.views.ConsultAvancement;

public class ConsultAvancementControleur {
	private ConsultAvancement consultavancement;
	
	public ConsultAvancementControleur() {
	}

	public ConsultAvancement getConsultavancement() {
		return consultavancement;
	}

	public void setConsultavancement(ConsultAvancement consultavancement) {
		this.consultavancement = consultavancement;
		consultavancement.setControleur(this);
	}
	public ArrayList<Decision> getDecisions()
	{
		return DecisionManager.getDecisions();
	}

	public void acceder() {
		AcceuilChefDeService a =new AcceuilChefDeService();
		a.setSize(consultavancement.getSize());
		a.setLocation(consultavancement.getLocation());
		//a.setCin(b);
		consultavancement.dispose();
		a.setVisible(true);
		
	}

}
