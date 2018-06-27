package intro_to_file_io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoListTracker implements ActionListener {
	HashMap<Integer, String> ash = new HashMap<Integer, String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton("Add task");
	JButton remove = new JButton("Remove task");
	JButton save = new JButton("Save");
	JButton load = new JButton("Load");

	public static void main(String[] args) {
		ToDoListTracker hi = new ToDoListTracker();
		hi.ui();
	}

	void ui() {
		frame.add(panel);
		panel.add(add);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/intro_to_file_io/ToDoList.txt"));
			String line = br.readLine();
			while(line != null){	
				int space = line.indexOf(" ");
				String a = line.substring(0, space);
				int revive = Integer.parseInt(a);
				String b = line.substring(space+1,line.length());
				ash.put(revive, b);
				line = br.readLine();
		}
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(add)) {
			String task = JOptionPane.showInputDialog("Add a task to list.");
			String in = JOptionPane.showInputDialog("Enter an ID number for that task.");
			int order = Integer.parseInt(in);
			ash.put(order, task);
		}
		if (e.getSource().equals(remove)) {
			String aids = JOptionPane.showInputDialog("Enter an ID number.");
			int aid = Integer.parseInt(aids);
			if (ash.containsKey(aid)) {
				ash.remove(aid);
				JOptionPane.showMessageDialog(null, "Task successfully removed.");
			} else {
				JOptionPane.showMessageDialog(null, "That task does not exist.");
			}
		}
		if(e.getSource().equals(save)) {
			System.out.println(ash);
			FileWriter fw = null;
			try {
				fw = new FileWriter("src/intro_to_file_io/ToDoList.txt",true);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			for(Integer i : ash.keySet()) {
				try {
					fw.write(i+" "+ash.get(i)+"\n");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			try {
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource().equals(load)) {
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/intro_to_file_io/ToDoList.txt"));
				String line = br.readLine();
				while(line != null){	
					JOptionPane.showMessageDialog(null, line);
					line = br.readLine();
				}
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}