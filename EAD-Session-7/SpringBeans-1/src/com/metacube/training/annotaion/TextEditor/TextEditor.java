package com.metacube.training.annotaion.TextEditor;

import org.springframework.beans.factory.annotation.Autowired;


public class TextEditor {
	@Autowired
	SpellChecker spellCheck;
	
	public void setSpellChecker(SpellChecker spellCheck){
		this.spellCheck=spellCheck;
	}
	
	public SpellChecker getSpellChecker(){
		return spellCheck;
	}
}
