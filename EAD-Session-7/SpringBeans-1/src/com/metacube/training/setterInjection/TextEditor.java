package com.metacube.training.setterInjection;


public class TextEditor {

	SpellChecker spellCheck;
	
	public void setSpellChecker(SpellChecker spellCheck){
		this.spellCheck=spellCheck;
	}
	
	public SpellChecker getSpellChecker(){
		return spellCheck;
	}
}
