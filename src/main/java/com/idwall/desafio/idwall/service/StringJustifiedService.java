package com.idwall.desafio.idwall.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StringJustifiedService {

	public String refactorStringJustified(String text, int limit) {
		String[] words = text.split(" ");
		int max = limit;

		List<String> result = new ArrayList<>();
		int len = 0;
		int j = 0;
		for (int i = 0; i < words.length; i++) {
			String w = words[i];
			if (len + w.length() > max) {
				int wCnt = i - j;
				int spaceSlot = wCnt - 1;
				int remain = max - (len - 1) + spaceSlot;
				String temp = "";
				if (spaceSlot > 0) {
					int spaceCnt = 0;
					while (spaceCnt < remain) {
						for (int k = j; k <= i - 2; k++) {
							words[k] += " ";
							spaceCnt++;
							if (spaceCnt == remain)
								break;
						}
					}
					for (int k = j; k <= i - 2; k++)
						temp += words[k];
				}
				temp += words[i - 1];
				if (spaceSlot == 0) {
					for (int space = 0; space < remain; space++)
						temp += " ";
				}
				result.add(temp);
				j = i;
				i--;
				len = 0;
				continue;
			}
			len += w.length() + 1;
		}
		String temp = "";
		while (j < words.length - 1)
			temp += words[j++] + " ";
		temp += words[j];
		int trailingSpace = max - len + 1;
		for (int i = 0; i < trailingSpace; i++)
			temp += " ";
		result.add(temp);
		FileWriter arquivo;

		try {
			arquivo = new FileWriter(new File("Arquivo.txt"));
			for (String string : result) {
				arquivo.write(String.format("%-" + limit + "." + limit + "s \n", string.replaceAll("\n", "")));
			}
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		BufferedReader br;
		String textRefactorJustfied = "";
		try {
			br = new BufferedReader(new FileReader("Arquivo.txt"));

			try {
				while (br.ready()) {
					textRefactorJustfied += String.format("%-" + limit + "." + limit + "s \n",
							br.readLine().replaceAll("\n", ""));
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return textRefactorJustfied;
	}

}
