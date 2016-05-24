import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class UI {
	
	private JPanel boardPanel,optionPanel;
	private JCheckBox white,black;
	
	public UI(){
		JFrame frame = new JFrame("Happy Connect6");
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		
		frame.setLayout(gbl);
		
		
		boardPanel = new BoardUI();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 5.0;
		gbc.weighty = 1.0;
		frame.add(boardPanel,gbc);
		
		optionPanel =  optionPanel();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		frame.add(optionPanel,gbc);
		white.setSelected(true);


		placingstoneListener listener = new placingstoneListener((BoardUI) boardPanel);
		frame.addMouseListener(listener);

		frame.setSize(1024,750);
		frame.setLocationRelativeTo(null);
		frame.setMinimumSize(new Dimension(1024,740));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	public JPanel optionPanel(){
		JPanel optionPanel = new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		ButtonGroup group = new ButtonGroup();
		
		optionPanel.setLayout(gbl);
		optionPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Choose stone color"));
		
		white = new JCheckBox("White");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.weightx = 1.0;
		optionPanel.add(white, gbc);
		group.add(white);
		//white.setSelected(true);
		
		black = new JCheckBox("Black");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(10, 10, 10, 10);
		optionPanel.add(black, gbc);
		group.add(black);
		
		JButton setPlayer = new JButton("Start");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.weightx = 0.1;
		gbc.insets = new Insets(10, 10, 10, 10);
		optionPanel.add(setPlayer,gbc);
		setPlayer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setPlayerAction(e);
			}
		});
		
		return optionPanel;	
	}
	
	private void setPlayerAction(ActionEvent e){
		white.setEnabled(false);
		black.setEnabled(false);
		if(white.isSelected())
			((BoardUI) boardPanel).start("white");
		else
			((BoardUI) boardPanel).start("black");
	}

	
	public static void main(String args[]){
		new UI();
	}

	
}
