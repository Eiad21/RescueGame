package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.IconView;

import model.infrastructure.ResidentialBuilding;
import model.people.Citizen;
import model.units.UnitState;
import controller.CommandCenter;

public class Game_View extends JFrame implements ActionListener{
////PARAMETERS FOR ACTIONLISTENER/////	
	private int x;
	private int y;
	private JButton nextCycle;
///INTIALIZATION OF JPANALS///
	public JPanel North_Panel;	public JPanel Centre_Panel; JPanel West_Panel;
	public JPanel East_Panel; JPanel South_Panel;
	public JPanel Panel_1; JPanel Panel_2;
	public JPanel Panel_3; JPanel Panel_4;
	
///INTIALIZATION OF BUTTONS OF UNITS///
//JButton b1;JButton b2;
//JButton b3;JButton b4;
///INTIALIZATION OF LABELS OF UNITS///
//JLabel label_Units;
//JLabel label_Units_AMB;JLabel label_Units_DCU;
//JLabel label_Units_FTK;JLabel label_Units_GCU;
///INTIALIZATION OF INFO///
JTextArea log;
JLabel label_INFO;
JTextArea INFO;
///INTIALIZATION OF THE GRID///
public JButton[][] grid;
///INTIALIZATION OF COMMAND CENTRE////
CommandCenter command;
/////////////////////////////////////
JButton[] Unit_Grid;
JTextArea cellInfo;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
public Game_View (){
	setPreferredSize(new Dimension(1600,1200));
///INTIALIZATION OF JPANALS///
	Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	TitledBorder title = BorderFactory.createTitledBorder(loweredetched,"Cell Info:");
////////////////////////////WEST//////////////////////////
	West_Panel = new JPanel();
	West_Panel.setPreferredSize(new Dimension(400,400));
	this.getContentPane().add(West_Panel, BorderLayout.WEST);
////////////////////////////EAST//////////////////////////
East_Panel = new JPanel();
East_Panel.setPreferredSize(new Dimension(400,400));
this.getContentPane().add(East_Panel, BorderLayout.EAST);
East_Panel.setLayout(new GridLayout(3, 1));
////////////////////////////SOUTH//////////////////////////
South_Panel = new JPanel();
South_Panel.setPreferredSize(new Dimension(500, 100));
this.getContentPane().add(South_Panel, BorderLayout.SOUTH);
South_Panel.setLayout(new GridLayout(1, 1));
////////////////////////////NORTH//////////////////////////
North_Panel = new JPanel();
this.getContentPane().add(North_Panel, BorderLayout.NORTH);
North_Panel.setLayout(new GridLayout(1, 2));
////////////////////////////CENTRE//////////////////////////
Centre_Panel = new JPanel();
Centre_Panel.setPreferredSize(new Dimension(800, 800));
Centre_Panel.setLayout(new GridLayout(10, 10));
this.getContentPane().add(Centre_Panel, BorderLayout.CENTER);
////////////////////////////////////////////////////////////
Panel_1 = new JPanel(new GridLayout(3, 2));
loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
title = BorderFactory.createTitledBorder(loweredetched, "Idle Units");
Panel_1.setBorder(title);
East_Panel.add(Panel_1);

Panel_2 = new JPanel(new GridLayout(3, 2));
loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
title = BorderFactory.createTitledBorder(loweredetched,"Units IN RESPONDING");
Panel_2.setBorder(title);
East_Panel.add(Panel_2);

Panel_3 = new JPanel(new GridLayout(3, 2));
loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
title = BorderFactory.createTitledBorder(loweredetched,"Treating Units");
Panel_3.setBorder(title);
East_Panel.add(Panel_3);
////////////////////////////CENTRE//////////////////////////
grid = new JButton[10][10];

//updateGrid();
/////////////////////////////////////////////////////////////
West_Panel.setLayout(new GridLayout(1, 1));
West_Panel.setBorder(title);

	Unit_Grid = new JButton[5];
	Unit_Grid[0]=new JButton();
	Unit_Grid[0].setIcon(new ImageIcon("EVC.png"));
	Unit_Grid[0].setPreferredSize(new Dimension(100, 100));
	
////////////////////////////SOUTH//////////////////////////
loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
title = BorderFactory.createTitledBorder(loweredetched, "Log:");
South_Panel.setBorder(title);
log = new JTextArea();
log.setLineWrap(true);
log.setWrapStyleWord(true);
log.setEnabled(false);
log.setEditable(false);
JScrollPane sc2 = new JScrollPane(log);
South_Panel.add(sc2);
//updateLogInfo();
////////////////////////////NORTH//////////////////////////
loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
title = BorderFactory.createTitledBorder(loweredetched,
"Simulation Info:");
North_Panel.setBorder(title);
INFO = new JTextArea();
INFO.setLineWrap(true);
INFO.setWrapStyleWord(true);
//simInfo.setEnabled(false);
//simInfo.setEditable(false);
JScrollPane sc1 = new JScrollPane(INFO);
North_Panel.add(sc1);

//updateSimInfo();


nextCycle = new JButton("Next Cycle");
nextCycle.addActionListener(this);
North_Panel.add(nextCycle);
//////////////////////////////////////////////////////////

	this.setSize(1200, 700);
	this.setVisible(true);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	
	

	////INTIALIZATION OF THE J FRAME////
	this.setLayout(null);
	this.setSize(1920,1080);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setVisible(true);
//	////Label OF INFORMATIONS////
//	label_INFO = new JLabel("INFO");
//	label_INFO.setBounds(0, 0, 100, 30);
//	label_INFO.setFont(getFont());
//	label_INFO.setForeground(Color.BLACK);
//	this.getContentPane().add(label_INFO);
//	////Text Area of INFO////
//	INFO = new JTextArea();
//	INFO.setBounds(0, 20, 300, 600);
//	INFO.setEditable(false);
//	this.getContentPane().add(INFO);
	////Label OF Units////
//	label_Units = new JLabel("Units");
//	label_Units.setBounds(1650, 0, 100, 30);
//	label_Units.setFont(getFont());
//	label_Units.setForeground(Color.BLACK);
//	this.getContentPane().add(label_Units);
	
//	label_Units_AMB = new JLabel("Ambulance");
//	label_Units_AMB.setBounds(1400, 25, 100, 30);
//	label_Units_AMB.setFont(getFont());
//	label_Units_AMB.setForeground(Color.BLACK);
//	this.getContentPane().add(label_Units_AMB);
//	
//	label_Units_DCU = new JLabel("Diases Control Unit");
//	label_Units_DCU.setBounds(1790, 25, 150, 30);
//	label_Units_DCU.setFont(getFont());
//	label_Units_DCU.setForeground(Color.BLACK);
//	this.getContentPane().add(label_Units_DCU);
//	
//	
	////BUTTONS OF UNITS////
//	b1 = new JButton ();
//	b1.setLayout(null);
//	b1.setBounds(1400, 50, 100, 100);
//	b1.setVisible(true);
//	this.getContentPane().add(b1);
//	
//	b2 = new JButton ();
//	b2.setLayout(null);
//	b2.setBounds(1800, 50, 100, 30);
//	b2.setVisible(true);
//	this.getContentPane().add(b2);
//	
//	b3 = new JButton ();
//	b3.setLayout(null);
//	b3.setBounds(1400, 450, 100, 30);
//	b3.setVisible(true);
//	this.getContentPane().add(b3);
//	
//	b4 = new JButton ();
//	b4.setLayout(null);
//	b4.setBounds(1800,450, 100, 30);
//	b4.setVisible(true);
//	this.getContentPane().add(b4);
	///BOARD BUTTONS///
	grid = new JButton[10][10];
	
	
}
	
public void updateLogInfo() {
	log.append(command.getEngine().getLog());
}

public void updateSimInfo() {
	INFO.setText(command.getEngine().toString());
}

public void updateUnitsBetweenPanels() {
	Panel_1.removeAll();
	Panel_2.removeAll();
	Panel_3.removeAll();

	for (int i = 0; i < grid.length; i++) {
		if (command.getEmergencyUnits().get(i).getState() == UnitState.IDLE) {
			Panel_1.add(Unit_Grid[i]);
		} else if (command.getEmergencyUnits().get(i).getState() == UnitState.RESPONDING) {
			Panel_2.add(Unit_Grid[i]);
		} else {
			Panel_3.add(Unit_Grid[i]);
		}
	}
	East_Panel.validate();
	East_Panel.repaint();
}


@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource() == nextCycle) {
		try {
			command.getEngine().nextCycle();
			
			updateGrid();
			updateSimInfo();
			updateLogInfo();
			updateUnitsBetweenPanels();
			
			if (command.getEngine().checkGameOver()) {
				String msg = "Gameover & #Casualties = "
						+ command.getEngine().calculateCasualties();

				JOptionPane.showMessageDialog(this, msg, "info",
						JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	for (int i = 0; i < Unit_Grid.length; i++) {
		if (e.getSource() == Unit_Grid[i]) {
			try {
				command.respondToRescuble(i, x, y);
				updateUnitsBetweenPanels();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage(),
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 10; j++) {
			if (e.getSource() == grid[i][j]) {
				INFO.setText(command.getCellInfo(i, j));
				x = i;
				y = j;
			}
		}
		
	}
	
	}
public void updateGrid() {
	for (int i = 0; i < command.getEngine().getCitizens().size(); i++) {
		Citizen r = command.getEngine().getCitizens().get(i);
		grid[r.getLocation().getX()][r.getLocation().getY()]
				.setIcon(new ImageIcon("citizens.png"));
		if (r.getDisaster() != null) {
			grid[r.getLocation().getX()][r.getLocation().getY()]
					.setBackground(Color.RED);
		} else {
			grid[r.getLocation().getX()][r.getLocation().getY()]
					.setBackground(Color.GREEN);
			}
	}
	for (int i = 0; i < command.getEngine().getBuildings().size(); i++) {
		ResidentialBuilding r = command.getEngine().getBuildings().get(i);
		if (r.getOccupants().size() == 0) {
			grid[r.getLocation().getX()][r.getLocation().getY()]
					.setIcon(new ImageIcon("buildings.png"));
		} else {
			grid[r.getLocation().getX()][r.getLocation().getY()]
					.setIcon(new ImageIcon("BuildingCitizen.png"));
		}

		if (r.getDisaster() != null) {
			grid[r.getLocation().getX()][r.getLocation().getY()]
					.setBackground(Color.RED);
		} else {
			grid[r.getLocation().getX()][r.getLocation().getY()]
					.setBackground(Color.GREEN);
		}
	}
}

}
