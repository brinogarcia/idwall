package com.idwall.desafio.idwall.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class StringService {

	public String refactorString(String text, int limit) {

		String[] textRefactor = text.split(" ");
		String textRefactorReturn = "";
		int contLength = 0;
		for (int i = 0; i < textRefactor.length; i++) {
			contLength += (textRefactor[i] + " ").length();
			if (contLength >= limit) {
				textRefactorReturn += System.getProperty("line.separator");
				contLength = (textRefactor[i] + " ").length();
			}
			textRefactorReturn += textRefactor[i];
			textRefactorReturn += " ";
		}
		return textRefactorReturn;		
	}

}
