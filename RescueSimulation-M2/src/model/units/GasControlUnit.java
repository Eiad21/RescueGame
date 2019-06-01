package model.units;

import exceptions.CannotTreatException;
import exceptions.IncompatibleTargetException;
import model.events.WorldListener;
import model.infrastructure.ResidentialBuilding;
import simulation.Address;
import simulation.Rescuable;

public class GasControlUnit extends FireUnit {

	public GasControlUnit(String unitID, Address location, int stepsPerCycle,
			WorldListener worldListener) {
		super(unitID, location, stepsPerCycle, worldListener);
	}

	public void treat() {
		getTarget().getDisaster().setActive(false);

		ResidentialBuilding target = (ResidentialBuilding) getTarget();
		if (target.getStructuralIntegrity() == 0) {
			jobsDone();
			return;
		} else if (target.getGasLevel() > 0) 
			target.setGasLevel(target.getGasLevel() - 10);

		if (target.getGasLevel() == 0)
			jobsDone();

	}
	@Override
	public void respond(Rescuable r) throws IncompatibleTargetException, CannotTreatException {
		if(r instanceof ResidentialBuilding){
			ResidentialBuilding x = (ResidentialBuilding) r;
		if(x.getGasLevel()==0){
			throw new CannotTreatException(this,x,"Yalahwiiiiiiiiii");
		}
		}
		else{
			throw new IncompatibleTargetException(this,r,"8lt ya bnl 7omra");
		}
	}

}
