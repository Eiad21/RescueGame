package model.disasters;

import exceptions.BuildingAlreadyCollapsedException;
import exceptions.CitizenAlreadyDeadException;
import simulation.Rescuable;
import simulation.Simulatable;

public abstract class Disaster implements Simulatable{
	private int startCycle;
	private Rescuable target;
	private boolean active;
	public Disaster(int startCycle, Rescuable target) {
		this.startCycle = startCycle;
		this.target = target;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getStartCycle() {
		return startCycle;
	}
	public Rescuable getTarget() {
		return target;
	}
	public void strike() throws CitizenAlreadyDeadException, BuildingAlreadyCollapsedException 
	{
		
		target.struckBy(this);
		active=true;
	}
	public String getDisasterType() {
		if (this instanceof Collapse)
			return "Collapse";
		else if (this instanceof Fire)
			return "Fire";
		else if (this instanceof GasLeak)
			return "GasLeak";
		else if (this instanceof Infection)
			return "Infection";
		else
			return "Injury";
	}
}
