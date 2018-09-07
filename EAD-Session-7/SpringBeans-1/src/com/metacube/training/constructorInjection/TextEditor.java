package com.metacube.training.constructorInjection;




public class TextEditor {

	SpellChecker spellCheck;
	
	public TextEditor(SpellChecker spellCheck){
		this.spellCheck=spellCheck;
	}
	
	public SpellChecker getSpellChecker(){
		return spellCheck;
	}
}
