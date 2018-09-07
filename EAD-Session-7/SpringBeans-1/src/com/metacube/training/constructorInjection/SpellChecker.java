package com.metacube.training.constructorInjection;

public class SpellChecker {

	String spellCheck;
	public String getSpellCheck() {
		return spellCheck;
	}

	public SpellChecker(String spellCheck) {
		this.spellCheck = spellCheck;
	}
	
}
