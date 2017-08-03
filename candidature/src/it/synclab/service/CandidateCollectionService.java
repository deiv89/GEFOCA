package it.synclab.service;

import java.util.ArrayList;

import it.synclab.business.Candidate;
import it.synclab.exception.CandidateNotFoundException;
import it.synclab.exception.EmptyCandidateListException;
public class CandidateCollectionService  {

	public ArrayList<Candidate> candidateList = new ArrayList<Candidate>();

	private static CandidateCollectionService instance = new CandidateCollectionService();

	private CandidateCollectionService() {
	}

	public static CandidateCollectionService getInstance() {
		if (instance == null)
			instance = new CandidateCollectionService();
		return instance;
	}

	public ArrayList<Candidate> getCandidateList() throws EmptyCandidateListException {
		for (int i = 0; i < candidateList.size(); i++) {
			System.out.println(" ");
			System.out.println("candidato " + i + ": ID Candidato: " + candidateList.get(i).getIdCandidate());
			System.out.println("candidato " + i + ": Cognome: " + candidateList.get(i).getSurname());
			System.out.println("candidato " + i + ": Nome: " + candidateList.get(i).getName());
			System.out.println("candidato " + i + ": Data di nascita: " + candidateList.get(i).getDateOfBirth());
			System.out.println("candidato " + i + ": Qualifica: " + candidateList.get(i).getQualification());
			System.out.println(" ");
		}
		if(candidateList.size() == 0){
			throw new EmptyCandidateListException("NESSUNA VOCE PRESENTE!");
		}
		return candidateList;
	}

	public void create(Candidate candidate) {
		int idCandidate = 0;
		for(int i = 0; i < candidateList.size(); i++){
			idCandidate = candidateList.get(i).getIdCandidate() + 1;
		}
		if(idCandidate == 0)
			idCandidate = 1;
		candidate.setIdCandidate(idCandidate);
		candidateList.add(candidate);
	}

	public Candidate read(String candidateSurname) throws EmptyCandidateListException, CandidateNotFoundException {
		Candidate candidate = new Candidate();
		for (int i = 0; i < candidateList.size(); i++) {
			if (candidateList.get(i).getSurname().equals(candidateSurname)) {
				candidate.setIdCandidate(candidateList.get(i).getIdCandidate());
				candidate.setSurname(candidateSurname);
				candidate.setName(candidateList.get(i).getName());
				candidate.setDateOfBirth(candidateList.get(i).getDateOfBirth());
				candidate.setQualification(candidateList.get(i).getQualification());
			}
		}
		if(candidateList.isEmpty()){
			throw new EmptyCandidateListException("NESSUN CANDIDATO PRESENTE!");
		}
		else if(candidate.getSurname() == null){
			throw new CandidateNotFoundException("CANDIDATO INESISTENTE");
		}
			
		return candidate;
	}

	public void update(String candidateSurname, Candidate candidate) {
		int index = 0;
		for (int i = 0; i < candidateList.size(); i++) {
			if (candidateList.get(i).getSurname().equals(candidateSurname)) 
				index = i;
		}
		candidateList.set(index, candidate);

	}

	public void delete(String candidateSurname) {
		for (int i = 0; i < candidateList.size(); i++) {
			if (candidateList.get(i).getSurname().equals(candidateSurname)) {
				candidateList.remove(i);
			}
		}
	}

	
}
