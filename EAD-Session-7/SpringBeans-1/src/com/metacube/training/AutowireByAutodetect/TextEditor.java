package com.metacube.training.AutowireByAutodetect;




public class TextEditor {

	SpellChecker spellCheck;
	
	public TextEditor(SpellChecker spellCheck){
		this.spellCheck=spellCheck;
	}
	
	public SpellChecker getSpellChecker(){
		return spellCheck;
	}
	
	public void setSpellChecker(SpellChecker spellCheck){
		this.spellCheck=spellCheck;
	}
}
