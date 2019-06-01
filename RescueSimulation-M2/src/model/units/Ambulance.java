package model.units;

import exceptions.CannotTreatException;
import exceptions.IncompatibleTargetException;
import model.events.WorldListener;
import model.people.Citizen;
import model.people.CitizenState;
import simulation.Address;
import simulation.Rescuable;

public class Ambulance extends MedicalUnit {

	public Ambulance(String unitID, Address location, int stepsPerCycle,
			WorldListener worldListener) {
		super(unitID, location, stepsPerCycle, worldListener);
	}

	@Override
	public void treat() {
		getTarget().getDisaster().setActive(false);

		Citizen target = (Citizen) getTarget();
		if (target.getHp() == 0) {
			jobsDone();
			return;
		} else if (target.getBloodLoss() > 0) {
			target.setBloodLoss(target.getBloodLoss() - getTreatmentAmount());
			if (target.getBloodLoss() == 0)
				target.setState(CitizenState.RESCUED);
		}

		else if (target.getBloodLoss() == 0)

			heal();

	}
@Override
	public void respond(Rescuable r) throws IncompatibleTargetException,CannotTreatException {
		if(r instanceof Citizen){
			Citizen x = (Citizen) r;
			if(x.getBloodLoss()==0){
				throw new CannotTreatException(this,x,"Yalahwiiiiiiiiii");
			}
		}
		else{
			throw new IncompatibleTargetException(this,r,"8lt ya bnl 7omra");
		}
	}

}
