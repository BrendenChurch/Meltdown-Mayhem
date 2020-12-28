package me.brendenchurch.meltdownmayhem;

public enum PlayerClass {
	HUNTER;
	
	public String getClassName() {
		switch(this) {
		case HUNTER:
			return "The Hunter";
		default:
			return null;
		}
	}
	
	public String getSpriteId() {
		switch(this) {
		case HUNTER:
			return "hunter";
		default:
			return null;
		}
	}
	
}