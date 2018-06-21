package intro_to_file_io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Copyright {
		public static void main(String[] args) {
//			JFileChooser jfc = new JFileChooser();
//			int returnVal = jfc.showOpenDialog(null);
//			if (returnVal == JFileChooser.APPROVE_OPTION) {
	//			String fileName = jfc.getSelectedFile().getAbsolutePath();
				try {
					FileWriter fw = new FileWriter("src/intro_to_file_io/junk.java",true);
					fw.append("//Copyright @ 2018 by Joseph Aguilar");
					fw.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}	
	}
//}
