package edu.depaul.cdm.se.controller;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class PhaseChecker implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("+++++After event: " + arg0.getSource());
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("+++++Before event: " + arg0.getSource() + arg0.getPhaseId());

	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return  PhaseId.RESTORE_VIEW;
	}

}
