package myapp;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {

	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField nameField;
	private JTextField occupationField;
	private JButton okBtn;
	private JList ageList;
	private JComboBox empCombo;	
	private JCheckBox citizenCheck;
	private JTextField taxField;
	private JLabel taxLabel;
	private JComboBox combobreaker;	
	private FormListener formListener;
	
	public void setFormListener(FormListener formListener) {
		this.formListener = formListener;
	}

	public FormPanel() {
		
		Dimension dim = getPreferredSize();
		dim.width = 250;
			
		setPreferredSize(dim);
		
		nameLabel = new JLabel("Name");
		occupationLabel = new JLabel("Occupation");
		nameField = new JTextField(10);
		occupationField = new JTextField(10);
		
		citizenCheck = new JCheckBox();
		taxField = new JTextField(10);
		taxLabel = new JLabel("tax ID");
		
		
		ageList = new JList();
		
		ageList.setPreferredSize(new Dimension(110, 68));
		ageList.setBorder(BorderFactory.createEtchedBorder());
			
		DefaultListModel ageModel = new DefaultListModel();
		ageModel.addElement(new AgeCategory(0, "Under 18"));
		ageModel.addElement(new AgeCategory(1, "18 to 65"));
		ageModel.addElement(new AgeCategory(2, "Over 65"));
		
		ageList.setModel(ageModel);
		
		ageList.setSelectedIndex(1);
		
		empCombo = new JComboBox();
		DefaultComboBoxModel empModel = new DefaultComboBoxModel();
		empModel.addElement("emp");
		empModel.addElement("self-emp");
		empModel.addElement("unemployed");
		
		empCombo.setModel(empModel);
		
		empCombo.setEditable(true);
		empCombo.setSelectedIndex(0);
		
		combobreaker = new JComboBox();
		DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
		comboModel.addElement("co");
		comboModel.addElement("coco");
		comboModel.addElement("combo breaker");
		
		combobreaker.setModel(comboModel);
		
		combobreaker.setEditable(true);
		combobreaker.setSelectedIndex(0);		
		
		
		okBtn = new JButton("OK");
		
		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);	
		Border compoundBorder = BorderFactory.createCompoundBorder(outerBorder, innerBorder);
		setBorder(compoundBorder);
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		// Name Row
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(nameLabel,gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		
		add(nameField,gc);
		
		// Occupation Row
		gc.gridy++;
		
		gc.gridx = 0;
		
		
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.LINE_END;

		add(occupationLabel,gc);
		
		gc.gridx = 1;
		
		
		add(occupationField,gc);
		
		// Age List
		
		gc.gridx = 0;
		gc.gridy++;
		
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;

		add(new JLabel("Age:"),gc);
	
		gc.gridx = 1;
		
		
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		
		add(ageList,gc);
		
		// Emp Combo
		
		gc.gridx = 0;
		gc.gridy++;
		
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.LINE_END;

		add(new JLabel("Employment:"),gc);
	
		gc.gridx = 1;
		
		
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		
		add(empCombo,gc);
		
		//combo breaker
		gc.gridx = 0;
		gc.gridy++;
		
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.LINE_END;

		add(new JLabel("combaso:"),gc);
	
		gc.gridx = 1;
		
		
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		
		add(combobreaker,gc);
		
		// citizen check row
		gc.gridy++;
		gc.gridx = 0;
		
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.LINE_END;
		
		add(new JLabel("US Citizen :"),gc);
		
		gc.gridx=1;
		
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(citizenCheck,gc);
		
		//tax field
		gc.gridy++;
		gc.gridx = 0;
		
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.LINE_END;
		
		add(new JLabel("Tax ID :"),gc);
		
		gc.gridx=1;
		
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(taxField,gc);
		
		// Ok Button
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 1;
		gc.gridy++;
		
		add(okBtn,gc);
		
		okBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String name = nameField.getText();
				String occupation = occupationField.getText();
				AgeCategory ageCat = (AgeCategory) ageList.getSelectedValue();
				String empCat = (String)empCombo.getSelectedItem();
				String comboCat = (String)combobreaker.getSelectedItem();
				String taxID = taxField.getText();
				
				FormEvent event = new FormEvent(this,name,occupation,ageCat.getId(),empCat,comboCat,taxID);
				
				if (formListener != null) {
					formListener.formEventOccurred(event);
				}
			}
		});
	}
	
}
