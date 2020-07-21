package myapp;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener {

		private JButton helloButton;
		private JButton goodbyeButton;
		
		private StringListener stringListener;
	
		public Toolbar() {
			
			helloButton = new JButton("Hello");
			goodbyeButton = new JButton("Goodbye");
		
			helloButton.addActionListener(this); 			
			goodbyeButton.addActionListener(this);
			
			setLayout(new FlowLayout(FlowLayout.LEFT));
			
			add(helloButton);
			add(goodbyeButton);
		}

		public void setStringListener(StringListener stringListener) {
			this.stringListener = stringListener;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JButton clickedButton = (JButton) e.getSource();

			if (stringListener != null) {
				if (clickedButton == helloButton) {
					stringListener.textEmmited("Hello\n");
				}
				else if (clickedButton == goodbyeButton) {
					stringListener.textEmmited("Goodbye\n");
				}
			}
		}
}
