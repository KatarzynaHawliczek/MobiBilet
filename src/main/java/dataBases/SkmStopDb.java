package dataBases;

import java.util.ArrayList;
import java.util.List;

import domain.SkmStop;
import logic.SkmStopLogicalSystem;

public class SkmStopDb {

	private static List<SkmStop> skmStopDb = new ArrayList<SkmStop>();
	private static SkmStopLogicalSystem skmStopLogicalSystem = new SkmStopLogicalSystem();

	static {

		skmStopLogicalSystem.addStop("Gdańsk Śródmieście", 0);
		skmStopLogicalSystem.addStop("Gdańsk Główny", 1);
		skmStopLogicalSystem.addStop("Gdańsk Stocznia", 2);
		skmStopLogicalSystem.addStop("Gdańsk Politechnika", 4);
		skmStopLogicalSystem.addStop("Gdańsk Wrzeszcz", 5);
		skmStopLogicalSystem.addStop("Gdańsk Zaspa", 6);
		skmStopLogicalSystem.addStop("Gdańsk Przymorze-Uniwersytet", 8);
		skmStopLogicalSystem.addStop("Gdańsk Oliwa", 9);
		skmStopLogicalSystem.addStop("Gdańsk Żabianka-AWFiS", 10);
		skmStopLogicalSystem.addStop("Sopot Wyścigi", 11);
		skmStopLogicalSystem.addStop("Sopot", 13);
		skmStopLogicalSystem.addStop("Sopot Kamienny Potok", 14);
		skmStopLogicalSystem.addStop("Gdynia Orłowo", 17);
		skmStopLogicalSystem.addStop("Gdynia Redłowo", 18);
		skmStopLogicalSystem.addStop("Gdynia Wzgórze Św. Maksymiliana", 20);
		skmStopLogicalSystem.addStop("Gdynia Główna", 22);
		skmStopLogicalSystem.addStop("Gdynia Stocznia", 23);
		skmStopLogicalSystem.addStop("Gdynia Grabówek", 25);
		skmStopLogicalSystem.addStop("Gdynia Leszczynki", 26);
		skmStopLogicalSystem.addStop("Gdynia Chylonia", 27);
		skmStopLogicalSystem.addStop("Gdynia Cisowa", 28);
		skmStopLogicalSystem.addStop("Rumia Janowo", 31);
		skmStopLogicalSystem.addStop("Rumia", 33);
		skmStopLogicalSystem.addStop("Reda", 36);
		skmStopLogicalSystem.addStop("Reda Pieleszewo", 39);
		skmStopLogicalSystem.addStop("Wejherowo Śmiechowo", 42);
		skmStopLogicalSystem.addStop("Wejherowo Nanice", 44);
		skmStopLogicalSystem.addStop("Wejherowo", 45);
		skmStopLogicalSystem.addStop("Gościcino Wejherowskie", 50);
		skmStopLogicalSystem.addStop("Luzino", 55);
		skmStopLogicalSystem.addStop("Strzebielino Morskie", 60);
		skmStopLogicalSystem.addStop("Bożepole Wielkie", 65);
		skmStopLogicalSystem.addStop("Godętowo", 71);
		skmStopLogicalSystem.addStop("Lębork Mosty", 77);
		skmStopLogicalSystem.addStop("Lębork", 81);

	}

	public static List<SkmStop> getSkmStopDb() {

		return skmStopDb;
	}

	public static void setSkmStopDb(List<SkmStop> db) {

		SkmStopDb.skmStopDb = db;
	}

	public static void add(SkmStop skmStop) {

		Long id = generateId(skmStop);
		skmStop.setId(id);

		skmStopDb.add(skmStop);

	}

	public static Long generateId(SkmStop skmStop) {

		return Long.valueOf("" + (skmStopDb.size() + 1));
	}

}
