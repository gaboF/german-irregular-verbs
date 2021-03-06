package com.jozeflang.android.germanirregularverbs.validator;

import com.jozeflang.android.germanirregularverbs.db.VerbDTO;
import com.jozeflang.android.germanirregularverbs.main.Answer;

/** 
 * Answer validator
 * @author Jozef Lang (developer@jozeflang.com)
 */
public class AnswerValidator {

	private AnswerValidator() {
		
	}
	
	public static boolean validate(VerbDTO verb, final Answer answer, AnswerType answerType) {
		switch (answerType) {
		case PERFECT:
			return validatePerfect(verb, answer);
		case PRETERITE:
			return validatePreterite(verb, answer);
		default:
			return false;
		}
	}
	
	private static boolean validatePerfect(VerbDTO verb, final Answer answer) {
		for (VerbDTO.Perfect p : verb.getPerfects()) {
			if (p.getAuxVerb().equalsIgnoreCase(answer.getAuxVerb()) && p.getPerfect().equalsIgnoreCase(answer.getVerb()))
				return true;
		}
		return false;
	}
	
	private static boolean validatePreterite(VerbDTO verb, final Answer answer) {
		for (VerbDTO.Preterite p : verb.getPreterites()) {
			if (p.getPreterite().equalsIgnoreCase(answer.getVerb()))
				return true;
		}
		return false;
	}
	
}
