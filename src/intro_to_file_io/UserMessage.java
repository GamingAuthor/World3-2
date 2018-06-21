package intro_to_file_io;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class UserMessage {
	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog("Write something!");
		String ceaser = "";
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			ceaser+=(char)(c+3);
		}
		try {
			FileWriter fw = new FileWriter("src/intro_to_file_io/hagrid.txt", true);
			fw.write("\n"+ ceaser);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
