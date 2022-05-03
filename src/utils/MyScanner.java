package utils;

import java.util.Scanner;

import exceptions.ErrorMessage;

public class MyScanner {
    protected static Scanner scannerPrompt = new Scanner(System.in);

    public static Scanner prompt() {
    	return scannerPrompt;
    }
    
    public static Integer myNextInt() {
    	try {			
    		return Integer.parseInt(scannerPrompt.nextLine());
		} catch (Exception e) {
			throw new ErrorMessage("Valor inválido!");
		}
    }
}
