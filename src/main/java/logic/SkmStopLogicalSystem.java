package logic;

import java.util.HashMap;
import java.util.Map;

import dataBases.SkmStopDb;
import domain.SkmStop;

public class SkmStopLogicalSystem {

	private static Map<SkmStop, SkmStop> travel = new HashMap<>();

	public void addStop(String skmStopName, Integer distanceToGdanskSrodmiescie) {

		SkmStop skmStop = new SkmStop();
		skmStop.setName(skmStopName);
		skmStop.setDistanceToGdanskSrodmiescie(distanceToGdanskSrodmiescie);
		SkmStopDb.add(skmStop);

	}
	
	public Integer calculateSkmDistance(SkmStop skmStopEnd, SkmStop skmStopStart) {

		Integer skmDistance = skmStopEnd.getDistanceToGdanskSrodmiescie() - skmStopStart.getDistanceToGdanskSrodmiescie();
		return skmDistance < 0 ? (-1 * skmDistance) : skmDistance;
	}
	
	public static void getPairOfStops(SkmStop skmStopStart, SkmStop skmStopEnd) {

		travel.put(skmStopStart, skmStopEnd);

	}
}
