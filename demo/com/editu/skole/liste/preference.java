package com.editu.skole.liste;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class preference {
	Preferences prefs = Preferences.userNodeForPackage(com.editu.skole.liste.preference.class);
	public int getLastDate(int Name) {
		String Id = new String();
		Id = "" + Name;
		int getVal = 0;
		getVal = prefs.getInt(Id, -1);
		
		return getVal;
	}
	public void setCurrentDate(int Name, int Month) {
		String Id = new String();
		Id = "" + Name;
		
		prefs.putInt(Id, Month);
		
	}
	public void printList() {
		for(int i = 0; i <= 22; i++) {
			System.out.println(prefs.getInt(""+i, -1));
		}
	}
	public void clear() throws BackingStoreException {
		prefs.clear();
	}
}
