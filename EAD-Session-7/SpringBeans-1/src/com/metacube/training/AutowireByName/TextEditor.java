package com.metacube.training.AutowireByName;


public class TextEditor {

SpellChecker spellCheck;
	
	public void setSpellCheck(SpellChecker spellCheck){
		this.spellCheck=spellCheck;
	}
	public SpellChecker getSpellCheck(){
		return spellCheck;
	}
	
	public String callSpellCheck(){
		return getSpellCheck().getText();
	}
}
