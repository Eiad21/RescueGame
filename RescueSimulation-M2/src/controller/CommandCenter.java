package controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import exceptions.CannotTreatException;
import exceptions.IncompatibleTargetException;
import model.events.SOSListener;
import model.infrastructure.ResidentialBuilding;
import model.people.Citizen;
import model.units.Unit;
import simulation.Rescuable;
import simulation.Simulator;
import view.Game_View;

public class CommandCenter implements SOSListener, ActionListener {

	private Simulator engine;
	private ArrayList<ResidentialBuilding> visibleBuildings;
	private ArrayList<Citizen> visibleCitizens;
	public Game_View gameView;
	private ArrayList<Rescuable>[][] occupants;

	@SuppressWarnings("unused")
	private ArrayList<Unit> emergencyUnits;

	public CommandCenter() throws Exception {
		occupants = new ArrayList[10][10];
		engine = new Simulator(this);
		visibleBuildings = new ArrayList<ResidentialBuilding>();
		visibleCitizens = new ArrayList<Citizen>();
		emergencyUnits = engine.getEmergencyUnits();
		gameView = new Game_View();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				occupants[i][j] = new ArrayList<Rescuable>();
				JButton b = new JButton();
				b.setActionCommand(i+" "+j);
				b.setPreferredSize(new Dimension(190,170));
				gameView.grid[i][j] = b;
				b.addActionListener(this);
				gameView.Centre_Panel.add(gameView.grid[i][j]);
			}
			}
		gameView.repaint();
		gameView.validate();

	}

	@Override
	public void receiveSOSCall(Rescuable r) {
		occupants[r.getLocation().getX()][r.getLocation().getY()].add(r);
		if (r instanceof ResidentialBuilding) {
			
			if (!visibleBuildings.contains(r))
				visibleBuildings.add((ResidentialBuilding) r);
			
		} else {
			
			if (!visibleCitizens.contains(r))
				visibleCitizens.add((Citizen) r);
		}

	}

	public Simulator getEngine() {
		return engine;
	}
	public ArrayList<Citizen> getVisibleCitizens() {
		return visibleCitizens;
	}

	public ArrayList<Unit> getEmergencyUnits() {
		return emergencyUnits;
	}

	public String getCellInfo(int x, int y) {
		String s = "";
		for (int i = 0; i < engine.getBuildings().size(); i++) {
			ResidentialBuilding r = engine.getBuildings().get(i);
			if (r.getLocation().getX() == x && r.getLocation().getY() == y) {
				s = s + r.toString();
			}
		}
		for (int i = 0; i < engine.getCitizens().size(); i++) {
			Citizen c = engine.getCitizens().get(i);
			if (c.getLocation().getX() == x && c.getLocation().getY() == y) {
				s = s + c.toString();
			}
		}
		for (int i = 0; i < engine.getEmergencyUnits().size(); i++) {
			Unit u = engine.getEmergencyUnits().get(i);
			if (u.getLocation().getX() == x && u.getLocation().getY() == y) {
				s = s + u.toString();
			}
		}
		return s;
	}

	public void respondToRescuble(int index, int x, int y)
			throws IncompatibleTargetException, CannotTreatException {
		Rescuable r = null;
		for (int i = 0; i < visibleCitizens.size(); i++) {
			if (visibleCitizens.get(i).getLocation().getX() == x
					&& visibleCitizens.get(i).getLocation().getY() == y) {
				r = visibleCitizens.get(i);
			}
		}
		for (int i = 0; i < visibleBuildings.size(); i++) {
			if (visibleBuildings.get(i).getLocation().getX() == x
					&& visibleBuildings.get(i).getLocation().getY() == y) {
				r = visibleBuildings.get(i);
			}
		}
		if (r == null) {
			return;
		}
		emergencyUnits.get(index).respond(r);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		int i = Integer.parseInt(source.getActionCommand().charAt(0)+"");
		int j = Integer.parseInt(source.getActionCommand().charAt(2)+"");
		System.out.println("You clicked on button "+i+" "+j);
		
		
	}
	public static void main(String[]args) throws Exception {
		new CommandCenter();
	}

}
