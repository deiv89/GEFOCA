package it.synclab.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

import it.synclab.exception.CandidateNotFoundException;
import it.synclab.exception.EmptyCandidateListException;
import it.synclab.service.ICandidateService;
import it.synclab.service.IEvaluationFormService;
import it.synclab.service.IOriginService;
import it.synclab.service.ISkillsService;

public class Main {

	public static void main(String[] args) throws IOException, EmptyCandidateListException, CandidateNotFoundException,
			ClassNotFoundException, SQLException {

		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(input);
		char ch;

		do {
			System.out.println(" ");
			System.out.println("SELEZIONARE UNA VOCE");
			System.out.println(" ");
			System.out.println("A: Candidate Service CREATE");
			System.out.println("B: Candidate Service READ");
			System.out.println("C: Candidate Service UPDATE");
			System.out.println("D: Candidate Service LISTA CANDIDATI");
			System.out.println("E: Candidate Service DELETE");
			System.out.println(" ");
			System.out.println("X: EXIT");
			ch = br.readLine().trim().charAt(0);
			ch = Character.toUpperCase(ch);

			switch (ch) {
			/*	case 'A':
				String valueEntered;
				Candidate candidate = new Candidate();
				System.out.println("Inserisci NOME candidato: ");
				valueEntered = br.readLine().trim();
				candidate.setName(valueEntered);
				System.out.println("Inserisci COGNOME candidato: ");
				valueEntered = br.readLine().trim();
				candidate.setSurname(valueEntered);
				System.out.println("Inserisci DATA DI NASCITA candidato: ");
				valueEntered = br.readLine().trim();
				candidate.setDateOfBirth(valueEntered);
				System.out.println("Inserisci QUALIFICA candidato: ");
				valueEntered = br.readLine().trim();
				candidate.setQualification(valueEntered);
				ICandidateService candidateService = CandidateFactory.getCandidateService();
				candidateService.create(candidate);
				candidate = candidateService.read(candidate.getSurname());

				EvaluationForm evaluationForm = new EvaluationForm();
				IEvaluationFormService efService = CandidateFactory.getEvaluationFormService();
				System.out.println(" ");
				System.out.println("SCHEDA DI VALUTAZIONE");
				System.out.println(" ");
				System.out.println("INSERIRE NOME INTERVISTATORE: ");
				valueEntered = br.readLine().trim();
				evaluationForm.setInterviewerName(valueEntered);
				System.out.println("INSERIRE LIVELLO PRESENZA (DA 1 A 5): ");
				int intValueEntered;
				intValueEntered = Integer.parseInt(br.readLine().trim());
				evaluationForm.setLevelPresence(intValueEntered);
				System.out.println("INSERIRE LIVELLO COMUNICAZIONE (DA 1 A 5): ");
				intValueEntered = Integer.parseInt(br.readLine().trim());
				evaluationForm.setLevelComunication(intValueEntered);
				System.out.println("INSERIRE LIVELLO DINAMICITA' (DA 1 A 5): ");
				intValueEntered = Integer.parseInt(br.readLine().trim());
				evaluationForm.setLevelDynamicity(intValueEntered);
				System.out.println("DESCRIVERE ESPERIENZE CANDIDATO: ");
				valueEntered = br.readLine();
				evaluationForm.setExperience(valueEntered);
				System.out.println("DESCRIVERE MOTIVAZIONI CANDIDATO: ");
				valueEntered = br.readLine();
				evaluationForm.setMotivazioni(valueEntered);
				System.out.println("LINGUE CONOSCIUTE DAL CANDIDATO");
				System.out.println(" ");
				ArrayList<Language> spokenLanguages = new ArrayList<Language>();
				Language lang = new Language();
				ArrayList<Language> languagesList = efService.getLanguagesList();
				System.out.println("INSERIRE LIVELLO LINGUA " + languagesList.get(0).getLanguageName() + " : ");
				intValueEntered = Integer.parseInt(br.readLine().trim());
				lang.setLanguageLevel(intValueEntered);
				lang.setIdCandidate(candidate.getIdCandidate());
				lang.setIdLanguage(languagesList.get(0).getIdLanguage());
				spokenLanguages.add(lang);
				System.out.println("INSERIRE LIVELLO LINGUA " + languagesList.get(1).getLanguageName() + " : ");
				intValueEntered = Integer.parseInt(br.readLine().trim());
				lang = new Language();
				lang.setLanguageLevel(intValueEntered);
				lang.setIdCandidate(candidate.getIdCandidate());
				lang.setIdLanguage(languagesList.get(1).getIdLanguage());
				spokenLanguages.add(lang);
				System.out.println("INSERIRE LIVELLO LINGUA " + languagesList.get(2).getLanguageName() + " : ");
				intValueEntered = Integer.parseInt(br.readLine().trim());
				lang = new Language();
				lang.setLanguageLevel(intValueEntered);
				lang.setIdCandidate(candidate.getIdCandidate());
				lang.setIdLanguage(languagesList.get(2).getIdLanguage());
				spokenLanguages.add(lang);
				System.out.println("INSERIRE LIVELLO LINGUA " + languagesList.get(3).getLanguageName() + " : ");
				intValueEntered = Integer.parseInt(br.readLine().trim());
				lang = new Language();
				lang.setLanguageLevel(intValueEntered);
				lang.setIdCandidate(candidate.getIdCandidate());
				lang.setIdLanguage(languagesList.get(3).getIdLanguage());
				spokenLanguages.add(lang);
				System.out.println("INSERIRE LIVELLO LINGUA " + languagesList.get(4).getLanguageName() + " : ");
				intValueEntered = Integer.parseInt(br.readLine().trim());
				lang = new Language();
				lang.setLanguageLevel(intValueEntered);
				lang.setIdCandidate(candidate.getIdCandidate());
				lang.setIdLanguage(languagesList.get(4).getIdLanguage());
				spokenLanguages.add(lang);
				System.out.println("INSERIRE LIVELLO LINGUA " + languagesList.get(5).getLanguageName() + " : ");
				intValueEntered = Integer.parseInt(br.readLine().trim());
				lang = new Language();
				lang.setLanguageLevel(intValueEntered);
				lang.setIdCandidate(candidate.getIdCandidate());
				lang.setIdLanguage(languagesList.get(5).getIdLanguage());
				spokenLanguages.add(lang);

				System.out.println("CANDIDATO DISPONIBILE A TRASFERTE? (SI/NO): ");
				valueEntered = br.readLine();
				evaluationForm.setTransfer(valueEntered);
				System.out.println("INSERIRE RETRIBUZIONE ATTUALE: ");
				double doubleValue;
				doubleValue = Double.parseDouble(br.readLine().trim());
				evaluationForm.setCurrentPay(doubleValue);
				System.out.println("INSERIRE RETRIBUZIONE RICHIESTA: ");
				doubleValue = Double.parseDouble(br.readLine().trim());
				evaluationForm.setRenumeration_required(doubleValue);
				candidate = candidateService.read(candidate.getSurname());
				evaluationForm.setIdCandidate(candidate.getIdCandidate());

				efService.create(evaluationForm, spokenLanguages);

				ISkillsService skillsService = CandidateFactory.getSkillsService();
				Skills skillCandidate = new Skills();
				ArrayList<Skills> skillsCandidateList = new ArrayList<Skills>();
				ArrayList<Skills> skillsMatrix = skillsService.getSkillsList();
				System.out.println(" ");
				System.out.println("SKILL MATRIX");
				System.out.println(" ");
				System.out.println("CATEGORIA " + skillsMatrix.get(0).getCategorySkill() + " INSERIRE LIVELLO "
						+ skillsMatrix.get(0).getParameterName() + " (DA 0 A 4): ");
				intValueEntered = Integer.parseInt(br.readLine().trim());
				skillCandidate.setValuationLevel(intValueEntered);
				skillCandidate.setIdCandidate(candidate.getIdCandidate());
				skillCandidate.setIdSkill(skillsMatrix.get(0).getIdSkill());
				skillCandidate.setParameterName(skillsMatrix.get(0).getParameterName());
				skillsCandidateList.add(skillCandidate);
				System.out.println("CATEGORIA " + skillsMatrix.get(1).getCategorySkill() + " INSERIRE LIVELLO "
						+ skillsMatrix.get(1).getParameterName() + " (DA 0 A 4): ");
				skillCandidate = new Skills();
				intValueEntered = Integer.parseInt(br.readLine().trim());
				skillCandidate.setValuationLevel(intValueEntered);
				skillCandidate.setIdCandidate(candidate.getIdCandidate());
				skillCandidate.setIdSkill(skillsMatrix.get(1).getIdSkill());
				skillCandidate.setParameterName(skillsMatrix.get(1).getParameterName());
				skillsCandidateList.add(skillCandidate);
				System.out.println("CATEGORIA " + skillsMatrix.get(2).getCategorySkill() + " INSERIRE LIVELLO "
						+ skillsMatrix.get(2).getParameterName() + " (DA 0 A 4): ");
				skillCandidate = new Skills();
				intValueEntered = Integer.parseInt(br.readLine().trim());
				skillCandidate.setValuationLevel(intValueEntered);
				skillCandidate.setIdCandidate(candidate.getIdCandidate());
				skillCandidate.setIdSkill(skillsMatrix.get(2).getIdSkill());
				skillCandidate.setParameterName(skillsMatrix.get(2).getParameterName());
				skillsCandidateList.add(skillCandidate);
				System.out.println("CATEGORIA " + skillsMatrix.get(3).getCategorySkill() + " INSERIRE LIVELLO "
						+ skillsMatrix.get(3).getParameterName() + " (DA 0 A 4): ");
				skillCandidate = new Skills();
				intValueEntered = Integer.parseInt(br.readLine().trim());
				skillCandidate.setValuationLevel(intValueEntered);
				skillCandidate.setIdCandidate(candidate.getIdCandidate());
				skillCandidate.setIdSkill(skillsMatrix.get(3).getIdSkill());
				skillCandidate.setParameterName(skillsMatrix.get(3).getParameterName());
				skillsCandidateList.add(skillCandidate);
				System.out.println("CATEGORIA " + skillsMatrix.get(4).getCategorySkill() + " INSERIRE LIVELLO "
						+ skillsMatrix.get(4).getParameterName() + " (DA 0 A 4): ");
				skillCandidate = new Skills();
				intValueEntered = Integer.parseInt(br.readLine().trim());
				skillCandidate.setValuationLevel(intValueEntered);
				skillCandidate.setIdCandidate(candidate.getIdCandidate());
				skillCandidate.setIdSkill(skillsMatrix.get(4).getIdSkill());
				skillCandidate.setParameterName(skillsMatrix.get(4).getParameterName());
				skillsCandidateList.add(skillCandidate);
				skillsService.create(skillsCandidateList);

				IOriginService originService = CandidateFactory.getOriginService();
				Origin origin = new Origin();
				System.out.println(" ");
				System.out.println("CANALE DI PROVENIENZA");
				System.out.println(" ");
				System.out.println("NOME AZIENDA/UNIVERSITA' DI PROVENIENZA: ");
				valueEntered = br.readLine();
				origin.setDescription(valueEntered);
				System.out.println("INDIRIZZO AZIENDA/UNIVERSITA' DI PROVENIENZA: ");
				valueEntered = br.readLine();
				origin.setAddress(valueEntered);
				System.out.println("TELEFONO AZIENDA/UNIVERSITA' DI PROVENIENZA: ");
				valueEntered = br.readLine();
				origin.setPhone(valueEntered);
				originService.create(origin, candidate.getSurname());

				break;
			case 'B':
				String candidateSurname;
				System.out.println("Inserisci COGNOME candidato: ");
				candidateSurname = br.readLine().trim();
				candidateService = CandidateFactory.getCandidateService();
				candidate = candidateService.read(candidateSurname);

				efService = CandidateFactory.getEvaluationFormService();
				evaluationForm = efService.read(candidate.getIdCandidate());

				ArrayList<Skills> skill = new ArrayList<Skills>();
				skillsService = CandidateFactory.getSkillsService();
				skill = skillsService.read(candidate.getIdCandidate());

				originService = CandidateFactory.getOriginService();
				origin = originService.read(candidate.getIdOrigin());

				System.out.println("ID Candidato: " + candidate.getIdCandidate());
				System.out.println("Cognome: " + candidate.getSurname());
				System.out.println("Nome: " + candidate.getName());
				System.out.println("Data di nascita: " + candidate.getDateOfBirth());
				System.out.println("Qualifica: " + candidate.getQualification());
				System.out.println("ID Canale provenienza: " + candidate.getIdOrigin());
				System.out.println(" ");
				System.out.println("SCHEDA VALUTAZIONE CANDIDATO ID " + evaluationForm.getIdCandidate());
				System.out.println(" ");
				System.out.println("NOME INTERVISTATORE: " + evaluationForm.getInterviewerName());
				System.out.println("LIVELLO PRESENZA: " + evaluationForm.getLevelPresence());
				System.out.println("LIVELLO COMUNICAZIONE: " + evaluationForm.getLevelComunication());
				System.out.println("LIVELLO DINAMICITA': " + evaluationForm.getLevelDynamicity());
				System.out.println("ESPERIENZA: " + evaluationForm.getExperience());
				System.out.println("MOTIVAZIONE: " + evaluationForm.getMotivazioni());

				for (int i = 0; i < evaluationForm.getSpokenLanguages().size(); i++) {
					System.out.println("LINGUE PARLATE: " + evaluationForm.getSpokenLanguages().get(i).getLanguageName()
							+ " LIVELLO: " + evaluationForm.getSpokenLanguages().get(i).getLanguageLevel());
				}

				System.out.println("DISPONIBILITA' A TRASFERTA: " + evaluationForm.getTransfer());
				System.out.println("RETRIBUZIONE ATTUALE: " + evaluationForm.getCurrentPay());
				System.out.println("RETRIBUZIONE RICHIESTA: " + evaluationForm.getRenumeration_required());
				System.out.println(" ");
				System.out.println("SKILL MATRIX CANDIDATO ID " + candidate.getIdCandidate());
				System.out.println(" ");
				System.out.println("LIVELLO HTML: " + skill.get(0).getValuationLevel());
				System.out.println("LIVELLO JAVASCRIPT: " + skill.get(1).getValuationLevel());
				System.out.println("LIVELLO JAVA: " + skill.get(2).getValuationLevel());
				System.out.println("LIVELLO MYSQL: " + skill.get(3).getValuationLevel());
				System.out.println("LIVELLO JUNIT: " + skill.get(4).getValuationLevel());
				System.out.println(" ");
				System.out.println("CANALE DI PROVENIENZA CANDIDATO ID " + candidate.getIdCandidate());
				System.out.println(" ");
				System.out.println("NOME AZIENDA/UNIVERSITA' DI PROVENIENZA: " + origin.getDescription());
				System.out.println("INDIRIZZO AZIENDA/UNIVERSITA' DI PROVENIENZA: " + origin.getAddress());
				System.out.println("TELEFONO AZIENDA/UNIVERSITA': " + origin.getPhone());
				System.out.println(" ");
				break;
			case 'C':
				candidateService = CandidateFactory.getCandidateService();
				System.out.println("Inserisci COGNOME candidato da modificare: ");
				candidateSurname = br.readLine().trim();
				Candidate currentCandidate;
				currentCandidate = candidateService.read(candidateSurname);
				candidate = new Candidate();
				String newSurname;
				System.out.println("Inserisci NOME candidato: ");
				valueEntered = br.readLine().trim();
				candidate.setName(valueEntered);
				System.out.println("Inserisci COGNOME candidato: ");
				newSurname = br.readLine().trim();
				candidate.setSurname(newSurname);
				System.out.println("Inserisci DATA DI NASCITA candidato: ");
				valueEntered = br.readLine().trim();
				candidate.setDateOfBirth(valueEntered);
				System.out.println("Inserisci QUALIFICA candidato: ");
				valueEntered = br.readLine().trim();
				candidate.setQualification(valueEntered);
				candidate.setIdCandidate(currentCandidate.getIdCandidate());
				candidate.setIdOrigin(currentCandidate.getIdOrigin());
				candidateService.update(candidateSurname, candidate);

				candidate = candidateService.read(newSurname);
				System.out.println("ID Candidato: " + candidate.getIdCandidate());
				System.out.println("Cognome: " + candidate.getSurname());
				System.out.println("Nome: " + candidate.getName());
				System.out.println("Data di nascita: " + candidate.getDateOfBirth());
				System.out.println("Qualifica: " + candidate.getQualification());
				System.out.println("ID Canale provenienza: " + candidate.getIdOrigin());
				System.out.println(" ");
				System.out.println("SCHEDA VALUTAZIONE CANDIDATO ID " + currentCandidate.getIdCandidate());
				System.out.println(" ");
				System.out.println("INSERIRE NOME INTERVISTATORE: ");
				valueEntered = br.readLine().trim();
				evaluationForm = new EvaluationForm();
				efService = CandidateFactory.getEvaluationFormService();
				evaluationForm.setInterviewerName(valueEntered);
				System.out.println("INSERIRE LIVELLO PRESENZA (DA 1 A 5): ");
				intValueEntered = Integer.parseInt(br.readLine().trim());
				evaluationForm.setLevelPresence(intValueEntered);
				System.out.println("INSERIRE LIVELLO COMUNICAZIONE (DA 1 A 5): ");
				intValueEntered = Integer.parseInt(br.readLine().trim());
				evaluationForm.setLevelComunication(intValueEntered);
				System.out.println("INSERIRE LIVELLO DINAMICITA' (DA 1 A 5): ");
				intValueEntered = Integer.parseInt(br.readLine().trim());
				evaluationForm.setLevelDynamicity(intValueEntered);
				System.out.println("DESCRIVERE ESPERIENZE CANDIDATO: ");
				valueEntered = br.readLine();
				evaluationForm.setExperience(valueEntered);
				System.out.println("DESCRIVERE MOTIVAZIONI CANDIDATO: ");
				valueEntered = br.readLine();
				evaluationForm.setMotivazioni(valueEntered);

				spokenLanguages = new ArrayList<Language>();
				lang = new Language();
				languagesList = efService.getLanguagesList();
				System.out.println("INSERIRE LIVELLO LINGUA " + languagesList.get(0).getLanguageName() + " : ");
				intValueEntered = Integer.parseInt(br.readLine().trim());
				lang.setLanguageLevel(intValueEntered);
				lang.setIdCandidate(candidate.getIdCandidate());
				lang.setIdLanguage(languagesList.get(0).getIdLanguage());
				spokenLanguages.add(lang);
				System.out.println("INSERIRE LIVELLO LINGUA " + languagesList.get(1).getLanguageName() + " : ");
				intValueEntered = Integer.parseInt(br.readLine().trim());
				lang = new Language();
				lang.setLanguageLevel(intValueEntered);
				lang.setIdCandidate(candidate.getIdCandidate());
				lang.setIdLanguage(languagesList.get(1).getIdLanguage());
				spokenLanguages.add(lang);
				System.out.println("INSERIRE LIVELLO LINGUA " + languagesList.get(2).getLanguageName() + " : ");
				intValueEntered = Integer.parseInt(br.readLine().trim());
				lang = new Language();
				lang.setLanguageLevel(intValueEntered);
				lang.setIdCandidate(candidate.getIdCandidate());
				lang.setIdLanguage(languagesList.get(2).getIdLanguage());
				spokenLanguages.add(lang);
				System.out.println("INSERIRE LIVELLO LINGUA " + languagesList.get(3).getLanguageName() + " : ");
				intValueEntered = Integer.parseInt(br.readLine().trim());
				lang = new Language();
				lang.setLanguageLevel(intValueEntered);
				lang.setIdCandidate(candidate.getIdCandidate());
				lang.setIdLanguage(languagesList.get(3).getIdLanguage());
				spokenLanguages.add(lang);
				System.out.println("INSERIRE LIVELLO LINGUA " + languagesList.get(4).getLanguageName() + " : ");
				intValueEntered = Integer.parseInt(br.readLine().trim());
				lang = new Language();
				lang.setLanguageLevel(intValueEntered);
				lang.setIdCandidate(candidate.getIdCandidate());
				lang.setIdLanguage(languagesList.get(4).getIdLanguage());
				spokenLanguages.add(lang);
				System.out.println("INSERIRE LIVELLO LINGUA " + languagesList.get(5).getLanguageName() + " : ");
				intValueEntered = Integer.parseInt(br.readLine().trim());
				lang = new Language();
				lang.setLanguageLevel(intValueEntered);
				lang.setIdCandidate(candidate.getIdCandidate());
				lang.setIdLanguage(languagesList.get(5).getIdLanguage());
				spokenLanguages.add(lang);

				System.out.println("CANDIDATO DISPONIBILE A TRASFERTE? (SI/NO): ");
				valueEntered = br.readLine();
				evaluationForm.setTransfer(valueEntered);
				System.out.println("INSERIRE RETRIBUZIONE ATTUALE: ");
				doubleValue = Double.parseDouble(br.readLine().trim());
				evaluationForm.setCurrentPay(doubleValue);
				System.out.println("INSERIRE RETRIBUZIONE RICHIESTA: ");
				doubleValue = Double.parseDouble(br.readLine().trim());
				evaluationForm.setRenumeration_required(doubleValue);
				evaluationForm.setIdCandidate(candidate.getIdCandidate());

				efService.update(evaluationForm, spokenLanguages);
				evaluationForm = efService.read(candidate.getIdCandidate());

				System.out.println(" ");
				System.out.println("SCHEDA VALUTAZIONE CANDIDATO ID " + candidate.getIdCandidate());
				System.out.println(" ");
				System.out.println("NOME INTERVISTATORE: " + evaluationForm.getInterviewerName());
				System.out.println("LIVELLO PRESENZA: " + evaluationForm.getLevelPresence());
				System.out.println("LIVELLO COMUNICAZIONE: " + evaluationForm.getLevelComunication());
				System.out.println("LIVELLO DINAMICITA': " + evaluationForm.getLevelDynamicity());
				System.out.println("ESPERIENZA: " + evaluationForm.getExperience());
				System.out.println("MOTIVAZIONE: " + evaluationForm.getMotivazioni());

				for (int i = 0; i < evaluationForm.getSpokenLanguages().size(); i++) {
					System.out.println("LINGUE PARLATE: " + evaluationForm.getSpokenLanguages().get(i).getLanguageName()
							+ " LIVELLO: " + evaluationForm.getSpokenLanguages().get(i).getLanguageLevel());
				}

				System.out.println("DISPONIBILITA' A TRASFERTA: " + evaluationForm.getTransfer());
				System.out.println("RETRIBUZIONE ATTUALE: " + evaluationForm.getCurrentPay());
				System.out.println("RETRIBUZIONE RICHIESTA: " + evaluationForm.getRenumeration_required());

				skillsService = CandidateFactory.getSkillsService();
				skillCandidate = new Skills();
				ArrayList<Skills> candidateSkills = new ArrayList<Skills>();
				skillsMatrix = skillsService.getSkillsList();
				System.out.println(" ");
				System.out.println("SKILL MATRIX");
				System.out.println(" ");
				System.out.println("CATEGORIA " + skillsMatrix.get(0).getCategorySkill() + " INSERIRE LIVELLO "
						+ skillsMatrix.get(0).getParameterName() + " (DA 0 A 4): ");
				intValueEntered = Integer.parseInt(br.readLine().trim());
				skillCandidate.setValuationLevel(intValueEntered);
				skillCandidate.setIdCandidate(candidate.getIdCandidate());
				skillCandidate.setIdSkill(skillsMatrix.get(0).getIdSkill());
				skillCandidate.setParameterName(skillsMatrix.get(0).getParameterName());
				candidateSkills.add(skillCandidate);
				System.out.println("CATEGORIA " + skillsMatrix.get(1).getCategorySkill() + " INSERIRE LIVELLO "
						+ skillsMatrix.get(1).getParameterName() + " (DA 0 A 4): ");
				skillCandidate = new Skills();
				intValueEntered = Integer.parseInt(br.readLine().trim());
				skillCandidate.setValuationLevel(intValueEntered);
				skillCandidate.setIdCandidate(candidate.getIdCandidate());
				skillCandidate.setIdSkill(skillsMatrix.get(1).getIdSkill());
				skillCandidate.setParameterName(skillsMatrix.get(1).getParameterName());
				candidateSkills.add(skillCandidate);
				System.out.println("CATEGORIA " + skillsMatrix.get(2).getCategorySkill() + " INSERIRE LIVELLO "
						+ skillsMatrix.get(2).getParameterName() + " (DA 0 A 4): ");
				skillCandidate = new Skills();
				intValueEntered = Integer.parseInt(br.readLine().trim());
				skillCandidate.setValuationLevel(intValueEntered);
				skillCandidate.setIdCandidate(candidate.getIdCandidate());
				skillCandidate.setIdSkill(skillsMatrix.get(2).getIdSkill());
				skillCandidate.setParameterName(skillsMatrix.get(2).getParameterName());
				candidateSkills.add(skillCandidate);
				System.out.println("CATEGORIA " + skillsMatrix.get(3).getCategorySkill() + " INSERIRE LIVELLO "
						+ skillsMatrix.get(3).getParameterName() + " (DA 0 A 4): ");
				skillCandidate = new Skills();
				intValueEntered = Integer.parseInt(br.readLine().trim());
				skillCandidate.setValuationLevel(intValueEntered);
				skillCandidate.setIdCandidate(candidate.getIdCandidate());
				skillCandidate.setIdSkill(skillsMatrix.get(3).getIdSkill());
				skillCandidate.setParameterName(skillsMatrix.get(3).getParameterName());
				candidateSkills.add(skillCandidate);
				System.out.println("CATEGORIA " + skillsMatrix.get(4).getCategorySkill() + " INSERIRE LIVELLO "
						+ skillsMatrix.get(4).getParameterName() + " (DA 0 A 4): ");
				skillCandidate = new Skills();
				intValueEntered = Integer.parseInt(br.readLine().trim());
				skillCandidate.setValuationLevel(intValueEntered);
				skillCandidate.setIdCandidate(candidate.getIdCandidate());
				skillCandidate.setIdSkill(skillsMatrix.get(4).getIdSkill());
				skillCandidate.setParameterName(skillsMatrix.get(4).getParameterName());
				candidateSkills.add(skillCandidate);

				skillsService.update(candidateSkills);

				originService = CandidateFactory.getOriginService();
				origin = originService.read(candidate.getIdOrigin());
				System.out.println(" ");
				System.out.println("CANALE DI PROVENIENZA");
				System.out.println(" ");
				System.out.println("NOME AZIENDA/UNIVERSITA' DI PROVENIENZA: ");
				valueEntered = br.readLine();
				origin.setDescription(valueEntered);
				System.out.println("INDIRIZZO AZIENDA/UNIVERSITA' DI PROVENIENZA: ");
				valueEntered = br.readLine();
				origin.setAddress(valueEntered);
				System.out.println("TELEFONO AZIENDA/UNIVERSITA' DI PROVENIENZA: ");
				valueEntered = br.readLine();
				origin.setPhone(valueEntered);
				originService.update(origin);
				System.out.println("CANDIDATO ID " + candidate.getIdCandidate() + " MODIFICATO");
				System.out.println(" ");
				break;*/
			case 'D':
				ICandidateService candidateService = CandidateFactory.getJPACandidate();
				candidateService = CandidateFactory.getCandidateService();
				ArrayList<Candidate> candidateList = new ArrayList<Candidate>();
				candidateList = candidateService.getCandidateList();
				for (int i = 0; i < candidateList.size(); i++) {
					System.out.println(" ");
					System.out.println("candidato " + i + ": ID Candidato: " + candidateList.get(i).getIdCandidate());
					System.out.println("candidato " + i + ": Cognome: " + candidateList.get(i).getSurname());
					System.out.println("candidato " + i + ": Nome: " + candidateList.get(i).getName());
					System.out
							.println("candidato " + i + ": Data di nascita: " + candidateList.get(i).getDateOfBirth());
					System.out.println("candidato " + i + ": Qualifica: " + candidateList.get(i).getQualification());
					System.out.println("candidato " + i + ": ID Origine: " + candidateList.get(i).getIdOrigin());
					System.out.println(" ");
				}
				if (candidateList.size() == 0) {
					throw new EmptyCandidateListException("NESSUNA VOCE PRESENTE!");
				}
				break;
			/*case 'E':
				System.out.println("Inserisci COGNOME candidato da eliminare: ");
				candidateSurname = br.readLine().trim();
				candidateService = CandidateFactory.getCandidateService();
				candidate = candidateService.read(candidateSurname);
				candidateService.delete(candidateSurname);

				efService = CandidateFactory.getEvaluationFormService();
				efService.delete(candidate.getIdCandidate());

				skillsService = CandidateFactory.getSkillsService();
				skillsService.delete(candidate.getIdCandidate());

				originService = CandidateFactory.getOriginService();
				originService.delete(candidate.getIdOrigin());

				System.out.println("CANDIDATO " + candidateSurname.toUpperCase() + " ELIMINATO");
				break;*/
			}
		} while (ch != 'X');

	}

}
			