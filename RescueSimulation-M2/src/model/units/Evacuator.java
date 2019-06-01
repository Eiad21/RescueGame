package model.units;

import exceptions.CannotTreatException;
import exceptions.IncompatibleTargetException;
import model.events.WorldListener;
import model.infrastructure.ResidentialBuilding;
import simulation.Address;
import simulation.Rescuable;

public class Evacuator extends PoliceUnit {

	public Evacuator(String unitID, Address location, int stepsPerCycle,
			WorldListener worldListener, int maxCapacity) {
		super(unitID, location, stepsPerCycle, worldListener, maxCapacity);

	}

	@Override
	public void treat() {
		ResidentialBuilding target = (ResidentialBuilding) getTarget();
		if (target.getStructuralIntegrity() == 0
				|| target.getOccupants().size() == 0) {
			jobsDone();
			return;
		}

		for (int i = 0; getPassengers().size() != getMaxCapacity()
				&& i < target.getOccupants().size(); i++) {
			getPassengers().add(target.getOccupants().remove(i));
			i--;
		}

		setDistanceToBase(target.getLocation().getX()
				+ target.getLocation().getY());

	}
	@Override
	public void respond(Rescuable r) throws IncompatibleTargetException, CannotTreatException {
		if(r instanceof ResidentialBuilding){
			ResidentialBuilding x = (ResidentialBuilding) r;
		if(x.getFoundationDamage()==0){
			throw new CannotTreatException(this,x,"Yalahwiiiiiiiiii");
		}
		}
		else{
			throw new IncompatibleTargetException(this,r,"8lt ya bnl 7omra");
		}
	}
	
//	if(r instanceof ResidentialBuilding){
//		ResidentialBuilding x = (ResidentialBuilding) r;
//		if(x.getFoundationDamage()==0){
//			throw new CannotTreatException(this,x,"Yalahwiiiiiiiiii");
//		}
//	}
//	else{
//		throw new IncompatibleTargetException(this,r,"8lt ya bnl 7omra");
//	}

}
