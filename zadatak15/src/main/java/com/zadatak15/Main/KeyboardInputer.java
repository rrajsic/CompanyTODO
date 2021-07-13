package com.zadatak15.Main;

import java.util.Scanner;

/*
 * Singleton used for inputing from keyboard
 */
public class KeyboardInputer {

	private static KeyboardInputer instance;
	public Scanner input;

	private KeyboardInputer() {
		this.input = new Scanner(System.in);

	}


	/*
	 * If there's no instance of this singleton it will create one, if there is it will return that one.
	 */
	public static KeyboardInputer getInstance() {
		if (instance == null) {
			instance = new KeyboardInputer();
		}
		return instance;
	}
}
