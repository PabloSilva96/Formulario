package myapp;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	private TextPanel textPanel;
	private Toolbar toolbar;
	private FormPanel formPanel;
	
	public MainFrame() {
		
		super("Hello World");
		
		setLayout(new BorderLayout());
		
		textPanel = new TextPanel();
		toolbar = new Toolbar();
		formPanel = new FormPanel();
		
		add(textPanel, BorderLayout.CENTER);
		add(toolbar, BorderLayout.NORTH);
		add(formPanel,BorderLayout.WEST);
		

		formPanel.setFormListener(new FormListener() {

			@Override
			public void formEventOccurred(FormEvent e) {
				
				String name = e.getName();
				String occupation = e.getOccupation();
				int ageCategory = e.getAgeCategory();
				String empCat = e.getEmpCat();
				String comboCat = e.getcomboCat();
				String taxID = e.getTaxID();
				
				textPanel.appendText("Name: " + name + ": Occupation: " + occupation + ": AgeCat: " + ageCategory + ": EmpCat: " + empCat +comboCat +": TaxID : "+ taxID + "\n"); 
			}
		});
		
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,500);
		setVisible(true);
	}
	
	
}
