package utils;

import java.util.Scanner;

import exceptions.ErrorMessage;

public final class MyScanner {
    protected final static Scanner scannerPrompt = new Scanner(System.in);

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
