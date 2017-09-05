package it.synclab.business;

import it.synclab.jpa.JPACandidate;
import it.synclab.jpa.JPAEvaluationForm;
import it.synclab.jpa.JPAMovements;
import it.synclab.jpa.JPAOrigin;
import it.synclab.jpa.JPASkills;
import it.synclab.jpa.JPAUser;
import it.synclab.service.CandidateCollectionService;
import it.synclab.service.CandidateService;
import it.synclab.service.EvaluationFormCollectionService;
import it.synclab.service.EvaluationFormService;
import it.synclab.service.OriginCollectionService;
import it.synclab.service.OriginService;
import it.synclab.service.SkillsService;

public class CandidateFactory {

	public static CandidateCollectionService getCandidateCollectionService() {
		return CandidateCollectionService.getInstance();
	}
	
	public static EvaluationFormCollectionService getEvaluationFormCollectionService(){
		return EvaluationFormCollectionService.getInstance();
	}
	
	public static SkillsService getSkillsService(){
		return SkillsService.getInstance();
	}
	
	public static OriginCollectionService getOriginCollectionService(){
		return OriginCollectionService.getInstance();
	}
	
	public static CandidateService getCandidateService(){
		return CandidateService.getInstance();
	}
	
	public static EvaluationFormService getEvaluationFormService(){
		return EvaluationFormService.getInstance();
	}
	
	public static OriginService getOriginService(){
		return OriginService.getInstance();
	}
	
	public static JPACandidate getJPACandidate(){
		return JPACandidate.getInstance();
	}
	
	public static JPAEvaluationForm getJPAEvaluationForm(){
		return JPAEvaluationForm.getInstance();
	}
	
	public static JPASkills getJPASkills(){
		return JPASkills.getInstance();
	}
	
	public static JPAOrigin getJPAOrigin(){
		return JPAOrigin.getInstance();
	}
	
	public static JPAUser getJPAUser(){
		return JPAUser.getInstance();
	}
	
	public static JPAMovements getJPAMovement(){
		return JPAMovements.getInstance();
	}

}
