package findAllDistinctWords;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//I did not create default constructor. Leave it for Object
public class SthToDoWithFile {
	private Set<String> allDisWords = new HashSet<String>();

	public void addList(File f) {
		if(!f.exists()) {
		 new FileNotFoundException().printStackTrace();
		}
		else {
			try (FileReader fr = new FileReader(f)) {
				Scanner scn = new Scanner(fr);
				while (scn.hasNextLine()) {
					String s = scn.nextLine();
					String[] write = splitSymbols(s);
					for (int i = 0; i < write.length; i++) {
						allDisWords.add(write[i].toLowerCase());
					}
				}
				scn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
//split string for words
	private String[] splitSymbols(String s) {
		String[] temp = s.split("\\t|[.,-=+\")(]");
		return temp;
	}

	@Override
	public String toString() {
		for (String string : allDisWords) {
			System.out.print(string+" ");
		}
		return "	- Successful";
	}
}
